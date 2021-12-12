package com.cg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.model.CatalogItem;
import com.cg.model.Movie;
import com.cg.model.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MovieInfoService {

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getFallBackCatalog")
	public CatalogItem getCatalog(Rating rating) {
		
		Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
	
		return new CatalogItem(movie.getMovieName(), movie.getGenre(), rating.getRating());
	}
	public CatalogItem getFallBackCatalog(Rating rating) {
		return new CatalogItem("movie name not found", "no movie info", rating.getRating());
	}
}
