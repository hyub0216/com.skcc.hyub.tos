package com.skcc.hyub;

import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	BasicDataSource dataSource;

	@Inject
	SqlSessionFactoryBean factoryBean;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		try {
			logger.info("" + factoryBean.getObject().openSession());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "dashboard";
	}
	
	/*
	 * @RequestMapping(value = "/userInfo", method = RequestMethod.GET) public
	 * String userInfo(Locale locale, Model model) {
	 * System.out.println("userInfo START~~~~~~~~~~~~");
	 * logger.info("userInfo START~~~~~~~~~~~~"); return "user"; }
	 */
	
	@RequestMapping(value = "/userInfo", method = RequestMethod.GET)
	public ModelAndView goUserInfo(Map<String, Object> params, ModelAndView mav) {
		logger.info("userInfoMav START~~~~~~~~~~~~");
		System.out.println("userInfoMav START~~~~~~~~~~~~");
		mav = new ModelAndView();
		mav.setViewName("user");
		System.out.println("userInfo : " + mav.toString());
		
		return mav;
	}

	
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard(Locale locale, Model model) {

		return "dashboard";
	}


}
