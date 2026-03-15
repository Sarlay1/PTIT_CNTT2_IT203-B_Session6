package Bai4;

public class BookingCounter implements Runnable{

    String name;
    TicketPool roomA;
    TicketPool roomB;
    boolean lockAFirst;

    public BookingCounter(String name,TicketPool A,TicketPool B,boolean lockAFirst){

        this.name = name;
        this.roomA = A;
        this.roomB = B;
        this.lockAFirst = lockAFirst;
    }

    public void run(){

        if(lockAFirst){
            sellCombo(roomA,roomB);
        }else{
            sellCombo(roomB,roomA);
        }
    }

    public void sellCombo(TicketPool first,TicketPool second){

        synchronized(first){

            System.out.println(name+" đã khóa "+first.room);

            try{ Thread.sleep(500); }catch(Exception e){}

            synchronized(second){

                System.out.println(name+" đã khóa "+second.room);

                Ticket t1 = first.getTicket();
                Ticket t2 = second.getTicket();

                if(t1!=null && t2!=null){

                    System.out.println(name+" bán combo: "+t1.ticketId+" & "+t2.ticketId);

                }else{

                    first.returnTicket(t1);
                    second.returnTicket(t2);

                    System.out.println(name+" bán combo thất bại");
                }
            }
        }
    }
}