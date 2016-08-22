package config.controller;

import config.domain.NameValue;
import config.mapper.NameValueMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by hzhubin15 on 2016/8/19.
 */
@RestController
public class NameValueController {

	@Resource(name = "nameValueMapper")
	private NameValueMapper nameValueMapper;

	@RequestMapping("/query")
	public NameValue query(String name){
		return nameValueMapper.findByName(name);
	}

	@RequestMapping(value = "/session", method = RequestMethod.GET)
	public String getSessionId(HttpServletRequest request) {
		return request.getSession().getId();
	}

}
