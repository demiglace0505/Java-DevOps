package com.demiglace.springcloud.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demiglace.springcloud.dto.Coupon;
import com.demiglace.springcloud.model.Product;
import com.demiglace.springcloud.repos.ProductRepo;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {
	@Autowired
	ProductRepo repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${couponservice.url}")
	private String couponServiceURL;

	@RequestMapping(value="/products", method = RequestMethod.POST)
	public Product create(@RequestBody Product product) {
		Coupon coupon = restTemplate.getForObject(couponServiceURL + product.getCouponCode(), Coupon.class);
		// discount logic
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		
		return repo.save(product);
	}
}
