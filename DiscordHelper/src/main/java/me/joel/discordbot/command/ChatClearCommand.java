package me.joel.discordbot.command;

import me.joel.discordbot.core.Command;
import me.joel.discordbot.utils.Config;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageHistory;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.util.List;

public class ChatClearCommand extends Command {
    @Override
    public String call() {
        return "clear";
    }

    @Override
    public String help() {
        return Config.INVOKE + "clear <amount>";
    }

    @Override
    public boolean execute(String[] args, GuildMessageReceivedEvent event) {

        if (args.length == 2) {

            event.getMessage().delete().queue();

            int amount = Integer.parseInt(args[1]);
            if (amount >= 1 && amount <= 100) {

                MessageHistory history = new MessageHistory(event.getChannel());
                List<Message> messages;
                messages = history.retrievePast(amount).complete();
                event.getChannel().deleteMessages(messages).queue();


            } else {
                event.getChannel().sendMessage("Bitte gebe eine Zahl zwischen 1 & 100 an!").queue();
            }

        } else {
            event.getChannel().sendMessage("Bitte benutze .clear <amount>").queue();
        }

        return false;
    }
}
