package me.joel.discordbot.core;

import me.joel.discordbot.DiscordBot;
import me.joel.discordbot.utils.Config;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.ArrayList;

public class CommandManager extends ListenerAdapter {

    private static final ArrayList<Command> commands = new ArrayList<>();

    public void load() {
        DiscordBot.jda.addEventListener(this);
        commands.forEach(obj -> DiscordBot.jda.addEventListener(obj));
    }

    public static void addCommand(Object obj) {
        commands.add((Command) obj);
    }

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        String[] message = event.getMessage().getContentRaw().trim().split(" ");
        String invoke = message[0];
        String call = invoke.replace(Config.INVOKE, "");
        String[] args = message;

        commands.forEach(cmd -> {
            if(invoke.startsWith(Config.INVOKE) && cmd.call().equalsIgnoreCase(call) && !event.getAuthor().isBot()) {
                cmd.execute(args, event);
            }
        });

    }

}
