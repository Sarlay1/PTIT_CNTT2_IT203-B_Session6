package Bai3;

import java.util.*;

public class TicketPool {

    String roomName;
    List<Ticket> tickets = new ArrayList<>();
    int id = 1;

    public TicketPool(String roomName, int total) {
        this.roomName = roomName;

        for(int i=0;i<total;i++){
            tickets.add(new Ticket(roomName + "-" + String.format("%03d", id++), roomName));
        }
    }

    public synchronized Ticket sellTicket() {

        while (true) {

            for (Ticket t : tickets) {
                if (!t.isSold) {
                    t.isSold = true;
                    return t;
                }
            }

            try {
                System.out.println("Hết vé phòng " + roomName + ", đang chờ...");
                wait();
            } catch (Exception e) {}
        }
    }

    public synchronized void addTickets(int count) {

        for(int i=0;i<count;i++){
            tickets.add(new Ticket(roomName + "-" + String.format("%03d", id++), roomName));
        }

        System.out.println("Nhà cung cấp: thêm " + count + " vé phòng " + roomName);

        notifyAll();
    }
}