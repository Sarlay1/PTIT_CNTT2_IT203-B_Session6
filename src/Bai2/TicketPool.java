package Bai2;

import Bai1.Ticket;

import java.util.*;

public class TicketPool {

    String roomName;
    List<Ticket> tickets = new ArrayList<>();
    int id = 1;

    public TicketPool(String roomName, int total) {
        this.roomName = roomName;
        for (int i = 1; i <= total; i++) {
            tickets.add(new Ticket(roomName + "-" + String.format("%03d", i), roomName));
        }
        id = total + 1;
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

    public synchronized void addTickets(int count) {
        for (int i = 0; i < count; i++) {
            tickets.add(new Ticket(roomName + "-" + String.format("%03d", id++), roomName));
        }
        System.out.println("Nhà cung cấp thêm " + count + " vé phòng " + roomName);
    }

    public int remaining() {
        int count = 0;
        for (Ticket t : tickets) if (!t.isSold) count++;
        return count;
    }
}