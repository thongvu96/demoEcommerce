/**
 * ProductVO.java
 * Dec 11, 2018
 */
package com.vuthong.ecommerce.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author VuThong
 */
public class ProductVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer productId;
	private Integer category;
	private String categoryName;
	private String productName;
	private String description;
	private Integer price;
	private List<ImageVO> imagesVo = new ArrayList<>();

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<ImageVO> getImagesVo() {
		return imagesVo;
	}

	public void setImagesVo(List<ImageVO> imagesVo) {
		this.imagesVo = imagesVo;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
