package net.swordie.ms.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.swordie.ms.bot.admin.command.DCHandler;
import net.swordie.ms.bot.admin.command.OnlineNamesHandler;
import net.swordie.ms.bot.commands.DownloadLinkHandler;
import net.swordie.ms.bot.commands.InfoHandler;
import net.swordie.ms.bot.commands.OnlineHander;
import net.swordie.ms.bot.admin.command.SaveAllHandler;
import net.swordie.ms.bot.admin.command.SaveHandler;
import net.swordie.ms.bot.constants.BotConstants;
import net.swordie.ms.bot.reader.ReadChatLogs;

public class SpiritBot {
    public static void init() throws Exception {
        // Main Start Function
        JDA jda = JDABuilder.createDefault(BotConstants.TOKEN)
                .addEventListeners(
                        new InfoHandler(),
                        new OnlineHander(),
                        new SaveAllHandler(),
                        new SaveHandler(),
                        new DCHandler(),
                        new ReadChatLogs(),
                        new DownloadLinkHandler(),
                        new OnlineNamesHandler()
                )
                .build();
    }
}
