package com.demiglace.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demiglace.springcloud.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
