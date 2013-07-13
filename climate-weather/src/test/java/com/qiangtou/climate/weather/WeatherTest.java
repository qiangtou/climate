package com.qiangtou.climate.weather;

import org.junit.Assert;
import org.junit.Test;

import com.qiangtou.climate.helper.Log;

public class WeatherTest{
	
	@Test
	public void testFetchWeather() {
		Weather.fetchWeather();
		String weahter=Weather.getWeather();
		String msg="test fetchweather:"+weahter;
		Log.log(msg);
		Assert.assertEquals(msg, true, weahter.length()>0);
	}
}
