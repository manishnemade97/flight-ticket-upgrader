package main.java.service.impl;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import main.java.constants.ApplicationProperties;
import main.java.constants.Constants;
import main.java.dto.Ticket;
import main.java.dto.TicketError;
import main.java.service.intf.CSVWriterService;
import main.java.service.intf.CsvPojo;
import main.java.service.intf.FlightTicketUpgraderService;
import main.java.service.intf.TicketCSVParserService;
import main.java.service.intf.TicketProcessingService;
import main.java.service.intf.ValidationService;

public class TicketProcessingServiceImpl implements TicketProcessingService {
	
	private static final Logger log = Logger.getLogger(TicketProcessingServiceImpl.class.getName());

	private TicketCSVParserService csvParserService = new TicketCSVParserServiceImpl();
	
	private ValidationService validationService = new TicketValidationServiceImpl();
	
	private FlightTicketUpgraderService ticketUpgrader = new FlightTicketUpgraderServiceImpl();
	
	private CSVWriterService csvWriterService = new CSVWriterServiceImpl();
	
	@Override
	public void process() {
		
		List<Ticket> tickets = csvParserService.parseTicketCSV(ApplicationProperties.CSV_INPUT_PATH, ApplicationProperties.CSV_SEPARATOR);
		
		List<CsvPojo> errorList = new ArrayList<>();
		
		List<CsvPojo> upgradeList = new ArrayList<>();
		
		for (Ticket ticket : tickets) {
			String errorMsg = validationService.validate(ticket);
			if (!errorMsg.isEmpty()) {
				
				TicketError ticketError = new TicketError(ticket);
				ticketError.setErrorMessage(errorMsg);
				errorList.add(ticketError);

			} else {
				
				upgradeList.add(ticketUpgrader.upgradeTicket(ticket));
			}
		}
		
		try {
			csvWriterService.writeCsv(ApplicationProperties.CSV_UPGRADE_OUTPUT_PATH, ApplicationProperties.CSV_SEPARATOR, upgradeList, Constants.DISCOUNT_CSV_HEADER);
			csvWriterService.writeCsv(ApplicationProperties.CSV_ERROR_OUTPUT_PATH, ApplicationProperties.CSV_SEPARATOR, errorList, Constants.ERROR_CSV_HEADER);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
