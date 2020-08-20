package net.swordie.ms.bot.webhook;

import net.swordie.ms.bot.constants.WebhookConstants;

public enum LogType {
    Whisper(WebhookConstants.WHISPER_LOGS_URL),
    Chat(WebhookConstants.CHAT_LOGS_URL),
    Trade(WebhookConstants.MLG_GML_TRADE_URL),
    Damage(WebhookConstants.DAMAGE_LOGS_URL),
    ServerStatus(WebhookConstants.SERVER_STATUS_URL),
    NXGain(WebhookConstants.GAIN_NX_LOGS_URL);

    String url;

    LogType(String url){
        this.url = url;
    }
}
