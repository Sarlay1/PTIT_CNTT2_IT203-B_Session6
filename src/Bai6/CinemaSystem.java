package Bai6;

import java.util.*;
import java.util.concurrent.*;

public class CinemaSystem {

    private List<Room> rooms = new ArrayList<>();

    private ExecutorService executor;

    public void startSimulation(int roomCount, int tickets, int counterCount) {

        for (int i = 0; i < roomCount; i++) {

            rooms.add(
                    new Room("Phòng " + (char)('A' + i), tickets)
            );
        }

        executor = Executors.newFixedThreadPool(counterCount);

        for (int i = 1; i <= counterCount; i++) {

            TicketCounter counter =
                    new TicketCounter(i, rooms);

            executor.submit(counter);
        }

        System.out.println(
                "Đã khởi tạo hệ thống với "
                        + roomCount + " phòng, "
                        + (roomCount * tickets)
                        + " vé, "
                        + counterCount
                        + " quầy"
        );
    }

    public void stopSimulation() {

        executor.shutdownNow();

        System.out.println("Đã dừng hệ thống.");
    }

    public void thongKe() {

        System.out.println("=== THỐNG KÊ HIỆN TẠI ===");

        int revenue = 0;

        for (Room r : rooms) {

            System.out.println(
                    r.getName() +
                            ": Đã bán "
                            + r.getSoldTickets() +
                            "/" +
                            r.getTotalTickets()
            );

            revenue += r.getSoldTickets() * 250000;
        }

        System.out.println("Tổng doanh thu: " + revenue + " VNĐ");
    }
}