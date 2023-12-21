package com.rating.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.Dao.RatingsDao;
import com.rating.Exceptions.ResourceNotFoundException;
import com.rating.Model.Hotel;
import com.rating.Model.Ratings;
import com.rating.feign.HotelFeginClient;

@Service
public class RatingsServiceImpl implements RatingsService {

	@Autowired
	private RatingsDao ratingsdao;
	
	@Autowired
	private HotelFeginClient hotelfeignclient;
	
	@Override
	public Ratings Create(Ratings r) {
		this.ratingsdao.save(r);
		return r;
	}

	@Override
	public List<Ratings> GetAllRatings() {
		List<Ratings> l = this.ratingsdao.findAll();
		for(Ratings r : l) {
			Hotel h = hotelfeignclient.getHotel(r.getHotelid());
			r.setHotel(h);
		}
		return l;
	}

	@Override
	public Ratings GetRating(String id) {
		if(this.ratingsdao.findById(id).isEmpty()==false) {
			Ratings r = this.ratingsdao.findById(id).get();
			Hotel h = hotelfeignclient.getHotel(r.getHotelid());
			r.setHotel(h);
			return r;
		}
		else {
			throw new ResourceNotFoundException("Resource with id : "+id+" not found!!");
		}
	}

	@Override
	public List<Ratings> GetByUserId(String userid) {
		return this.ratingsdao.findByUserid(userid);
	}

	@Override
	public List<Ratings> GetByHotelId(String hotelid) {
		return this.ratingsdao.findByHotelid(hotelid);
	}

	@Override
	public void DeleteRatingsByRatingId(String id) {
		if(this.ratingsdao.findById(id).isEmpty()==false) {
		    this.ratingsdao.deleteById(id);
		}
		else {
			throw new ResourceNotFoundException("Resource with id : "+id+" not found!!");
		}
		
	}
	
	
	
	

}
