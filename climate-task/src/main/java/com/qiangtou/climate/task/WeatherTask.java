package com.qiangtou.climate.task;

import java.util.TimerTask;

import com.qiangtou.climate.weather.Weather;

public class WeatherTask extends TimerTask{

	@Override
	public void run() {
		Weather.fetchWeather();
	}

}
