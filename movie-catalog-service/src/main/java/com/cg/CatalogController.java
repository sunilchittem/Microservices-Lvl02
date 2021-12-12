package com.cg;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.cg.model.CatalogItem;
import com.cg.model.Movie;
import com.cg.model.UserRating;
import com.cg.service.MovieInfoService;
import com.cg.service.RatingInfoService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private WebClient.Builder webBuilder;

	@Autowired
	private RatingInfoService ratingInfoService;

	@Autowired
	private MovieInfoService movieInfoService;

	@GetMapping("/{userId}")
	public List<CatalogItem> retrieveCatalog(@PathVariable("userId") String userId) {
		// Retrieving the MovieId and rating with UserId
		UserRating rating = ratingInfoService.getRatings(userId);
		return rating.getRatings().stream().map(t -> movieInfoService.getCatalog(t)).collect(Collectors.toList());

	}

}

//List<Rating> list = Arrays.asList(new Rating("1234", 4), new Rating("4537", 3));

/*
 * Web Client (asynchronous way)
 * 
 * Movie movie = webBuilder.build().get() .uri("http://localhost:8081/movies/" +
 * t.getMovieId()) .retrieve() .bodyToMono(Movie.class) .block();
 */
