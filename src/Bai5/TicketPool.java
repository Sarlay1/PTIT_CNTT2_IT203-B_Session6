package Bai5;

import java.util.*;

public class TicketPool {

    String room;
    List<Ticket> tickets = new ArrayList<>();

    public TicketPool(String room,int total){

        this.room = room;

        for(int i=1;i<=total;i++){
            tickets.add(new Ticket(room+"-"+String.format("%03d",i)));
        }
    }

    public synchronized Ticket holdTicket(boolean vip){

        long now = System.currentTimeMillis();

        for(Ticket t : tickets){

            if(!t.isSold && !t.isHeld){

                t.isHeld = true;
                t.isVIP = vip;
                t.holdExpiryTime = now + 5000;

                System.out.println("Đã giữ vé "+t.ticketId+(vip?" (VIP)":"")+" trong 5s");

                return t;
            }
        }

        return null;
    }

    public synchronized void sellHeldTicket(Ticket t){

        if(t!=null && t.isHeld){

            t.isHeld = false;
            t.isSold = true;

            System.out.println("Thanh toán thành công "+t.ticketId);
        }
    }

    public synchronized void releaseExpiredTickets(){

        long now = System.currentTimeMillis();

        for(Ticket t : tickets){

            if(t.isHeld && !t.isSold && now > t.holdExpiryTime){

                t.isHeld = false;
                System.out.println("TimeoutManager: "+t.ticketId+" hết hạn giữ");
            }
        }
    }
}