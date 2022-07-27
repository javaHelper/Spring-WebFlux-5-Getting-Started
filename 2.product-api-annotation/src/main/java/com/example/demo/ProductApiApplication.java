package com.example.demo;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProductApiApplication.class, args);
	}

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		saveProducts();
	}

	public void saveProducts(){
		List<Product> products = List.of(
				Product.builder().name("Headphones").price(100d).build(),
				Product.builder().name("Shoes").price(220d).build(),
				Product.builder().name("Laptop").price(4000d).build(),
				Product.builder().name("Sony TV").price(750d).build(),
				Product.builder().name("Hero Car").price(7000d).build(),
				Product.builder().name("Cycle").price(600d).build()
		);

		productRepository.saveAll(products).subscribe(System.out::println);
	}
}
