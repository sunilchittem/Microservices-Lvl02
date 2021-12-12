package com.cg.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.cg.model.Rating;
import com.cg.model.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RatingInfoService {

	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getFallBackRatings")
	public UserRating getRatings(String userId) {
		UserRating ratings = restTemplate.getForObject("http://ratings-data-service/rating/user/" + userId,
				UserRating.class);
		return ratings;
	}

	public UserRating getFallBackRatings(String userId) {
			
		return new UserRating(Arrays.asList(new Rating("no movie found", 0)));
	}
}
