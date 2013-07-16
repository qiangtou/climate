package com.qiangtou.climate.weather;

import org.junit.Assert;
import org.junit.Test;

public class WeatherTest{
	
	@Test
	public void testFetchWeather() {
		Weather.fetchWeather();
		String weahter=Weather.getWeather();
		Assert.assertEquals("test fetchweather:", true, weahter.length()>0);
		Assert.assertEquals("test getWeather", weahter, Weather.getWeather());
	}
}
