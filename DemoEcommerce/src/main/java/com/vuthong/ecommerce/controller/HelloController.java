/**
 * HelloController.java
 * Nov 29, 2018
 */
package com.vuthong.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author VuThong
 */
@Controller
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "homePage";
	}
	
	@RequestMapping("/product")
	public String product() {
		return "product";
	}
	
	@RequestMapping("/productDetail")
	public String productDetail() {
		return "productDetail";
	}
	
	@RequestMapping("/about")
	public String about() {
		return "about";
	}
	
	@RequestMapping("/blog")
	public String blog() {
		return "blog";
	}
	
	@RequestMapping("/blogDetail")
	public String blogDetail() {
		return "blogDetail";
	}
	
	@RequestMapping("/cart")
	public String cart() {
		return "cart";
	}
	
	@RequestMapping("/contact")
	public String contact() {
		return "contact";
	}
}

