package Bai2;

public class TicketSupplier implements Runnable {

    TicketPool roomA;
    TicketPool roomB;
    int rounds;
    int interval;
    int supply;

    public TicketSupplier(TicketPool A, TicketPool B, int supply, int interval, int rounds) {
        this.roomA = A;
        this.roomB = B;
        this.supply = supply;
        this.interval = interval;
        this.rounds = rounds;
    }

    public void run() {
        try {
            for (int i = 0; i < rounds; i++) {
                Thread.sleep(interval);
                roomA.addTickets(supply);
                roomB.addTickets(supply);
            }
        } catch (Exception e) {}
    }
}