package com.uprm.prhr;

import com.uprm.prhr.models.Requester;
import com.uprm.prhr.models.Supplier;
import com.uprm.prhr.services.AdminService;
import com.uprm.prhr.services.CategoryService;
import com.uprm.prhr.services.ResourceService;
import com.uprm.prhr.services.UserService;
import com.uprm.prhr.services.SupplierService;
import com.uprm.prhr.services.RequesterService;

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
	private AdminService adminService;
	@Autowired
	private SupplierService supplierService;
	@Autowired
	private RequesterService requesterService;



	public static void main(String[] args) {
		SpringApplication.run(PrHurricaneReliefApplication.class, args);
	}

	public void runUser(){
		userService.createUser("theherbertperez", "thistookforever","Mayaguez","Herbert", "Perez");
		userService.createUser("K3RMoon","something","Mayaguez","Kelvin","Roche");
		userService.createUser("Captain Yuca","didthisthingfirst","San Juan", "Manuel", "Baez");
		userService.createUser("Medalla","Light","Ponce","Random","Person");

		adminService.createAdmin("Medalla");
		adminService.createAdmin("Captain Yuca");

		requesterService.createRequester("K3RMoon");
		requesterService.createRequester("Captain Yuca");

		supplierService.createSupplier("theherbertperez");
		supplierService.createSupplier("Captain Yuca");



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

		this.runUser();




	}
}
