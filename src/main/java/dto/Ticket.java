package main.java.dto;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import main.java.service.intf.CsvPojo;

public class Ticket implements CsvPojo{
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String mobileNumber;
	
	private String pnr;
	
	private String fareClass;
	
	private String travelDate;

	private String pax;
	
	private String ticketingDate;
	
	private String bookedCabin;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public String getFareClass() {
		return fareClass;
	}

	public void setFareClass(String fareClass) {
		this.fareClass = fareClass;
	}

	public String getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(String travelDate) {
		this.travelDate = travelDate;
	}

	public String getPax() {
		return pax;
	}

	public void setPax(String pax) {
		this.pax = pax;
	}

	public String getTicketingDate() {
		return ticketingDate;
	}

	public void setTicketingDate(String ticketingDate) {
		this.ticketingDate = ticketingDate;
	}

	public String getBookedCabin() {
		return bookedCabin;
	}

	public void setBookedCabin(String bookedCabin) {
		this.bookedCabin = bookedCabin;
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
		};
		
	    return Stream.of(data)
	      .collect(Collectors.joining(separator));
	}
}
