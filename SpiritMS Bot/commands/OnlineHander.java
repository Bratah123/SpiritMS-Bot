package net.swordie.ms.bot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.swordie.ms.Server;
import net.swordie.ms.bot.constants.BotConstants;

import java.awt.*;

public class OnlineHander extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e){
        if(e.getMessage().getContentRaw().equals(BotConstants.PREFIX + "online") && BotConstants.ONLINE_COMMAND){
            if(BotConstants.isDevelopmentMode(e.getAuthor().getId())){
                return;
            }
            int onlinePlayers = Server.getInstance().getOnlinePlayers();
            EmbedBuilder eb = new EmbedBuilder().
                    setTitle("Online Players")
                    .setDescription("Player(s) online : " + onlinePlayers)
                    .setThumbnail(BotConstants.THUMBNAIL_URL)
                    .setColor(Color.cyan)
                    .setFooter("@SpiritMS Bot");
            e.getChannel().sendMessage(eb.build()).queue();
        }
    }
}
