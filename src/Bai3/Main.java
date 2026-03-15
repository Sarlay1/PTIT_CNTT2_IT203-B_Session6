package Bai3;

public class Main {

    public static void main(String[] args) {

        TicketPool A = new TicketPool("A",5);
        TicketPool B = new TicketPool("B",5);

        BookingCounter c1 = new BookingCounter("Quầy 1",A,B);
        BookingCounter c2 = new BookingCounter("Quầy 2",A,B);

        TicketSupplier supplier = new TicketSupplier(A,B);

        new Thread(c1).start();
        new Thread(c2).start();
        new Thread(supplier).start();
    }
}