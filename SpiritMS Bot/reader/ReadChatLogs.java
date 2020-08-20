package net.swordie.ms.bot.reader;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.swordie.ms.Server;
import net.swordie.ms.bot.constants.BotConstants;
import net.swordie.ms.client.character.BroadcastMsg;
import net.swordie.ms.connection.packet.WvsContext;

public class ReadChatLogs extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent e){
        if(e.getChannel().getId().equals(BotConstants.CHAT_LOGS_ID) && !e.getAuthor().isBot()){
            BroadcastMsg notice = BroadcastMsg.notice("[" + e.getAuthor().getName() + "] " + e.getMessage().getContentRaw());
            Server.getInstance().getWorld().broadcastPacket(WvsContext.broadcastMsg(notice));
        }
    }
}
