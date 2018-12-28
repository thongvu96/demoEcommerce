/**
 * ProductServiceImpl.java
 * Dec 13, 2018
 */
package com.vuthong.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vuthong.ecommerce.entities.Category;
import com.vuthong.ecommerce.entities.Product;
import com.vuthong.ecommerce.repositories.CategoryRepository;
import com.vuthong.ecommerce.repositories.ProductRepository;
import com.vuthong.ecommerce.vo.ProductVO;

/**
 * @author VuThong
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	/* (non-Javadoc)
	 * @see com.vuthong.ecommerce.services.ProductService#getAllProduct()
	 */
	@Override
	public List<ProductVO> getAllProduct() {
		// TODO Auto-generated method stub
		List<ProductVO> productsVo = new ArrayList<ProductVO>();
		List<Product> products = productRepository.findAll();
		for (Product product : products) {
			ProductVO vo = new ProductVO();
			vo.setProductId(product.getProductId());
			vo.setProductName(product.getProductName());
			vo.setPrice(product.getPrice());
			vo.setDescription(product.getDescription());
			Category category = product.getCategory();
			vo.setCategoryName(category.getCategoryName());;
			productsVo.add(vo);
		}
		return productsVo;
	}

	/* (non-Javadoc)
	 * @see com.vuthong.ecommerce.services.ProductService#createProduct(com.vuthong.ecommerce.vo.ProductVO)
	 */
	@Override
	public boolean createProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		try {
			Category category = categoryRepository.getOne(vo.getCategory());
			if (category != null) {
				Product product = new Product();
				product.setProductName(vo.getProductName());
				product.setCategory(category);
				product.setDescription(vo.getDescription());
				product.setPrice(vo.getPrice());
				productRepository.save(product);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.vuthong.ecommerce.services.ProductService#editProduct(com.vuthong.ecommerce.vo.ProductVO)
	 */
	@Override
	public boolean editProduct(ProductVO vo) {
		// TODO Auto-generated method stub
		try {
			Product product = productRepository.getOne(vo.getProductId());
			Category category = categoryRepository.getOne(vo.getCategory());
			if (category != null) {
				product.setProductName(vo.getProductName());
				product.setCategory(category);
				product.setDescription(vo.getDescription());
				product.setPrice(vo.getPrice());
				productRepository.save(product);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.vuthong.ecommerce.services.ProductService#deleteProduct(java.lang.Integer)
	 */
	@Override
	public boolean deleteProduct(Integer productId) {
		// TODO Auto-generated method stub
		try {
			productRepository.deleteById(productId);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.vuthong.ecommerce.services.ProductService#findProductById(java.lang.Integer)
	 */
	@Override
	public ProductVO findProductById(Integer productId) {
		// TODO Auto-generated method stub
		Product product = productRepository.getOne(productId);
		ProductVO vo = new ProductVO();
		vo.setProductId(product.getProductId());
		vo.setProductName(product.getProductName());
		vo.setCategory(product.getCategory().getCategoryId());
		vo.setDescription(product.getDescription());
		vo.setPrice(product.getPrice());
		
		return vo;
	}

}
