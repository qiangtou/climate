package com.qiangtou.climate.weather;

import org.junit.Assert;
import org.junit.Test;

public class WeatherTest{
	
	@Test
	public void testFetchWeather() {
		Weather.fetchWeather();
		String weater=Weather.getWeather();
		Assert.assertEquals("测试天气获取情况是不是有响应", true, weater.length()>0);
	}
}
