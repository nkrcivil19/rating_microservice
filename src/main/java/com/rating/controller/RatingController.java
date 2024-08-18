package com.rating.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rating.entity.Rating;
import com.rating.service.RatingService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/ratings")
@Slf4j
public class RatingController {

	private RatingService ratingService;

	public RatingController(RatingService ratingService) {
		this.ratingService = ratingService;
	}

	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating) {
		Rating ratingResponse = ratingService.create(rating);
		if (ratingResponse != null) {
			log.info("This is an info log message");
			return ResponseEntity.status(HttpStatus.CREATED).body(ratingResponse);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ratingResponse);
		}
	}

	@GetMapping
	public ResponseEntity<List<Rating>> getAll() {
		List<Rating> ratingList = ratingService.getAllRetings();
		return ratingList.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(ratingList)
				: ResponseEntity.status(HttpStatus.OK).body(ratingList);
	}

//	localhost:1211/ratings/users?userId=123
	@GetMapping("/users")
	public ResponseEntity<List<Rating>> getAllRatingsByUserId(@RequestParam String userId) {
		List<Rating> ratingList = ratingService.getRatingByUserId(userId);
		return ratingList.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).body(ratingList)
				: ResponseEntity.status(HttpStatus.OK).body(ratingList);
	}

//	localhost:1211/ratings/hotels?hotelId=123
	@GetMapping("/hotels")
	public ResponseEntity<List<Rating>> getAllRatingssByHotelId(@RequestParam String hotelId) {
		List<Rating> ratingList = ratingService.getRatingByHotelId(hotelId);
		return !ratingList.isEmpty() ? ResponseEntity.status(HttpStatus.OK).body(ratingList)
				: ResponseEntity.status(HttpStatus.NOT_FOUND).body(ratingList);
	}
}
