package main.java.service.impl;

import java.text.ParseException;

import main.java.dto.Ticket;
import main.java.enums.Cabin;
import main.java.service.intf.ValidationService;
import main.java.util.DateUtil;
import main.java.util.StringUtil;

public class TicketValidationServiceImpl implements ValidationService {
	
	@Override
	public String validate(Ticket ticket) {
		StringBuilder errorMessageBuilder = new StringBuilder();
		if(!StringUtil.isValideEmail(ticket.getEmail()))
			errorMessageBuilder.append("Email Invalid").append("-");
		
		if(!StringUtil.isValideMobileNumber(ticket.getMobileNumber()))
			errorMessageBuilder.append("Mobile Number Invalid").append("-");
		
		if(!StringUtil.isValideFareClass(ticket.getFareClass()))
			errorMessageBuilder.append("Fare Class Invalid").append("-");
		
		try {
			if(DateUtil.compareDates(ticket.getTicketingDate(), ticket.getTravelDate())>0)
				errorMessageBuilder.append("Ticketing Date Must be before travel date").append("-");
		} catch (ParseException e) {
			errorMessageBuilder.append("Date Format Invalid").append("-");
		}
		
		if(!StringUtil.isValidePNR(ticket.getPnr()))
			errorMessageBuilder.append("PNR Invalid").append("-");
		
		if(!Cabin.isValidByDescription(ticket.getBookedCabin()))
			errorMessageBuilder.append("Cabin Invalid").append("-");
		
		return errorMessageBuilder.toString();
	}

}
