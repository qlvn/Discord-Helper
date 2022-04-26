package me.joel.discordbot.core;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public abstract class Command extends ListenerAdapter {

    public abstract String call();
    public abstract String help();
    public abstract boolean execute(String[] args, GuildMessageReceivedEvent event);

}
