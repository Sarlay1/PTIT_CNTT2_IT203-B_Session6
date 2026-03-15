package Bai5;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        TicketPool A = new TicketPool("A",5);
        TicketPool B = new TicketPool("B",7);
        TicketPool C = new TicketPool("C",6);

        List<TicketPool> pools = Arrays.asList(A,B,C);

        for(int i=1;i<=5;i++){
            new Thread(new BookingCounter("Quầy "+i,pools)).start();
        }

        new Thread(new TimeoutManager(pools)).start();
    }
}