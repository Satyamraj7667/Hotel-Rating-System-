package com.rating.Service;

import java.util.List;

import com.rating.Model.Ratings;

public interface RatingsService {
  
    Ratings Create(Ratings r);
	List<Ratings> GetAllRatings();
	Ratings GetRating(String id);
	List<Ratings> GetByUserId(String userid);
	List<Ratings> GetByHotelId(String hotelid);
	void DeleteRatingsByRatingId(String id);
}
