package com.cg.model;

import java.util.List;

public class UserRating {

	private List<Rating> ratings;

	public UserRating() {
		
	}
	public UserRating(List<Rating> asList) {
		this.ratings=asList;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	
	
}
