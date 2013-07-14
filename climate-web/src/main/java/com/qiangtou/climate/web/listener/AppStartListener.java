package com.qiangtou.climate.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.qiangtou.climate.helper.Log;
import com.qiangtou.climate.task.App;

public class AppStartListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void contextInitialized(ServletContextEvent arg0) {
		Log.log("-------------定时器启动----------");
		App a=new App();
		a.startWeather();
		a.startSend();
		Log.log("-------------定时器启动完成-----------");
	}

}
