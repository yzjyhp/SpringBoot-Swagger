package com.yzjyhp.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/springboot")
@Api(value = "springboot测试")
public class Controller {

	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	@ApiOperation(value = "获取用户列表", notes = "")
	public String sayWorld(@PathVariable("name") String name, HttpServletRequest request) {
		String clientIP = getIpAddr(request);
		System.out.println("clientIP: " + clientIP);
		return "Hello " + name;
	}

	public String getIpAddr(HttpServletRequest request) {
		if (null == request) {
			return null;
		}

		String proxs[] = { "X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP", "HTTP_CLIENT_IP",
				"HTTP_X_FORWARDED_FOR", "x-real-ip" };

		String ip = null;

		for (String prox : proxs) {
			ip = request.getHeader(prox);
			if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
				continue;
			} else {
				break;
			}
		}

		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
		Browser browser = userAgent.getBrowser();
		OperatingSystem os = userAgent.getOperatingSystem();

		System.out.println("访问者的浏览器名: " + browser);
		System.out.println("访问者的操作系统名: " + os);

		System.out.println("request.getRemoteAddr(): " + request.getRemoteAddr());
		if (StringUtils.isBlank(ip)) {
			return request.getRemoteAddr();
		}

		return ip;
	}
}
