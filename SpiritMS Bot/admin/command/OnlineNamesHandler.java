package net.swordie.ms.bot.admin.command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.swordie.ms.Server;
import net.swordie.ms.bot.constants.BotConstants;
import net.swordie.ms.client.character.Char;
import net.swordie.ms.world.Channel;

import java.awt.*;
import java.util.List;


public class OnlineNamesHandler extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e){
        if(e.getMessage().getContentRaw().equals(BotConstants.PREFIX + "onlinenames") && BotConstants.ONLINE_NAME_COMMAND){
            if(BotConstants.isDevelopmentMode(e.getAuthor().getId())){
                return;
            }
            if(!e.getMember().hasPermission(Permission.ADMINISTRATOR)){
                return;
            }
            String msg = "";
            List<Channel> channels = Server.getInstance().getWorld().getChannels();
            for(Channel c : channels){
                for(Char player : c.getChars().values()){
                    msg += player.getName() + "\n";
                }
            }
            EmbedBuilder eb = new EmbedBuilder().
                    setTitle("Online Players")
                    .setDescription("All players online : " + msg)
                    .setThumbnail(BotConstants.THUMBNAIL_URL)
                    .setColor(Color.cyan)
                    .setFooter("@SpiritMS Bot");
            e.getChannel().sendMessage(eb.build()).queue();
        }
    }
}
