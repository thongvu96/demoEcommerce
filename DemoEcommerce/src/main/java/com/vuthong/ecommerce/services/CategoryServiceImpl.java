/**
 * CategoryServiceImpl.java
 * Dec 11, 2018
 */
package com.vuthong.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vuthong.ecommerce.entities.Category;
import com.vuthong.ecommerce.repositories.CategoryRepository;
import com.vuthong.ecommerce.vo.CategoryVO;

/**
 * @author VuThong
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vuthong.ecommerce.services.CategoryService#getAllCategory()
	 */
	@Override
	public List<CategoryVO> getAllCategory() {
		// TODO Auto-generated method stub
		List<Category> categories = categoryRepository.findAll();
		List<CategoryVO> categoriesVo = new ArrayList<>();
		for (Category category : categories) {
			CategoryVO categoryVO = new CategoryVO();
			categoryVO.setCategoryId(category.getCategoryId());
			categoryVO.setCategoryName(category.getCategoryName());
			categoryVO.setDescription(category.getDescription());

			categoriesVo.add(categoryVO);
		}
		return categoriesVo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.vuthong.ecommerce.services.CategoryService#createCategory(com.vuthong.
	 * ecommerce.vo.CategoryVO)
	 */
	@Override
	public boolean createCategory(CategoryVO categoryVo) {
		// TODO Auto-generated method stub
		try {
			Category category = new Category();
			// category.setCategoryId(categoryVo.getCategoryId());
			category.setCategoryName(categoryVo.getCategoryName());
			category.setDescription(categoryVo.getDescription());
			
			categoryRepository.save(category);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.vuthong.ecommerce.services.CategoryService#deleteCategory(java.lang.
	 * Integer)
	 */
	@Override
	public boolean deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		try {
			categoryRepository.deleteById(categoryId);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.vuthong.ecommerce.services.CategoryService#findCategoryById(java.lang.Integer)
	 */
	@Override
	public CategoryVO findCategoryById(Integer categoryId) {
		// TODO Auto-generated method stub
		Category category = categoryRepository.getOne(categoryId);
		CategoryVO vo = new CategoryVO();
		vo.setCategoryId(category.getCategoryId());
		vo.setCategoryName(category.getCategoryName());
		vo.setDescription(category.getDescription());
		
		return vo;
	}

	/* (non-Javadoc)
	 * @see com.vuthong.ecommerce.services.CategoryService#editCategory(com.vuthong.ecommerce.vo.CategoryVO)
	 */
	@Override
	public boolean editCategory(CategoryVO vo) {
		try {
			Category category = categoryRepository.getOne(vo.getCategoryId());
			category.setCategoryName(vo.getCategoryName());
			category.setDescription(vo.getDescription());
			
			categoryRepository.save(category);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return false;
	}

}
