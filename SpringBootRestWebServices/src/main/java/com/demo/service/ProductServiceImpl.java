package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ProductDao;
import com.demo.model.Product;


@Service
public class ProductServiceImpl implements ProductService {
	
	
	@Autowired
	private ProductDao pdao;

	@Override
	public List<Product> getAllProducts() {
		
		return pdao.findAll();
	}

	@Override
	public Product getById(int pid) {
	
		Optional<Product> ps= pdao.findById(pid);
		if(ps.isPresent())
		{
			return ps.get();
		}
		else
		{
			return null;
		}
		
		
	}

	@Override
	public void addNewProduct(Product p) {
		pdao.save(p);
		
	}

	@Override
	public void updateProduct(Product p) 
	{
		Optional<Product> ps = pdao.findById(p.getPid());
		if(ps.isPresent())
		{
			Product p1 = ps.get();
			p1.setPname(p.getPname());
			p1.setPrice(p.getPrice());
			p1.setQty(p.getQty());
			pdao.save(p1);
		}
		
	}

	@Override
	public void deleteById(int pid) {
		pdao.deleteById(pid);
		
	}

	@Override
	public List<Product> getByPrice(int lpr, int hpr) {
	
		List<Product> plist=pdao.findbyPrice(lpr,hpr);
		System.out.println(plist);
		return plist;
	}
	

}
