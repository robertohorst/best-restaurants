package com.assessment.api.controller;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.domain.model.Restaurant;
import com.assessment.domain.repository.RestaurantRepository;

@RestController
@RequestMapping("/restaurants")
@Validated
public class RestaurantController {

	@Autowired
	RestaurantRepository restaurantRepository;

	@GetMapping
	public ResponseEntity<List<Restaurant>> listAll(
			@RequestParam(required = false) String restaurantName,
			@RequestParam(required = false) Integer customerRating,
			@RequestParam(required = false) Integer distance,
			@RequestParam(required = false) Integer price,
			@RequestParam(required = false) String cuisineName){

		List<Restaurant> restaurants = restaurantRepository.findAll(restaurantName, customerRating, distance, price, cuisineName);
		return ResponseEntity.ok(restaurants);

		//return ResponseEntity.notFound().build();
	}

	@GetMapping("/{restaurantName}")
	public List<Restaurant> listAllByName(@PathVariable String restaurantName){
		return restaurantRepository.findByNameContaining(restaurantName);
	}

}
