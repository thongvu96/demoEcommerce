/**
 * ImageRepository.java
 * Dec 11, 2018
 */
package com.vuthong.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vuthong.ecommerce.entities.Image;

/**
 * @author VuThong
 */
@Repository
public interface ImageRepository extends JpaRepository<Image, Integer>{

}
