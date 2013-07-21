package com.qiangtou.climate.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import weibo4j.model.WeiboException;

import com.qiangtou.climate.weather.Weather;
import com.qiangtou.climate.weibo.Weibo;

public class SendWeibo extends HttpServlet {


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset:utf-8");
		PrintWriter out = response.getWriter();
		
		String content,attach,res="ok";
		content=request.getParameter("content");
		attach=request.getParameter("attach");
		if(content!=null && content.length()>0){
			String weather=Weather.getWeather();
			try {
				Weibo.send(content+(("true".equals(attach)&&weather.length()>0)?("----"+weather):""));
			} catch (WeiboException e) {
				res="fail";
			}
		}else{
			res="null";
		}
		
		out.print(res);
		out.flush();
		out.close();
	}
}
