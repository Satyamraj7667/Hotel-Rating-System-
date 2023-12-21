package com.rating.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rating.Model.Hotel;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelFeginClient {

	@GetMapping("/hotel/{hotelid}")
	Hotel getHotel(@PathVariable String hotelid);
	
}
