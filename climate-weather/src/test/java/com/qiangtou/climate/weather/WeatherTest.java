package com.qiangtou.climate.weather;

import org.junit.Assert;
import org.junit.Test;

public class WeatherTest{
	
	@Test
	public void testFetchWeather() {
		Weather.fetchWeather();
		String weater=Weather.getWeather();
		Assert.assertEquals("����������ȡ����ǲ�������Ӧ", true, weater.length()>0);
	}
}
