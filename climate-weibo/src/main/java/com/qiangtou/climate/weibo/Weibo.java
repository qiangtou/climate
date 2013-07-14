package com.qiangtou.climate.weibo;


import weibo4j.Oauth;
import weibo4j.Timeline;
import weibo4j.model.WeiboException;
import weibo4j.util.BareBonesBrowserLaunch;

import com.qiangtou.climate.helper.Log;

public class Weibo {
	public static String ACCESS_TOKEN = "";

	public static void send(String weather) {
		if (isAvaliable()) {
			Log.log("正在发微博");
			Timeline tm = new Timeline();
			tm.client.setToken(ACCESS_TOKEN);
			try {
				tm.UpdateStatus(weather);
			} catch (WeiboException e) {
				e.printStackTrace();
			}
		}else{
			Log.log("ACCESS_TOKEN is null");
		}
	}

	public static void stopToken(){
		ACCESS_TOKEN = "";
	}
	
	public static boolean isAvaliable(){
		return ACCESS_TOKEN.length()>0;
	}
	
	public static void OAuth4Code() {
		Oauth oauth = new Oauth();
		try {
			BareBonesBrowserLaunch.openURL(oauth.authorize("code", ""));
		} catch (WeiboException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Oauth oauth = new Oauth();
		try {
			String url=oauth.authorize("code", "");
			System.out.println(url);
		} catch (WeiboException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
