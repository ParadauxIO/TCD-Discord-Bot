package io.paradaux.tcdbot.listeners;

import io.paradaux.tcdbot.api.ConfigurationCache;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class MessageReceivedListener extends ListenerAdapter {

    ConfigurationCache configurationCache;

    public MessageReceivedListener(ConfigurationCache configurationCache) {
        this.configurationCache = configurationCache;
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        MessageChannel channel = event.getMessage().getChannel();
    }
}
