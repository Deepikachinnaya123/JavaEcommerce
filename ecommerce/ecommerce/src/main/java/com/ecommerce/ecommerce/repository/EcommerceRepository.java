package com.ecommerce.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce.entity.Product;
@Repository

public interface EcommerceRepository extends JpaRepository<Product,Integer> {
@Query(value="select * from product_table where product_name='laptop' and product_price=50000",nativeQuery=true)
	List<Product> getProductPrice();
@Query(value="call practical.hello();",nativeQuery=true)
List<Product> getsort();
@Query(value=" SELECT * FROM practical.hello2;",nativeQuery=true)
List<Product> getView();

Optional<Product> findByproductName(String productName);
Optional<Product> findByproductPrice(int productPrice);


}
