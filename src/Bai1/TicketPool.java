package Bai1;

import java.util.*;

public class TicketPool {
    String roomName;
    List<Ticket> tickets = new ArrayList<>();

    public TicketPool(String roomName, int total) {
        this.roomName = roomName;
        for (int i = 1; i <= total; i++) {
            tickets.add(new Ticket(roomName + "-" + String.format("%03d", i), roomName));
        }
    }

    public synchronized Ticket sellTicket() {
        for (Ticket t : tickets) {
            if (!t.isSold) {
                t.isSold = true;
                return t;
            }
        }
        return null;
    }

    public int remaining() {
        int count = 0;
        for (Ticket t : tickets) if (!t.isSold) count++;
        return count;
    }
}