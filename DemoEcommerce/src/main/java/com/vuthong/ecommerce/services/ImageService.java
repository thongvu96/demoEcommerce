/**
 * ImageService.java
 * Dec 11, 2018
 */
package com.vuthong.ecommerce.services;

import java.util.List;

import com.vuthong.ecommerce.vo.ImageVO;

/**
 * @author VuThong
 */
public interface ImageService {
	public List<ImageVO> getAllImage();

	public boolean createImage(ImageVO vo);

	public boolean editImage(ImageVO vo);

	public boolean deleteImage(Integer imageId);

	public ImageVO findImageById(Integer imageId);
}
