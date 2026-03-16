package Bai6;

import java.util.List;

class TicketCounter implements Runnable {

    private int id;
    private List<Room> rooms;
    private volatile boolean running = true;

    public TicketCounter(int id, List<Room> rooms) {
        this.id = id;
        this.rooms = rooms;
    }

    public void stopCounter() {
        running = false;
    }

    @Override
    public void run() {

        System.out.println("Quầy " + id + " bắt đầu bán vé...");

        while (running) {

            for (Room room : rooms) {
                synchronized (room) {
                    if (room.sellTicket()) {
                        System.out.println(
                                "Quầy " + id +
                                        " bán vé phòng " +
                                        room.getName()
                        );
                    }
                }
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}