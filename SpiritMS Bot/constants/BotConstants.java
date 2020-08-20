package net.swordie.ms.bot.constants;

public class BotConstants {

    // Global
    public static final String PREFIX = "!";
    public static final String TOKEN = "";
    public static final String THUMBNAIL_URL = "https://cdn.discordapp.com/attachments/631249406775132182/722198635143626762/brand2.png";
    public static final String CHAT_LOGS_ID = ""; // If you type in this chat, it will send a notice to the game of your message

    // Only Developers can use discord bot commands when true
    public static final boolean DEVELOPMENT_MODE = true;

    // Commands, set to false to disable the command
    // Player Commands
    public static final boolean INFO_COMMAND = true;
    public static final boolean ONLINE_COMMAND = true;
    public static final boolean DOWNLOAD_LINK_COMMAND = true;

    // Admin Commands
    public static final boolean SAVE_ALL_COMMAND = true;
    public static final boolean SAVE_COMMAND = true;
    public static final boolean DC_COMMAND = true;
    public static final boolean ONLINE_NAME_COMMAND = true;


    // Admin related
    public static final String BRANDON_ID = "207371595113562124"; // Discord ID goes here for development mode purposes

    public static final String[] ALLOWED_USERS_ID = {
            BRANDON_ID, // Brandon
    };

    public static boolean isAllowedToUseCommand(String userId){
        // You can just add to an arrayList and do contains()
        for(String id : ALLOWED_USERS_ID){
            if(userId.equals(id)){
                return true;
            }
        }
        return false;
    }

    public static boolean isDevelopmentMode(String userId){
        if(DEVELOPMENT_MODE && !isAllowedToUseCommand(userId)){
            return true;
        }
        return false;
    }
}
