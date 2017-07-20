package de.fom.tippspiel.controller;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ServletLoggingFilter extends BaseFilter {

	private static Log logger;

	@Override
	public void init(FilterConfig config) throws ServletException {
		logger = LogFactory.getLog(ServletLoggingFilter.class);
	}

	@Override
	public void httpDoFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String requesturl = null;
		if (request instanceof HttpServletRequest) {
			requesturl = ((HttpServletRequest) request).getRequestURL().toString();
		}
		long dauer = System.currentTimeMillis();
		long startzeit = System.currentTimeMillis();

		// Filterkette damit es weitergeht
		chain.doFilter(request, response);

		// Nach dem response
		dauer = System.currentTimeMillis() - startzeit;

		logger.info("duration: " + dauer + " - " + requesturl);
	}

	@Override
	public void destroy() {
	}
}
