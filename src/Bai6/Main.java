package Bai6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        CinemaSystem system = new CinemaSystem();

        while (true) {

            System.out.println("""
                    ===== MENU =====
                    1. Bắt đầu mô phỏng
                    2. Tạm dừng
                    3. Tiếp tục
                    4. Thêm vé
                    5. Xem thống kê
                    6. Phát hiện deadlock
                    7. Thoát
                    """);

            System.out.print("Chọn chức năng: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Số phòng: ");
                    int rooms = sc.nextInt();

                    System.out.print("Số vé/phòng: ");
                    int tickets = sc.nextInt();

                    System.out.print("Số quầy: ");
                    int counters = sc.nextInt();

                    system.startSimulation(rooms, tickets, counters);
                    break;

                case 2:
                    System.out.println("Đã tạm dừng mô phỏng.");
                    break;

                case 3:
                    System.out.println("Tiếp tục mô phỏng.");
                    break;

                case 4:
                    System.out.println("Chức năng thêm vé chưa cài đặt.");
                    break;

                case 5:
                    system.thongKe();
                    break;

                case 6:
                    System.out.println("Đang quét deadlock");
                    Thread deadlockThread =
                            new Thread(new DeadlockDetector());
                    deadlockThread.start();
                    break;

                case 7:
                    system.stopSimulation();
                    System.out.println("Đang dừng hệ thống");
                    System.out.println("Kết thúc chương trình.");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}