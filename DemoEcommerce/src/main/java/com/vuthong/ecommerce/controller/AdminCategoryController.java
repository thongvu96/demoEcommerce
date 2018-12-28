/**
 * AdminCategoryController.java
 * Dec 12, 2018
 */
package com.vuthong.ecommerce.controller;

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
import com.vuthong.ecommerce.vo.CategoryVO;
import com.vuthong.ecommerce.vo.ProductVO;

/**
 * @author VuThong
 */
@Controller
@RequestMapping("/admin")
public class AdminCategoryController {

	@Autowired
	private CategoryService categoryService;

	// Home Page Admin
	@RequestMapping(value = { "/", "" })
	public ModelAndView homeAdmin() {
		ModelAndView mav = new ModelAndView("homeAdmin");
		return mav;
	}

	// List All Category
	@RequestMapping(value = "/category")
	public ModelAndView listAllCategory() {
		ModelAndView mav = new ModelAndView("listCategory");
		mav.addObject("allCategory", categoryService.getAllCategory());
		return mav;
	}

	// Create Category
	@RequestMapping(value = "/category/create", method = RequestMethod.GET)
	public ModelAndView createCategory() {
		ModelAndView mav = new ModelAndView("createCategory");
		mav.addObject("categoryVO", new CategoryVO());
		return mav;
	}

	// Create Category
	@RequestMapping(value = "/category/create", method = RequestMethod.POST)
	public ModelAndView addCategory(@ModelAttribute("categoryVO") @Valid CategoryVO vo, BindingResult result) {
		boolean check = !result.hasErrors();
		if (check) {
			categoryService.createCategory(vo);
			return new ModelAndView("redirect:/admin/category");
		}
		return new ModelAndView("createCategory");
	}

	// Edit Category
	@RequestMapping(value = "/category/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editCategory(@PathVariable(value = "id") Integer categoryId) {
		ModelAndView mav = new ModelAndView("editCategory");
		CategoryVO vo = categoryService.findCategoryById(categoryId);
		mav.addObject("categoryVO", vo);
		return mav;
	}

	// Edit Category
	@RequestMapping(value = "/category/edit", method = RequestMethod.POST)
	public ModelAndView updateCategory(@ModelAttribute("categoryVO") @Valid CategoryVO vo, BindingResult result) {
		boolean check = !result.hasErrors();
		if (check) {
			categoryService.editCategory(vo);
			return new ModelAndView("redirect:/admin/category");
		}
		return new ModelAndView("editCategory");
	}

	// Delete Category
	@RequestMapping(value = "/category/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteCategory(@PathVariable(value = "id") Integer categoryId) {
		ModelAndView mav = new ModelAndView("deleteCategory");
		CategoryVO vo = categoryService.findCategoryById(categoryId);
		mav.addObject("categoryVO", vo);
		return mav;
	}

	// Delete Category
	@RequestMapping(value = "/category/delete", method = RequestMethod.POST)
	public ModelAndView removeCategory(@ModelAttribute("categoryVO") @Valid CategoryVO vo, BindingResult result) {
		boolean check = !result.hasErrors();
		if (check) {
			categoryService.deleteCategory(vo.getCategoryId());
			return new ModelAndView("redirect:/admin/category");
		}
		return new ModelAndView("deleteCategory");
	}
}
