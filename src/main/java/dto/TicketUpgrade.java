package main.java.dto;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TicketUpgrade extends Ticket {

	private String discountCode;
	
	public TicketUpgrade(Ticket ticket) {
		super();
		this.setFirstName(ticket.getFirstName());
		this.setLastName(ticket.getLastName());
		this.setEmail(ticket.getEmail());
		this.setMobileNumber(ticket.getMobileNumber());
		this.setPnr(ticket.getPnr());
		this.setFareClass(ticket.getFareClass());
		this.setTravelDate(ticket.getTravelDate());
		this.setPax(ticket.getPax());
		this.setTicketingDate(ticket.getTicketingDate());
		this.setBookedCabin(ticket.getBookedCabin());
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}
	
	@Override
	public String convertToCSVLine(String separator) {
		
		String[] data = new String[] {
				getFirstName(),
				getLastName(),
				getPnr(),
				getFareClass(),
				getTravelDate(),
				getPax(),
				getTicketingDate(),
				getEmail(),
				getMobileNumber(),
				getBookedCabin(),
				getDiscountCode(),
		};
		
	    return Stream.of(data)
	      .collect(Collectors.joining(separator));
	}
}
