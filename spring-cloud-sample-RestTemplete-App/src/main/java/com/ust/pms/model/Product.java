package com.ust.pms.model;

import lombok.Data;


@Data
public class Product {
	
	private  int productId;
	private String productName;
	private  int qualityOnHand;
	private  int price;
}
