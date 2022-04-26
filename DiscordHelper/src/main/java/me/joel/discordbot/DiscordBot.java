package me.joel.discordbot;

import me.joel.discordbot.command.ChatClearCommand;
import me.joel.discordbot.core.CommandManager;
import me.joel.discordbot.utils.Config;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class DiscordBot {

    public static JDA jda;

    public static void main(String[] args) throws LoginException {
        jda = JDABuilder.createDefault(Config.TOKEN).build();

        new CommandManager().load();

        CommandManager.addCommand(new ChatClearCommand());
    }

}
