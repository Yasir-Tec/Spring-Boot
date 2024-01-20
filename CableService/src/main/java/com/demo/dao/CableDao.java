package com.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Cable;


@Repository
public interface CableDao extends JpaRepository<Cable, Integer> {



}
