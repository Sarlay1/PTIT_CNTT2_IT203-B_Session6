package Bai6;

class Room {
    private String name;
    private int totalTickets;
    private int soldTickets;

    public Room(String name, int totalTickets) {
        this.name = name;
        this.totalTickets = totalTickets;
        this.soldTickets = 0;
    }

    public synchronized boolean sellTicket() {
        if (soldTickets < totalTickets) {
            soldTickets++;
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public int getSoldTickets() {
        return soldTickets;
    }

    public int getTotalTickets() {
        return totalTickets;
    }
}