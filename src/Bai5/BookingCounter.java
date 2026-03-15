package Bai5;

import java.util.*;

public class BookingCounter implements Runnable{

    String name;
    List<TicketPool> pools;
    Random rand = new Random();

    public BookingCounter(String name,List<TicketPool> pools){

        this.name = name;
        this.pools = pools;
    }

    public void run(){

        while(true){

            try{

                TicketPool pool = pools.get(rand.nextInt(pools.size()));

                boolean vip = rand.nextBoolean();

                Ticket t = pool.holdTicket(vip);

                if(t!=null){

                    System.out.println(name+" giữ "+t.ticketId);

                    Thread.sleep(3000);

                    pool.sellHeldTicket(t);
                }

                Thread.sleep(1000);

            }catch(Exception e){}
        }
    }
}