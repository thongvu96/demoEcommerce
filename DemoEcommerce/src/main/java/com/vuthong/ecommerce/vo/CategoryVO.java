/**
 * CategoryVO.java
 * Dec 11, 2018
 */
package com.vuthong.ecommerce.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author VuThong
 */
public class CategoryVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer categoryId;
	private String categoryName;
	private String description;
	private List<ProductVO> productsVo = new ArrayList<>();

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<ProductVO> getProductsVo() {
		return productsVo;
	}

	public void setProductsVo(List<ProductVO> productsVo) {
		this.productsVo = productsVo;
	}

}
