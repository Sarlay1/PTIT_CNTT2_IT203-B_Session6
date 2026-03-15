package Bai5;

public class Ticket {

    public String ticketId;
    public boolean isHeld = false;
    public boolean isSold = false;
    public boolean isVIP = false;
    public long holdExpiryTime = 0;

    public Ticket(String id){
        this.ticketId = id;
    }
}