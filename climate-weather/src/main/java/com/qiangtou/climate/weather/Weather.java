package com.qiangtou.climate.weather;

import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class Weather {
	
	private static String weather="";
	
	public static void fetchWeather() {
		HttpClient client = new DefaultHttpClient();
		String weather = "";
		String url = "http://www.weather.com.cn/data/cityinfo/101280601.html";
		HttpGet g = new HttpGet(url);
		HttpResponse response1;
		try {
			response1 = client.execute(g);
			HttpEntity entity1 = response1.getEntity();
			InputStream in = entity1.getContent();
			byte[] b = new byte[256];
			int len = in.read(b);
			weather = new String(b, 0, len, "utf-8");
			weather=parserWeather(weather);
			Weather.weather=weather;
			EntityUtils.consume(entity1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			g.releaseConnection();
		}
	}
	
	public static String getWeather() {
		return weather;
	}

	private static String parserWeather(String weather) {
		if (null == weather && "".equals(weather)) {
			return "";
		}
		String city=get(weather,"city");
		String temp1=get(weather,"temp1");
		String temp2=get(weather,"temp2");
		String _weather=get(weather,"weather");
		String ptime=get(weather,"ptime");
		weather=city+"天气:"+_weather+","+temp1+"~"+temp2+"。发布时间:今天"+ptime+".(数据来自中国天气网)";
		return weather;
	}

	private static String get(String weather, String name) {
		String key = "\"" + name + "\"";
		int c = weather.indexOf(key);
		int start = c + key.length() + 2;
		int end = weather.indexOf("\"", start);
		String value = weather.substring(start, end);
		return value;
	}

	public static void main(String[] args) {
		Weather.fetchWeather();
		System.out.println(Weather.getWeather());
	}
}
