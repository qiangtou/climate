package com.qiangtou.climate.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.qiangtou.climate.weibo.Weibo;
import weibo4j.Oauth;
import weibo4j.model.WeiboException;

public class CodeFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		String code=(String) req.getParameter("code");
		boolean weibo= Weibo.isAvaliable();
		if(!weibo && null!=code && ""!=code){
			try {
				Weibo.ACCESS_TOKEN=new Oauth().getAccessTokenByCode(code).getAccessToken();
				weibo=true;
			} catch (WeiboException e) {
				e.printStackTrace();
			}
		}
		req.setAttribute("weibo",weibo) ;
		chain.doFilter(req, res);
	}

	public void init(FilterConfig fc) throws ServletException {
	}

	public void destroy() {
	}

}
