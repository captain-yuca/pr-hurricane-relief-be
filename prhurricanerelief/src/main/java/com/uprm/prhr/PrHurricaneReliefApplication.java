package com.uprm.prhr;

import com.uprm.prhr.models.Requester;
import com.uprm.prhr.models.User;
import com.uprm.prhr.services.*;
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Hashtable;

@SpringBootApplication
public class PrHurricaneReliefApplication implements CommandLineRunner{
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private ResourceRequestService resourceRequestService;
	@Autowired
	private AvailabilityAnnouncementService availabilityAnnouncementService;
	@Autowired
	private ResourceTransactionService resourceTransactionService;
	@Autowired
	private StockService stockService;
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

		User usr1 = userService.createUser("Kelvin", "helloworld", "Mayaguez", "Herbert", "Perez");
		User usr2 = userService.createUser("Manuel", "12345", "San Juan", "Herbert", "Perez");
		Supplier sup1 = supplierService.createSupplier("Kelvin");
		Supplier sup2 = supplierService.createSupplier("Manuel");

		ArrayList<User> users = new ArrayList<>();
		users.add(usr1);
		users.add(usr2);
		this.createResourceRequestsAndRequesters(users);
		this.createAvailabilityAnnouncementsAndSuppliers(users);
		this.createStocks(usr1, usr2, sup1, sup2);

		this.runUser();



	}

	private void createResourceRequestsAndRequesters(Collection<User> users){
		for(User user: users){
			Requester r = requesterService.createRequester(user.getName());


			Hashtable<Long, Long> resourceQtyHT1 = new Hashtable<>();

			resourceQtyHT1.put(new Long(1), new Long(3));
			resourceQtyHT1.put(new Long(2), new Long(20));
			resourceRequestService.createResourceRequest(resourceQtyHT1, user.getName());

		}



	}

	private void createAvailabilityAnnouncementsAndSuppliers(Collection<User> users){

		for(User user: users){
//			Supplier s = supplierService.createSupplier(user.getName());

			Hashtable<Long, Long> resourceQtyHT1 = new Hashtable<>();
			resourceQtyHT1.put(new Long(1), new Long(3));
			resourceQtyHT1.put(new Long(2), new Long(20));
			availabilityAnnouncementService.createAvailabilityAnnouncement(resourceQtyHT1, user.getName());
		}


	}

	private void createStocks(User usr1, User usr2, Supplier sup1, Supplier sup2)
	{
		stockService.createStock(usr1.getId(), "Dasani 8oz", 1.00, 6);
		stockService.createStock(usr2.getId(), "Taino", 0.99, 12);
		stockService.createStock(usr1.getId(), "Manantial", 1.50, 20);

		resourceTransactionService.createResourceTransaction(usr1.getId(), sup2.getId(), new Date(2017, 12, 1), "Taino", 4);
        resourceTransactionService.createResourceTransaction(usr1.getId(), sup2.getId(), new Date(2017, 12, 2), "Nikini 8oz", 2);
        resourceTransactionService.createResourceTransaction(usr2.getId(), sup1.getId(), new Date(2017, 12, 2), "Manantial", 4);
	}
}
