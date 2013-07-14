package com.qiangtou.climate.task;

import java.util.TimerTask;

import com.qiangtou.climate.helper.Log;
import com.qiangtou.climate.weather.Weather;
import com.qiangtou.climate.weibo.Weibo;

public class WeiboTask extends TimerTask{

	@Override
	public void run() {
		System.out.println("sent");
		if(Weibo.isAvaliable()){
			String weather=Weather.getWeather();
			Weibo.send(weather+"--"+System.currentTimeMillis());
		}else{
			Log.log("weibo还没有得到授权");
		}
	}
}
