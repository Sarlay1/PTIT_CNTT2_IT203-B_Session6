package Bai3;

public class TicketSupplier implements Runnable {

    TicketPool A,B;

    public TicketSupplier(TicketPool A, TicketPool B){
        this.A = A;
        this.B = B;
    }

    public void run(){

        try{

            while(true){

                Thread.sleep(3000);

                A.addTickets(3);
                B.addTickets(3);
            }

        }catch(Exception e){}
    }
}