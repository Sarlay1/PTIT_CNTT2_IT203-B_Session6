package Bai1;

import java.util.Random;

public class Booking implements Runnable {

    String name;
    TicketPool roomA;
    TicketPool roomB;
    int sold = 0;
    Random rand = new Random();

    public Booking(String name, TicketPool A, TicketPool B) {
        this.name = name;
        this.roomA = A;
        this.roomB = B;
    }

    public void run() {
        while (roomA.remaining() > 0 || roomB.remaining() > 0) {

            Ticket ticket;

            if (rand.nextBoolean())
                ticket = roomA.sellTicket();
            else
                ticket = roomB.sellTicket();

            if (ticket != null) {
                sold++;
                System.out.println(name + " bán vé " + ticket.ticketId);
            }
        }
    }
}