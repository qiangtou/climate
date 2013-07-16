package com.qiangtou.climate.task;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import com.qiangtou.climate.helper.Log;
import com.qiangtou.climate.weather.Weather;

public class App {
	
	public static String log;
	private long sMin=0;
	private long wMin=0;
	
	public App(long sMin, long wMin) {
		super();
		this.sMin = sMin;
		this.wMin = wMin;
	}
	public App() {
		super();
	}

	private static final long MINUTE = 1l*60*1000;
	private static final long HOURS = MINUTE*60;

	public void startSend(){
		Calendar instance = Calendar.getInstance();
		Date d1=getDate(instance);
		Date d2=getDate(instance);
		Date d3=getDate(instance);
		
		Timer t = new Timer();
		long period = sMin>0?sMin:24*HOURS;
		t.scheduleAtFixedRate(new WeiboTask(),d1, period);
		t.scheduleAtFixedRate(new WeiboTask(),d2, period);
		t.scheduleAtFixedRate(new WeiboTask(),d3, period);
		log="\n发送周期是"+period/HOURS+"小时,<br/>1:"+d1+",\n2:"+d2+",\n3:"+d3;
		Log.log(log);
	}
	
	public void startWeather(){
		Timer t = new Timer();
		t.scheduleAtFixedRate(new WeatherTask(), new Date(), wMin>0?wMin:4*HOURS);
	}	
	public void fetchWeather(){
		Weather.fetchWeather();
	}	
	
	public Date getDate(Calendar c) {
		int h=c.get(Calendar.HOUR_OF_DAY);
		int d=c.get(Calendar.DAY_OF_MONTH);
		if(h<8){
			h=8;
		}else if(h<11){
			h=11;
		}else if(h<18){
			h=18;
		}else{
			h=8;
			d++;
		}
		c.set(c.get(Calendar.YEAR), c.get(Calendar.MONTH), d,h,0,30);
		return c.getTime();
	}
	public static void main(String[] args) {
		App a=new App();
		Calendar instance = Calendar.getInstance();
		Date d1=a.getDate(instance);
		Date d2=a.getDate(instance);
		Date d3=a.getDate(instance);
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
	}
}
