package com.xagd.javaeebackend.Utils;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class SendSMS {

    private static String Url = "http://106.ihuyi.com/webservice/sms.php?method=Submit";
    private static String account;
    private static String password;
    private static String content;

    @Value("${sms.account}")
    public void setAccount(String account) {
        SendSMS.account = account;
    }

    @Value("${sms.password}")
    public void setPassword(String password) {
        SendSMS.password = password;
    }

    @Value("${sms.content}")
    public void setContent(String content) {
        SendSMS.content = content;
    }

    public static String send(String phone, String content) {
        Map<String, String> param = new HashMap<>();
        param.put("account", account);
        param.put("password", password);
        param.put("method", "Submit");
        param.put("mobile", phone);
        param.put("content", SendSMS.content.replace("1254", content));
        String resp = HttpClientUtil.doGet(Url, param);
        return resp;
    }

}