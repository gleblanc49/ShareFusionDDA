package ca.dda.fusion.controller;

import javax.enterprise.inject.Model;

@Model
public class CommonPage {

	public String goDancerPage(){
		return "goDancerPage";
	}
	public String goHomePage(){
		return "goHomePage";
	}
}
