package com.assessment.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assessment.domain.model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, String> {
	
	List<Restaurant> findByNameContaining(String name);
	
	@Query(value = "SELECT restaurant.name, "
			+ "restaurant.customer_rating, "
			+ "restaurant.distance, "
			+ "restaurant.price, "
			+ "restaurant.cuisine_id, "
			+ "cuisine.id, "
			+ "cuisine.name  "
			+ "FROM "
			+ "Restaurant restaurant, "
			+ "Cuisine cuisine "
			+ "WHERE "
			+ "restaurant.cuisine_id = cuisine.id "
			+ "AND (:customer_rating is null or restaurant.customer_rating >= :customer_rating) "
			+ "AND (:distance is null or restaurant.distance <= :distance) "
			+ "AND (:price is null or restaurant.price <= :price) "
			+ "AND (:restaurant_name is null or restaurant.name LIKE %:restaurant_name%) "
			+ "AND (:cuisine_name is null or cuisine.name LIKE %:cuisine_name%) "
			+ "ORDER BY distance, customer_rating DESC, price ASC, restaurant.name, cuisine.name "
			+ "LIMIT 5",
			nativeQuery = true)
	List<Restaurant> findAll(
			@Param("restaurant_name") String restauranName,
			@Param("customer_rating") Integer customerRating,
			@Param("distance") Integer distance,
			@Param("price") Integer price,
			@Param("cuisine_name") String cuisineName
			);
	

}
