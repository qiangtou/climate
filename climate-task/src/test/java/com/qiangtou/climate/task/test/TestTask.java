package com.qiangtou.climate.task.test;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.qiangtou.climate.task.App;

public class TestTask {
	
	private App app;
	
	@Before
	public void before(){
		long sMin=1l*1000;
		long wMin=1l*1000;
		app=new App(sMin, wMin);
	}

	@Test
	public void testTast(){
		//app.startWeather();
		//app.startWeather();
	}
	
	@Test
	public void testDate(){
	
		Date exceptDate;
		Calendar c=Calendar.getInstance();		
		c.set(2013, 7, 16, 0, 0, 0);
		Date d0= app.getDate(c);
		
		c.set(2013, 7, 16, 3, 0, 0);
		Date d3= app.getDate(c);	
		
		c.set(2013, 7, 16, 8, 0, 0);
		Date d8= app.getDate(c);	
		
		c.set(2013, 7, 16, 9, 0, 0);
		Date d9= app.getDate(c);	
		
		c.set(2013, 7, 16, 11, 0, 0);
		Date d11= app.getDate(c);	
		
		c.set(2013, 7, 16, 12, 0, 0);
		Date d12= app.getDate(c);	
		
		c.set(2013, 7, 16, 18, 0, 0);
		Date d18= app.getDate(c);
		
		c.set(2013, 7, 16, 20, 0, 0);
		Date d20= app.getDate(c);
		
		c.set(2013, 7, 16, 8, 0, 30);
		exceptDate=c.getTime();
		Assert.assertEquals("0-8",exceptDate,d0);
		Assert.assertEquals("3-8",exceptDate,d3);
		
		c.set(2013, 7, 16, 11, 0, 30);
		exceptDate=c.getTime();
		Assert.assertEquals("8-11",exceptDate,d8);
		Assert.assertEquals("9-11",exceptDate,d9);
		
		c.set(2013, 7, 16, 18, 0, 30);
		exceptDate=c.getTime();
		Assert.assertEquals("11-18",exceptDate,d11);
		Assert.assertEquals("12-18",exceptDate,d12);
		
		c.set(2013, 7, 17, 8, 0, 30);
		exceptDate=c.getTime();
		Assert.assertEquals("18-8",exceptDate,d18);
		Assert.assertEquals("20-8",exceptDate,d20);
		
	}
}
