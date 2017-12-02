package com.uprm.prhr;

import com.uprm.prhr.models.Category;
import com.uprm.prhr.models.User;
import com.uprm.prhr.services.CategoryService;
import com.uprm.prhr.services.ResourceService;
import com.uprm.prhr.services.StockService;
import com.uprm.prhr.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrHurricaneReliefApplication implements CommandLineRunner{
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private UserService userService;
	@Autowired
	private StockService stockService;

	public static void main(String[] args) {
		SpringApplication.run(PrHurricaneReliefApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		categoryService.createCategory("Water", null);
		categoryService.createCategory("Bottled Water", "Water");
		categoryService.createCategory("Gallon Water", "Water");

		resourceService.createResource("Nikini 8oz","Bottled Water");
		resourceService.createResource("Dasani 8oz","Bottled Water");
		resourceService.createResource("Dasani 1gal","Gallon Water");
		resourceService.createResource("Manantial","Gallon Water");
		resourceService.createResource("Taino","Bottled Water");

		userService.createUser("Herbert","ihateddoingthis","Mayaguez");
		userService.createUser("Kelvin","something","Mayaguez");
		userService.createUser("Manuel","didthisthingfirst","San Juan");

		stockService.createStock((long)6700, (long)555678, 3.99, 5);
		stockService.createStock((long) 6700, (long) 555679, 5.00, 2);
		stockService.createStock((long) 5532, (long) 555680, 3.99, 2);

	}



}
