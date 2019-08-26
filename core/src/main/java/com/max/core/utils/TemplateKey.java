package com.max.core.utils;

public enum TemplateKey {

    EMAIL_MESSAGE("EMAIL_MESSAGE" , "邮件消息模板"),
    SMS_INTERNATIONAL_JT("SMS_INTERNATIONAL_JT" , "国际短信简体消息模板"),
    SMS_INTERNATIONAL_FT("SMS_INTERNATIONAL_FT" , "国际短信繁体消息模板"),
    SMS_INTERNATIONAL_ENGLISH("SMS_INTERNATIONAL_ENGLISH" , "国际短信英文消息模板");

    private String templateKey;
    private String desc;

    TemplateKey(String templateKey, String desc) {
        this.templateKey = templateKey;
        this.desc = desc;
    }

    public String getTemplateKey() {
        return templateKey;
    }

    public String getDesc() {
        return desc;
    }

    public static String convertCodeToDesc(String templateKey) {
        String desc = "";
        for (TemplateKey template : TemplateKey.values()) {
            if (template.getTemplateKey() == templateKey) {
                desc = template.getDesc();
                break;
            }
        }
        return desc;
    }

}
