package net.swordie.ms.bot.admin.command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.swordie.ms.Server;
import net.swordie.ms.bot.constants.BotConstants;
import net.swordie.ms.client.character.Char;
import net.swordie.ms.connection.db.DatabaseManager;
import net.swordie.ms.enums.ChatType;
import net.swordie.ms.world.Channel;

import javax.xml.crypto.Data;
import java.awt.*;
import java.util.List;

public class SaveAllHandler extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e){
        String message = e.getMessage().getContentRaw();
        if(message.equals(BotConstants.PREFIX + "saveall") && BotConstants.SAVE_ALL_COMMAND){
            if(BotConstants.isDevelopmentMode(e.getAuthor().getId())){
                return;
            }
            if(!e.getMember().hasPermission(Permission.ADMINISTRATOR)){ // check if they have admin perms
                return;
            }
            List<Channel> channels = Server.getInstance().getWorld().getChannels();
            for(Channel c : channels){
                for(Char chr : c.getChars().values()){
                    try{
                        DatabaseManager.saveToDB(chr.getAccount());
                        chr.chatMessage(ChatType.SpeakerChannel,"[SYSTEM] Your character has been saved.");
                    }
                    catch(Exception ex){
                        ex.printStackTrace();
                        e.getChannel().sendMessage("Stopped at " + chr.getName() + " due to some error").queue();
                        return;
                    }
                }
            }
            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(Color.cyan);
            eb.setThumbnail(BotConstants.THUMBNAIL_URL);
            eb.setTitle("SERVER SAVED");
            eb.setDescription("Successfully Saved All Characters.");
            eb.setFooter("@SpiritMS Bot");
            e.getChannel().sendMessage(eb.build()).queue();
        }
    }
}
