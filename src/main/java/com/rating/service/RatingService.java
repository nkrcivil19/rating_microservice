package com.rating.service;

import java.util.List;

import com.rating.entity.Rating;

public interface RatingService {

//	create
	Rating create(Rating rating);

//	getAll Ratings
	List<Rating> getAllRetings();

	// getRatingByUserId
	List<Rating> getRatingByUserId(String userId);
//	getRatingByhotelId
	List<Rating> getRatingByHotelId(String userId);

}
