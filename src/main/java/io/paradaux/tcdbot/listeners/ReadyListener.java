package io.paradaux.tcdbot.listeners;

import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.slf4j.Logger;

public class ReadyListener extends ListenerAdapter {

    Logger logger;

    public ReadyListener(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void onReady(ReadyEvent event) {
        logger.info("TCDBot has logged in successfully.");
        logger.info("Serving " + event.getGuildTotalCount() + " guilds.");
    }

}
