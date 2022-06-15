package main.java.service.impl;

import main.java.dto.Ticket;
import main.java.dto.TicketUpgrade;
import main.java.service.intf.FlightTicketUpgraderService;
import main.java.util.DiscountUtil;

public class FlightTicketUpgraderServiceImpl implements FlightTicketUpgraderService {

	@Override
	public TicketUpgrade upgradeTicket(Ticket ticket) {

		TicketUpgrade ticketUpgrade = new TicketUpgrade(ticket);
		
		String discountCode = DiscountUtil.getDiscountCode(ticketUpgrade.getFareClass());
		
		ticketUpgrade.setDiscountCode(discountCode);

		return ticketUpgrade;
	}

}
