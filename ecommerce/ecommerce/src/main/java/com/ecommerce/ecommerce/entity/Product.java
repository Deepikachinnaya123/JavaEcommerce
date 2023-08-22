package com.ecommerce.ecommerce.entity;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="productTable")
public class Product  {
	@Override
	public String toString() {
		return "Ecommerce [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productColor=" + productColor + ", productQuantity=" + productQuantity + "]";
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductColor() {
		return productColor;
	}
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	@Id
	@GeneratedValue
	@Column(name="id")
	private int productId;
	@Column(name="product_name")
	private String productName;
	@Column(name="productPrice")
	private int productPrice;
	@Column(name="productColor")
	private String productColor;
	@Column(name="productQuantity")
	private int productQuantity;


}
