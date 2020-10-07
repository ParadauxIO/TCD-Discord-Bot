package io.paradaux.tcdbot.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class InviteCommand extends Command {

    public InviteCommand(String name, String[] aliases, String help) {
        this.name = "invite";
        this.aliases = new String[] {"inv", "i"};
        this.help = "Gives an invite link.";
    }

    @Override
    protected void execute(CommandEvent commandEvent) {

    }
}
