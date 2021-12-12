package com.cg.movieinfoservice.model;

public class Movie {

	private String movieId;
	private String overview;
	private String movieName;

	public Movie(String movieId, String overview, String movieName) {
		this.movieId = movieId;
		this.overview = overview;
		this.movieName = movieName;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", overview=" + overview + ", movieName=" + movieName + "]";
	}

}
