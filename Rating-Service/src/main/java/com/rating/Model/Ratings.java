package com.rating.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ratings {

	@Id
	private String ratingid;
	private int rating;
	private String userid;
	private String hotelid;
	private String feedback;
	@Transient
	private Hotel hotel;
	
	
	
	
	
}
