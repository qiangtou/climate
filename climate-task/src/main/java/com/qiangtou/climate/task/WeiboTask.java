package com.qiangtou.climate.task;

import java.util.TimerTask;

import weibo4j.model.WeiboException;

import com.qiangtou.climate.helper.Log;
import com.qiangtou.climate.weather.Weather;
import com.qiangtou.climate.weibo.Weibo;

public class WeiboTask extends TimerTask{

	@Override
	public void run() {
		if(Weibo.isAvaliable()){
			Weather.fetchWeather();
			String weather=Weather.getWeather();
			try {
				Weibo.send(weather);
			} catch (WeiboException e) {
				e.printStackTrace();
			}
		}else{
			Log.log("weibo还没有得到授权");
		}
	}
}
