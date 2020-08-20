package net.swordie.ms.bot.webhook;

import club.minnced.discord.webhook.WebhookClient;
import club.minnced.discord.webhook.send.WebhookEmbed;
import club.minnced.discord.webhook.send.WebhookEmbedBuilder;
import club.minnced.discord.webhook.send.WebhookMessageBuilder;
import net.swordie.ms.bot.constants.WebhookConstants;

public class Webhook {

    public static void sendChatLogs(String name, String msg){
        WebhookClient client = WebhookClient.withUrl(WebhookConstants.CHAT_LOGS_URL);
        WebhookMessageBuilder builder = new WebhookMessageBuilder();
        builder.setUsername(name);
        builder.setContent(msg);
        client.send(builder.build());
        client.close();
    }

    public static void sendCurrencyLogs(String name, String msg){
        WebhookClient client = WebhookClient.withUrl(WebhookConstants.MLG_GML_TRADE_URL);
        WebhookMessageBuilder builder = new WebhookMessageBuilder();
        builder.setUsername(name);
        builder.setContent(msg);
        client.send(builder.build());
        client.close();
    }

    public static void sendDamageLogs(String name, String msg){
        WebhookClient client = WebhookClient.withUrl(WebhookConstants.DAMAGE_LOGS_URL);
        WebhookMessageBuilder builder = new WebhookMessageBuilder();
        builder.setUsername(name);
        builder.setContent(msg);
        client.send(builder.build());
        client.close();
    }

    public static void sendCommandLogs(String name, String msg){
        WebhookClient client = WebhookClient.withUrl(WebhookConstants.COMMANDS_LOGS_URL);
        WebhookMessageBuilder builder = new WebhookMessageBuilder();
        builder.setUsername(name);
        builder.setContent(msg);
        client.send(builder.build());
        client.close();
    }

    public static void sendWhisperLogs(String name, String msg, String recipient){
        WebhookClient client = WebhookClient.withUrl(WebhookConstants.WHISPER_LOGS_URL);
        WebhookEmbed.EmbedTitle title = new WebhookEmbed.EmbedTitle("Whisper Logs", null);
        WebhookEmbed.EmbedField field = new WebhookEmbed.EmbedField(false, "Recipient", recipient);
        WebhookEmbed.EmbedField contentField = new WebhookEmbed.EmbedField(false,"Message", name + ": " +msg);
        WebhookEmbed embed = new WebhookEmbedBuilder()
                .setColor(0x00FFFF)
                .setTitle(title)
                .addField(contentField)
                .addField(field).build();
        client.send(embed);
        client.close();
    }

    public static void sendLogs(LogType logType, String name, String msg){
        WebhookClient client = WebhookClient.withUrl(logType.url);
        WebhookMessageBuilder builder = new WebhookMessageBuilder();
        builder.setUsername(name);
        builder.setContent(msg);
        client.send(builder.build());
        client.close();
    }

}
