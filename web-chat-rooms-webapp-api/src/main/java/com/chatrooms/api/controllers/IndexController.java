package com.chatrooms.api.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chatrooms.api.domain.Message;

@Controller
public class IndexController {

	@RequestMapping(method = RequestMethod.GET, value="/")
	@ResponseBody
	public String index() {
		return "It's working Jim!";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/message")
	@ResponseBody
	public Message message() {
		return new Message("wolooo", "system");
	}
}
