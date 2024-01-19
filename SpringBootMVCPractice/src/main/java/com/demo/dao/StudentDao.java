package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer>
{

	@Query(value="select * from student46 where price between :p1 and :p2",nativeQuery = true)
	List<Student> findByPrice(int p1, int p2);

}
