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

import java.awt.*;

public class SaveHandler extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e){
        String message = e.getMessage().getContentRaw();
        String[] args = message.split(" ");
        if(message.startsWith(BotConstants.PREFIX + "save") && !message.startsWith(BotConstants.PREFIX + "saveall") && BotConstants.SAVE_COMMAND){
            if(BotConstants.isDevelopmentMode(e.getAuthor().getId())){
                return;
            }
            if(!e.getMember().hasPermission(Permission.ADMINISTRATOR)){ // check if they have admin perms
                return;
            }
            if(args.length < 2){
                e.getChannel().sendMessage("SYNTAX ERROR: !save <character>").queue();
                return;
            }
            String charName = args[1];
            Char chr = Server.getInstance().getWorld().getCharByName(charName);
            if(chr == null){
                e.getChannel().sendMessage("Could not find character name_".replaceAll("name_",charName)).queue();
                return;
            }
            try{
                DatabaseManager.saveToDB(chr.getAccount());
                chr.chatMessage(ChatType.SpeakerChannel, "[SYSTEM] Your character has been saved.");
            }catch(Exception err){
                err.printStackTrace();
                e.getChannel().sendMessage("Error trying to save character.").queue();
            }
            EmbedBuilder eb = new EmbedBuilder();
            eb.setColor(Color.cyan);
            eb.setThumbnail(BotConstants.THUMBNAIL_URL);
            eb.setTitle("Player Save");
            eb.setDescription("Successfully Saved name_".replaceAll("name_",charName));
            eb.setFooter("@SpiritMS Bot");
            e.getChannel().sendMessage(eb.build()).queue();
        }
    }
}
