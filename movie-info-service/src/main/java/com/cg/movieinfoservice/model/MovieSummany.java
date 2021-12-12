package com.cg.movieinfoservice.model;

public class MovieSummany {

	private String moviename;
	private String overview;
	public String getMoviename() {
		return moviename;
	}
	public void setMoviename(String moviename) {
		this.moviename = moviename;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	@Override
	public String toString() {
		return "MovieSummany [moviename=" + moviename + ", overview=" + overview + "]";
	}
}
