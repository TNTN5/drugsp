package com.drugsp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 拦截器字符集转换
 * */
public class EncodingFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain filter)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
//		修改编码格式
		req.setCharacterEncoding("utf8");
		resp.setCharacterEncoding("utf8");
//		放行
		filter.doFilter(req, resp);
		
	}
}
