package com.rating.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.rating.entity.Rating;
import com.rating.repository.RatingRepository;

@Service
public class RatingServiceImpl implements RatingService {

	private RatingRepository ratingRepository;

	public RatingServiceImpl(RatingRepository ratingRepository) {
		this.ratingRepository = ratingRepository;
	}

	@Override
	public Rating create(Rating rating) {
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRetings() {
		List<Rating> list = ratingRepository.findAll();
		if (!list.isEmpty()) {
			return list.stream().map(r -> {
				Rating rating = new Rating();
				BeanUtils.copyProperties(r, rating);
				return rating;
			}).toList();
		}
		return Collections.emptyList();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		List<Rating> list = ratingRepository.findByUserId(userId);
		if (!list.isEmpty()) {
			return list.stream().map(r -> {
				Rating rating = new Rating();
				BeanUtils.copyProperties(r, rating);
				return rating;
			}).toList();
		}
		return Collections.emptyList();
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		List<Rating> list = ratingRepository.findByHotelId(hotelId);
		if (!list.isEmpty()) {
			return list.stream().map(r -> {
				Rating rating = new Rating();
				BeanUtils.copyProperties(r, rating);
				return rating;
			}).toList();
		}
		return Collections.emptyList();
	}

}
