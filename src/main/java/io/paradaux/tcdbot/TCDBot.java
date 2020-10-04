package io.paradaux.tcdbot;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import io.paradaux.tcdbot.api.ConfigurationCache;
import io.paradaux.tcdbot.listeners.ReadyListener;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.security.krb5.Config;

import javax.security.auth.login.LoginException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TCDBot {

    private static Logger logger;
    public static Logger getLogger() { return logger; }

    private static JDA client;

    private static ConfigurationCache configurationCache;
    public static ConfigurationCache getConfigurationCache() { return configurationCache; }

    public static void main(String[] args) {
        TCDBot bot = new TCDBot();
    }

    public TCDBot() {
        logger = LoggerFactory.getLogger(getClass());
        logger.info("TCDBot is starting.");

        try {
            configurationCache = readConfigurationFile();
        } catch (FileNotFoundException exception) {
            logger.error("Cannot find the configuration file.");
            return;
        }

        client = login(configurationCache.getToken());
    }

    @Nullable
    public JDA login(String token) {
        JDABuilder builder = JDABuilder.createDefault(token);

        builder.disableCache(CacheFlag.MEMBER_OVERRIDES, CacheFlag.VOICE_STATE);
        builder.setBulkDeleteSplittingEnabled(false);

        builder.addEventListeners(new ReadyListener(logger));

        if (token == null) {
            logger.warn("You have not set the token for your discord bot for discord2mc functionality. This has been disabled.");
            return null;
        }

        try {
            return builder.build();
        } catch(LoginException exception) {
            logger.warn("TCDBot failed to login with the provided token.");
            return null;
        }
    }

    public ConfigurationCache readConfigurationFile() throws FileNotFoundException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("configuration.json"));
        return gson.fromJson(bufferedReader, ConfigurationCache.class);
    }
}
