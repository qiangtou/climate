package com.qiangtou.climate.helper.test;

import org.junit.Assert;
import org.junit.Test;

import com.qiangtou.climate.helper.Log;

public class LogTest {

	@Test
	public void testLog(){
		Log.log("log ok!!!!!!!");
		Assert.assertEquals("log test",1, 1);
	}
}
