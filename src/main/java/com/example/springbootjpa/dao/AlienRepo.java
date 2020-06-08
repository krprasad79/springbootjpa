package com.example.springbootjpa.dao;

import com.example.springbootjpa.model.Alien;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface AlienRepo extends CrudRepository<Alien,Integer> {
    List<Alien> findByTech(String tech);
    List<Alien> findByAidGreaterThan(int aid);
}
