package main.java.service.impl;

import java.util.ArrayList;
import java.util.List;

import main.java.dto.Ticket;
import main.java.service.intf.CSVReaderService;
import main.java.service.intf.TicketCSVParserService;

public class TicketCSVParserServiceImpl implements TicketCSVParserService {
	
	private CSVReaderService csvReaderService = new CSVReaderServiceImpl();

	@Override
	public List<Ticket> parseTicketCSV(String filePath, String separator) {
		
		List<String[]> data= csvReaderService.readData(filePath, separator);
		
		List<Ticket> tickets = new ArrayList<>();
		
		for (String[] row : data) {
			Ticket ticket = new Ticket();
			
			ticket.setFirstName(row[0].trim());
			ticket.setLastName(row[1].trim());
			ticket.setPnr(row[2].trim());
			ticket.setFareClass(row[3].trim());
			ticket.setTravelDate(row[4].trim());
			ticket.setPax(row[5].trim());
			ticket.setTicketingDate(row[6].trim());
			ticket.setEmail(row[7].trim());
			ticket.setMobileNumber(row[8].trim());
			ticket.setBookedCabin(row[9].trim());
			
			tickets.add(ticket);
		}
		
		return tickets;
	}

}
