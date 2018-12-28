/**
 * ProductService.java
 * Dec 11, 2018
 */
package com.vuthong.ecommerce.services;

import java.util.List;

import com.vuthong.ecommerce.vo.ProductVO;

/**
 * @author VuThong
 */
public interface ProductService {
	public List<ProductVO> getAllProduct();

	public boolean createProduct(ProductVO vo);

	public boolean editProduct(ProductVO vo);

	public boolean deleteProduct(Integer productId);

	public ProductVO findProductById(Integer productId);
}
