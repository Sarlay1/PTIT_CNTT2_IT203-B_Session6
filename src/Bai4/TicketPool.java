package Bai4;

import java.util.*;

public class TicketPool {

    String room;
    List<Ticket> tickets = new ArrayList<>();

    public TicketPool(String room,int total){

        this.room = room;

        for(int i=1;i<=total;i++){
            tickets.add(new Ticket(room + "-" + String.format("%03d",i)));
        }
    }

    public Ticket getTicket(){

        for(Ticket t : tickets){
            if(!t.isSold){
                t.isSold = true;
                return t;
            }
        }
        return null;
    }

    public void returnTicket(Ticket t){
        if(t!=null) t.isSold = false;
    }
}