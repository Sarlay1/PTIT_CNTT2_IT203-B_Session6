package Bai3;

import java.util.Random;

public class BookingCounter implements Runnable {

    String name;
    TicketPool A, B;
    Random rand = new Random();

    public BookingCounter(String name, TicketPool A, TicketPool B) {
        this.name = name;
        this.A = A;
        this.B = B;
    }

    public void run() {

        while (true) {

            TicketPool room = rand.nextBoolean() ? A : B;

            Ticket t = room.sellTicket();

            if (t != null) {
                System.out.println(name + " bán vé " + t.ticketId);
            }
        }
    }
}