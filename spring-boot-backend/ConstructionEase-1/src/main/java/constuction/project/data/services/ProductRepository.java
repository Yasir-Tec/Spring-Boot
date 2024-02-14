package constuction.project.data.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import constuction.project.data.beans.Products;


@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
	
	List<Products> findByContractorId(Long contractorId);

}