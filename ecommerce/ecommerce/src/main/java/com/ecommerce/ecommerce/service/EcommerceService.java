package com.ecommerce.ecommerce.service;
//import java.util.Comparator;

import java.util.List;
//import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ecommerce.ecommerce.entity.Product;
//import com.ecommerce.ecommerce.entity.Product;
import com.ecommerce.ecommerce.repository.EcommerceRepository;
@Service
public class EcommerceService {
@Autowired
private EcommerceRepository ecommerceRepository;

	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return ecommerceRepository.save(product);
	}
	public Product updatingProduct(Product product) {
		 Product existingProduct = ecommerceRepository.findById(product.getProductId()).orElse(null);
	        existingProduct.setProductName(product.getProductName());
	        existingProduct.setProductQuantity(product.getProductQuantity());
	        existingProduct.setProductPrice(product.getProductPrice());
	        return ecommerceRepository.save(existingProduct);
	}
	public void delete(int productId) {
		// TODO Auto-generated method stub
		 ecommerceRepository.deleteById(productId);
		
	}
	public List<Product> getsortingProduct() {
		List<Product> p1=ecommerceRepository.findAll() ;
		List<Product>p2=p1.stream()
			         .sorted()
			          .collect(Collectors.toList());
			        System.out.println(p2);
 return p2;
	}
	public List<Product> getProduct() {
		// TODO Auto-generated method stub
		return ecommerceRepository.findAll();
	}
	public List<Product> getProductPrice() {
		// TODO Auto-generated method stub
		return ecommerceRepository.getProductPrice();
	}
	public List<Product> getsort() {
		// TODO Auto-generated method stub
		return ecommerceRepository.getsort();
	}
	public List<Product> getView() {
		
		return ecommerceRepository.getView();
	}
	public ResponseEntity<Product> getProductByName(@PathVariable String productName) throws ProductNotFoundException {
		// TODO Auto-generated method stub
//		if(productName.isExist)
//		{
//			
//		}
		Product product1=ecommerceRepository.findByproductName(productName)
				.orElseThrow(()->new ProductNotFoundException("product not found"+productName));
	return ResponseEntity.ok(product1);
	}

	public ResponseEntity<Product> getProductByPrice(int  productPrice) throws ProductPriceNotFoundException{
		
		Product product2=ecommerceRepository.findByproductPrice(productPrice).orElseThrow(()->new ProductPriceNotFoundException("productPrice not found"+productPrice));
		// TODO Auto-generated method stub
		return ResponseEntity.ok(product2);
	}
	
	
	
}