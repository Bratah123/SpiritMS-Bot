package net.swordie.ms.bot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.swordie.ms.bot.constants.BotConstants;

import java.awt.*;

public class InfoHandler extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        if(event.getMessage().getContentRaw().equalsIgnoreCase(BotConstants.PREFIX + "info") && BotConstants.INFO_COMMAND){
            if(BotConstants.isDevelopmentMode(event.getAuthor().getId())){
                return;
            }
            EmbedBuilder embed = new EmbedBuilder().setColor(Color.cyan).setTitle("SpiritMS").setDescription("GMS v176");
            embed.setThumbnail(BotConstants.THUMBNAIL_URL);
            embed.addField("Exp","6x",true);
            embed.addField("Item", "2x", true);
            embed.addField("Meso", "1x",true);
            embed.addField("Server State", "Alpha-Open Testing", true);
            embed.addField("Release Date", "August 31st 2214", false);
            embed.setFooter("@SpiritMS Bot");

            event.getChannel().sendMessage(embed.build()).queue();
        }
    }
}
