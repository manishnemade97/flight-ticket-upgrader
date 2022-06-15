package test.java;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.java.dto.Ticket;
import main.java.service.impl.FlightTicketUpgraderServiceImpl;

public class TestTicketUpgrader {

	private Ticket ticket1;
	private FlightTicketUpgraderServiceImpl ticketUpgraderService;
	
    @Before
    public void setUp() throws Exception {  
    	
    	String[] row = new String[] {"Abhishek","Kumar","ABC123","F","2019-07-31","2","2019-05-21","abhishek@zzz.com","9876543210","Economy"};
    	
    	ticket1 = new Ticket();
    	ticket1.setFirstName(row[0].trim());
		ticket1.setLastName(row[1].trim());
		ticket1.setPnr(row[2].trim());
		ticket1.setFareClass(row[3].trim());
		ticket1.setTravelDate(row[4].trim());
		ticket1.setPax(row[5].trim());
		ticket1.setTicketingDate(row[6].trim());
		ticket1.setEmail(row[7].trim());
		ticket1.setMobileNumber(row[8].trim());
		ticket1.setBookedCabin(row[9].trim());
		
		ticketUpgraderService = new FlightTicketUpgraderServiceImpl();
    } 
    
    @Test
    public void validateTicketUpgrade() {
    	Assert.assertEquals("OFFER_30", ticketUpgraderService.upgradeTicket(ticket1).getDiscountCode());
    }
}
