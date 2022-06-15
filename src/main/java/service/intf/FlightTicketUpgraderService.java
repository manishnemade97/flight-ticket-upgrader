package main.java.service.intf;

import main.java.dto.Ticket;
import main.java.dto.TicketUpgrade;

public interface FlightTicketUpgraderService {

	TicketUpgrade upgradeTicket(Ticket ticket);
}
