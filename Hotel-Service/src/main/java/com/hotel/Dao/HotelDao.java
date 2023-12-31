package com.hotel.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.Model.Hotel;

@Repository
public interface HotelDao extends JpaRepository<Hotel, String> {

}
