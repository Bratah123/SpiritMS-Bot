package net.swordie.ms.bot.admin.command;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.swordie.ms.Server;
import net.swordie.ms.bot.constants.BotConstants;
import net.swordie.ms.client.character.Char;


public class DCHandler extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {
        String message = e.getMessage().getContentRaw();
        String[] args = message.split(" ");
        if(e.getMessage().getContentRaw().startsWith(BotConstants.PREFIX + "dc") && BotConstants.DC_COMMAND){
            if(BotConstants.isDevelopmentMode(e.getAuthor().getId())){
                return;
            }
            if(!e.getMember().hasPermission(Permission.ADMINISTRATOR)){ // check if they have admin perms
                return;
            }
            if(args.length < 2){
                e.getChannel().sendMessage("SYNTAX ERROR: !dc <name>").queue();
                return;
            }
            String username = args[1];
            Char chr = Server.getInstance().getWorld().getCharByName(username);
            if(chr == null){
                e.getChannel().sendMessage(String.format("Cannot find character, %s",username)).queue();
                return;
            }
            chr.logout();
            e.getChannel().sendMessage(String.format("Successfully disconnected character, %s",chr.getName())).queue();
        }
    }
}
