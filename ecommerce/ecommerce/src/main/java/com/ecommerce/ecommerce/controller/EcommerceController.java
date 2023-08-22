package com.ecommerce.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.entity.Product;
import com.ecommerce.ecommerce.service.EcommerceService;
import com.ecommerce.ecommerce.service.ProductNotFoundException;
import com.ecommerce.ecommerce.service.ProductPriceNotFoundException;


@CrossOrigin(allowCredentials = "true",

		origins = "http://localhost:4200",

		allowedHeaders = "*",

		methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT }

)
@RestController
@RequestMapping("/api")
public class EcommerceController {
	@Autowired
	private EcommerceService ecommerceService;  
	@GetMapping("/availableProduct")  
	public List<Product> getProduct()
	{
		return ecommerceService.getProduct();
		
	}
	@GetMapping("/product/{productName}")
	public ResponseEntity<Product> getProductByName(@PathVariable String productName) throws ProductNotFoundException
	{
		
		return ecommerceService.getProductByName(productName);
		
	}
	@GetMapping("/sortingProduct")
	public List<Product> getsortingProduct()
	{
		return ecommerceService.getsortingProduct();
		
	}
	@GetMapping("/cycle")
	public List<Product> getProductPrice()
	{
		return  ecommerceService.getProductPrice();
	}

	@PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return ecommerceService.saveProduct(product);
    }
	@PutMapping("/updatingProduct")
	public Product updatingProduct(@RequestBody Product product) {
        return ecommerceService.updatingProduct(product);
    }
//	@DeleteMapping("/deleteProduct/{ProductId}")
//	public String deleteProduct(@PathVariable int productId)
//	{
//		return ecommerceService.delete(productId);
//	}
	@DeleteMapping("/deleteProduct/{ProductId}") //existingid nonexisting    
	private void deleteBook(@PathVariable("ProductId")int ProductId)   
	{  
		ecommerceService.delete(ProductId);
	}  
	
	@GetMapping("/gang")
	public List<Product> getsort()
	{
		return ecommerceService.getsort();
		
	}
		
	@GetMapping("/UsingView")
	public List<Product> getView()
	{
		return ecommerceService.getView();
		
	}
	
	@GetMapping("/productPrice/{productPrice}")
	public ResponseEntity<Product> getProductByPrice(@PathVariable int  productPrice) throws ProductPriceNotFoundException
	{
		return ecommerceService.getProductByPrice(productPrice);
	}
	
}
