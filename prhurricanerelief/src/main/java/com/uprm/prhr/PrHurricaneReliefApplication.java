package com.uprm.prhr;

import com.uprm.prhr.models.Category;
import com.uprm.prhr.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

		this.createResourceRequests();


	}

	private void createResourceRequests(){
		Hashtable<Long, Long> resourceQtyHT1 = new Hashtable<>();

		resourceQtyHT1.put(new Long(1), new Long(3));
		resourceQtyHT1.put(new Long(2), new Long(20));
		resourceRequestService.createResourceRequest(resourceQtyHT1);

		Hashtable<Long, Long> resourceQtyHT2 = new Hashtable<>();

		resourceQtyHT2.put(new Long(4), new Long(3));
		resourceQtyHT2.put(new Long(5), new Long(20));
		resourceRequestService.createResourceRequest(resourceQtyHT2);
	}

	private void createAvailabilityAnnouncements(){
		Hashtable<Long, Long> resourceQtyHT1 = new Hashtable<>();

		resourceQtyHT1.put(new Long(1), new Long(3));
		resourceQtyHT1.put(new Long(2), new Long(20));
		availabilityAnnouncementService.createAvailabilityAnnouncement(resourceQtyHT1);

		Hashtable<Long, Long> resourceQtyHT2 = new Hashtable<>();

		resourceQtyHT2.put(new Long(4), new Long(3));
		resourceQtyHT2.put(new Long(5), new Long(20));
		availabilityAnnouncementService.createAvailabilityAnnouncement(resourceQtyHT2);
	}

	private void createStocks()
	{
		stockService.createStock((long)6700, "Dasani", 1.00, 6);
		stockService.createStock((long)5532, "Taino", 0.99, 12);
		stockService.createStock((long)6700, "Manantial", 1.50, 20);
	}
}
