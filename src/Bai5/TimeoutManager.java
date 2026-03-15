package Bai5;

import java.util.*;

public class TimeoutManager implements Runnable{

    List<TicketPool> pools;

    public TimeoutManager(List<TicketPool> pools){
        this.pools = pools;
    }

    public void run(){

        while(true){

            try{

                for(TicketPool p : pools){
                    p.releaseExpiredTickets();
                }

                Thread.sleep(1000);

            }catch(Exception e){}
        }
    }
}