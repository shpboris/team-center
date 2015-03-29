package org.team.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {
	
	
	@RequestMapping("/")
	public String getData(){
		return "Helllow world";
	}
	
	
}
