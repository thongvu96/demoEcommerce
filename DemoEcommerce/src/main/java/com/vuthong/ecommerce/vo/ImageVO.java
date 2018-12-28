/**
 * ImageVO.java
 * Dec 11, 2018
 */
package com.vuthong.ecommerce.vo;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author VuThong
 */
public class ImageVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer imageId;
	private String image;
	private MultipartFile pathImage;
	private Integer product;
	private String productName;

	public MultipartFile getPathImage() {
		return pathImage;
	}

	public void setPathImage(MultipartFile pathImage) {
		this.pathImage = pathImage;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getImageId() {
		return imageId;
	}

	public void setImageId(Integer imageId) {
		this.imageId = imageId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Integer getProduct() {
		return product;
	}

	public void setProduct(Integer product) {
		this.product = product;
	}

}
