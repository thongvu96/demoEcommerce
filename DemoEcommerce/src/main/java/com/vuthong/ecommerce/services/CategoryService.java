/**
 * CategoryService.java
 * Dec 11, 2018
 */
package com.vuthong.ecommerce.services;

import java.util.List;

import com.vuthong.ecommerce.vo.CategoryVO;

/**
 * @author VuThong
 */
public interface CategoryService {
	public List<CategoryVO> getAllCategory();

	public boolean createCategory(CategoryVO categoryVo);
	
	public boolean editCategory(CategoryVO vo);

	public boolean deleteCategory(Integer categoryId);
	
	public CategoryVO findCategoryById(Integer categoryId);
}
