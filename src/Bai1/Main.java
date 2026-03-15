package Bai1;

public class Main {

    public static void main(String[] args) throws Exception {

        TicketPool A = new TicketPool("A", 10);
        TicketPool B = new TicketPool("B", 10);

        Booking c1 = new Booking("Quầy 1", A, B);
        Booking c2 = new Booking("Quầy 2", A, B);

        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("\nKết thúc");
        System.out.println("Quầy 1 bán: " + c1.sold);
        System.out.println("Quầy 2 bán: " + c2.sold);
        System.out.println("Còn phòng A: " + A.remaining());
        System.out.println("Còn phòng B: " + B.remaining());
    }
}