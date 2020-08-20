package net.swordie.ms.bot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.swordie.ms.bot.constants.BotConstants;

import java.awt.*;

public class DownloadLinkHandler extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if(event.getMessage().getContentRaw().equalsIgnoreCase(BotConstants.PREFIX + "download") && BotConstants.ONLINE_NAME_COMMAND){
            if(BotConstants.isDevelopmentMode(event.getAuthor().getId())){
                return;
            }
            event.getChannel().sendMessage("NO DOWNLOAD").queue();
        }
    }
}
