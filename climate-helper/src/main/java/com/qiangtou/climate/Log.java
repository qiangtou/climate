package com.qiangtou.climate.helper;

import org.apache.log4j.Logger;

public class Log {
	private static Logger log = Logger.getLogger(Log.class);

	public static void log(String msg) {
		log.info(msg);
	}
}
