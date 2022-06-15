package main.java;

import java.util.logging.Logger;

import main.java.service.impl.TicketProcessingServiceImpl;
import main.java.service.intf.TicketProcessingService;

public class FlightTicketUpgrader {
	
	private static final Logger log = Logger.getLogger(FlightTicketUpgrader.class.getName());

	private static TicketProcessingService ticketProcessingService = new TicketProcessingServiceImpl();
	
	public static void main(String[] args) {
		log.info("processing started");
		
		ticketProcessingService.process();
		
		log.info("processing completed");
	}
}
