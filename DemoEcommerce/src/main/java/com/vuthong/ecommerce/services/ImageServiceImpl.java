/**
 * ImageServiceImpl.java
 * Dec 25, 2018
 */
package com.vuthong.ecommerce.services;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.vuthong.ecommerce.entities.Image;
import com.vuthong.ecommerce.entities.Product;
import com.vuthong.ecommerce.repositories.ImageRepository;
import com.vuthong.ecommerce.repositories.ProductRepository;
import com.vuthong.ecommerce.vo.ImageVO;
import com.vuthong.ecommerce.vo.ProductVO;

/**
 * @author VuThong
 */
@Service
public class ImageServiceImpl implements ImageService {

	public static final String FOLDER_UPLOAD_IMAGE = "images/";  //static/images/product1.png
	
	@Value("${upload.path}")
	private String pathFolder;
	
	@Autowired
	private ImageRepository imageRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	/* (non-Javadoc)
	 * @see com.vuthong.ecommerce.services.ImageService#getAllImage()
	 */
	@Override
	public List<ImageVO> getAllImage() {
		// TODO Auto-generated method stub
		List<Image> images = imageRepository.findAll();
		List<ImageVO> imagesVO = new ArrayList<>();
		for (Image image : images) {
			ImageVO vo = new ImageVO();
			vo.setImageId(image.getImageId());
			vo.setImage(image.getImage());
			Product product = image.getProduct();
			vo.setProduct(product.getProductId());
			vo.setProductName(product.getProductName());
			imagesVO.add(vo);
		}
		return imagesVO;
	}

	/* (non-Javadoc)
	 * @see com.vuthong.ecommerce.services.ImageService#createImage(com.vuthong.ecommerce.vo.ImageVO)
	 */
	@Override
	public boolean createImage(ImageVO vo) {
		// TODO Auto-generated method stub
		try {
			Product product = productRepository.getOne(vo.getProduct());
			if (product != null) {
				Image image = new Image();
				byte[] bytes = vo.getPathImage().getBytes();
				Path path = Paths.get(pathFolder + vo.getPathImage().getOriginalFilename());
				Files.write(path, bytes);
				
				image.setImage(FOLDER_UPLOAD_IMAGE + vo.getPathImage().getOriginalFilename());
				image.setProduct(product);
				
				imageRepository.save(image);
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.vuthong.ecommerce.services.ImageService#editImage(com.vuthong.ecommerce.vo.ImageVO)
	 */
	@Override
	public boolean editImage(ImageVO vo) {
		// TODO Auto-generated method stub
		try {
			Image image = imageRepository.getOne(vo.getImageId());
			Product product = productRepository.getOne(vo.getProduct());
			if (product != null) {
				// xóa ảnh cũ trong thư mục lưu ảnh
				File file = new File(pathFolder + image.getImage().substring(7));
				file.delete();
				
				// thêm ảnh mới
				byte[] bytes = vo.getPathImage().getBytes();
				Path pathUpdate = Paths.get(pathFolder + vo.getPathImage().getOriginalFilename());
				Files.write(pathUpdate, bytes);
				
				image.setImage(FOLDER_UPLOAD_IMAGE + vo.getPathImage().getOriginalFilename());
				image.setProduct(product);
				
				imageRepository.save(image);
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.vuthong.ecommerce.services.ImageService#deleteImage(java.lang.Integer)
	 */
	@Override
	public boolean deleteImage(Integer imageId) {
		// TODO Auto-generated method stub
		try {
			Image image = imageRepository.getOne(imageId);
			// xóa ảnh cũ trong thư mục lưu ảnh
			File file = new File(pathFolder + image.getImage().substring(7));
			file.delete();
			
			imageRepository.deleteById(imageId);
			
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see com.vuthong.ecommerce.services.ImageService#findImageById(java.lang.Integer)
	 */
	@Override
	public ImageVO findImageById(Integer imageId) {
		// TODO Auto-generated method stub
		Image image = imageRepository.getOne(imageId);
		ImageVO vo = new ImageVO();
		vo.setImageId(image.getImageId());
		vo.setImage(image.getImage());
		vo.setProduct(image.getProduct().getProductId());
		
		return vo;
	}

}
