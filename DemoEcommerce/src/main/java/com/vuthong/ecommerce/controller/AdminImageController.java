/**
 * AdminImageController.java
 * Dec 25, 2018
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

import com.vuthong.ecommerce.services.ImageService;
import com.vuthong.ecommerce.services.ProductService;
import com.vuthong.ecommerce.vo.ImageVO;
import com.vuthong.ecommerce.vo.ProductVO;

/**
 * @author VuThong
 */
@Controller
@RequestMapping("/admin")
public class AdminImageController {
	@Autowired
	private ImageService imageService;

	@Autowired
	private ProductService productService;

	// List All Image
	@RequestMapping("/image")
	public ModelAndView listAllImage() {
		ModelAndView mav = new ModelAndView("listImage");
		mav.addObject("allImage", imageService.getAllImage());
		return mav;
	}

	// Get List Product
	@ModelAttribute("productList")
	public Map<Integer, String> getProductList() {

		List<ProductVO> productsVO = productService.getAllProduct();
		Map<Integer, String> productList = new HashMap<Integer, String>();
		for (ProductVO vo : productsVO) {
			productList.put(vo.getProductId(), vo.getProductName());
		}
		return productList;
	}

	// Create Image
	@RequestMapping(value = "/image/create", method = RequestMethod.GET)
	public ModelAndView createImage() {
		ModelAndView mav = new ModelAndView("createImage");
		mav.addObject("imageVO", new ImageVO());
		return mav;
	}

	// Create Image
	@RequestMapping(value = "/image/create", method = RequestMethod.POST)
	public ModelAndView addImage(@ModelAttribute("imageVO") @Valid ImageVO vo, BindingResult result) {
		boolean check = !result.hasErrors();
		System.out.println(result.getAllErrors());
		if (check) {
			imageService.createImage(vo);
			return new ModelAndView("redirect:/admin/image");
		}
		return new ModelAndView("createImage");
	}

	// Edit Image
	@RequestMapping(value = "/image/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editImage(@PathVariable(value = "id") Integer imageId) {
		ModelAndView mav = new ModelAndView("editImage");
		ImageVO vo = imageService.findImageById(imageId);
		mav.addObject("imageVO", vo);
		mav.addObject("image", vo.getImage());
		return mav;
	}

	// Edit Image
	@RequestMapping(value = "/image/edit", method = RequestMethod.POST)
	public ModelAndView updateImage(@ModelAttribute("imageVO") @Valid ImageVO vo, BindingResult result) {
		boolean check = !result.hasErrors();
		if (check) {
			imageService.editImage(vo);
			return new ModelAndView("redirect:/admin/image");
		}
		return new ModelAndView("editImage");
	}

	// Delete Image
	@RequestMapping(value = "/image/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteImage(@PathVariable(value = "id") Integer imageId) {
		ModelAndView mav = new ModelAndView("deleteImage");
		ImageVO vo = imageService.findImageById(imageId);
		mav.addObject("imageVO", vo);
		mav.addObject("image", vo.getImage());
		return mav;
	}

	// Delete Image
	@RequestMapping(value = "/image/delete", method = RequestMethod.POST)
	public ModelAndView removeImage(@ModelAttribute("imageVO") @Valid ImageVO vo, BindingResult result) {
		boolean check = !result.hasErrors();
		if (check) {
			imageService.deleteImage(vo.getImageId());
			return new ModelAndView("redirect:/admin/image");
		}
		return new ModelAndView("deleteImage");
	}
}
