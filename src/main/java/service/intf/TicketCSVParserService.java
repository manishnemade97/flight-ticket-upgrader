package main.java.service.intf;

import java.util.List;

import main.java.dto.Ticket;

public interface TicketCSVParserService {

	List<Ticket> parseTicketCSV(String filePath, String separator);
}
