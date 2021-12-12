package com.cg.movieinfoservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cg.movieinfoservice.model.Movie;
import com.cg.movieinfoservice.model.MovieSummany;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Value("${api.key}")
	private String apikey;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/{movieId}")
	public Movie getMovie(@PathVariable("movieId") String movieId) {

		MovieSummany summary= restTemplate.getForObject("https://api.themoviedb.org/3/movie/"+movieId+"?api_key="+apikey,
				MovieSummany.class);
		return new Movie(movieId,summary.getMoviename(),summary.getOverview());
	}
}
