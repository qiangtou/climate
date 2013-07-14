package com.qiangtou.climate.task;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

public class App {
	
	private static final long HOURS = 1l*3600*1000;

	public void startSend(){
		Timer t = new Timer();
		t.scheduleAtFixedRate(new WeiboTask(),getDate(), 8*HOURS);
	}
	
	public void startWeather(){
		Timer t = new Timer();
		t.scheduleAtFixedRate(new WeatherTask(), new Date(), 4*HOURS);
	}	
	
	private Date getDate() {
		Calendar c=Calendar.getInstance();
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH),c.get(Calendar.HOUR_OF_DAY)/8*8,0,5);
		c.add(Calendar.HOUR_OF_DAY, 8);
		return c.getTime();
	}
}
