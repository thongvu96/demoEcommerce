/**
 * AdminProductController.java
 * Dec 17, 2018
 */
package com.vuthong.ecommerce.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vuthong.ecommerce.services.CategoryService;
import com.vuthong.ecommerce.services.ProductService;
import com.vuthong.ecommerce.vo.CategoryVO;
import com.vuthong.ecommerce.vo.ProductVO;

/**
 * @author VuThong
 */
@Controller
@RequestMapping("/admin")
public class AdminProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CategoryService categoryService;

	// List All Product
	@RequestMapping("/product")
	public ModelAndView listAllProduct() {
		ModelAndView mav = new ModelAndView("listProduct");
		mav.addObject("allProduct", productService.getAllProduct());
		return mav;
	}

	// Create Product
	@RequestMapping(value = "/product/create", method = RequestMethod.GET)
	public ModelAndView createProduct() {
		ModelAndView mav = new ModelAndView("createProduct");
		mav.addObject("productVO", new ProductVO());
		return mav;
	}

	// Get List Category
	@ModelAttribute("categoryList")
	public Map<Integer, String> getCategoryList() {

		List<CategoryVO> categories = categoryService.getAllCategory();
		Map<Integer, String> categoryList = new HashMap<Integer, String>();
		for (CategoryVO vo : categories) {
			categoryList.put(vo.getCategoryId(), vo.getCategoryName());
		}
		return categoryList;
	}

	// Create Product
	@RequestMapping(value = "/product/create", method = RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute("productVO") @Valid ProductVO vo, BindingResult result) {
		boolean check = !result.hasErrors();
		if (check) {
			productService.createProduct(vo);
			return new ModelAndView("redirect:/admin/product");
		}
		return new ModelAndView("createProduct");
	}

	// Edit Product
	@RequestMapping(value = "/product/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editProduct(@PathVariable(value = "id") Integer productId) {
		ModelAndView mav = new ModelAndView("editProduct");
		ProductVO vo = productService.findProductById(productId);
		mav.addObject("productVO", vo);
		return mav;
	}

	// Edit Product
	@RequestMapping(value = "/product/edit", method = RequestMethod.POST)
	public ModelAndView updateProduct(@ModelAttribute("productVO") @Valid ProductVO vo, BindingResult result) {
		boolean check = !result.hasErrors();
		if (check) {
			productService.editProduct(vo);
			return new ModelAndView("redirect:/admin/product");
		}
		return new ModelAndView("editProduct");
	}

	// Delete Product
	@RequestMapping(value = "/product/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteProduct(@PathVariable(value = "id") Integer productId) {
		ModelAndView mav = new ModelAndView("deleteProduct");
		ProductVO vo = productService.findProductById(productId);
		mav.addObject("productVO", vo);
		return mav;
	}

	// Delete Product
	@RequestMapping(value = "/product/delete", method = RequestMethod.POST)
	public ModelAndView removeProduct(@ModelAttribute("productVO") @Valid ProductVO vo, BindingResult result) {
		boolean check = !result.hasErrors();
		if (check) {
			productService.deleteProduct(vo.getProductId());
			return new ModelAndView("redirect:/admin/product");
		}
		return new ModelAndView("deleteProduct");
	}
}
