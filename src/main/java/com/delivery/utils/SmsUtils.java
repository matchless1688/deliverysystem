package com.delivery.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import com.delivery.bo.SmsSend;
import com.delivery.bo.SmsTemplate;

public class SmsUtils {

	private final static String smsTemplate_head = "http://ums.zj165.com:8888/sms/Api/Send.do?SpCode=210312&LoginName=zj_yzgs&Password=yiyou-888&";

	private final static String smsTemplate_tail = "&ScheduleTime=&f=1"; // MessageContent=短信内&UserNumber=18616330318&SerialNumber=20byte

	public static SmsSend send(String phone, String pwd,
			SmsTemplate template) throws UnsupportedEncodingException {
		SmsSend send = new SmsSend();
		StringBuilder sb = new StringBuilder();
		
		String sn = generateSN();
		String context = template.getPart1() + phone + template.getPart2()
				+ pwd + template.getPart3();
		send.setSn(sn);
		send.setContext(context);
		send.setTelPhone(phone);
		context = URLEncoder.encode(context, "GB2312");
		
		sb.append(smsTemplate_head).append("MessageContent=").append(context)
				.append("&UserNumber=").append(phone).append("&SerialNumber=")
				.append(sn).append(smsTemplate_tail);
		
		String result = sendGet(sb.toString());
		String confirm = result.substring(result.indexOf("=") + 1, result.indexOf("&"));
		send.setDeliveryConfirmation(confirm);
		return send;
	}

	public static String generateSN() {
		String curnum = String.valueOf(System.currentTimeMillis());
		int length = curnum.length();
		while (length < 20) {
			curnum += '0';
			length++;
		}
		return curnum;
	}
	
	public static String sendGet(String url) {
        String result = "";
        BufferedReader in = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
}
