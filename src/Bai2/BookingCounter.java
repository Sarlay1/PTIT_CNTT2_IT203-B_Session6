package Bai2;

import java.util.Random;
import Bai1.Ticket;
public class BookingCounter implements Runnable {

    String name;
    TicketPool A, B;
    int sold = 0;
    Random r = new Random();

    public BookingCounter(String name, TicketPool A, TicketPool B) {
        this.name = name;
        this.A = A;
        this.B = B;
    }

    public void run() {
        while (A.remaining() > 0 || B.remaining() > 0) {

            TicketPool room = r.nextBoolean() ? A : B;
            Ticket t = room.sellTicket();

            if (t != null) {
                sold++;
                System.out.println(name + " bán vé " + t.ticketId);
            }
        }
    }
}