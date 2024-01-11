import java.util.*;
//All about booking methods
public class Booking {
    public static List<Taxi> createTaxis(int n){
        List<Taxi>Taxis= new ArrayList<>();
        for(int i=0;i<n;i++){
            Taxi t=new Taxi();
            Taxis.add(t);
        }
        return Taxis;
    }
    public static List<Taxi> getFreeTaxis(List<Taxi>Taxis,char From,int PickUpTime){
        List<Taxi>freeTaxis=new ArrayList<>();
        for(Taxi t:Taxis){
            if(t.freeTime<=PickUpTime && (Math.abs((t.CurrentSpot-'0')-(From-'0'))<=PickUpTime-t.freeTime)){
                freeTaxis.add(t);
            }
        }
        return freeTaxis;
    }

    public static void BookTaxi(int CustomerID,char From,char To,int PickUpTime,List<Taxi>freeTaxis){
        int min=1000;
        int nextFreeTime=0;
        int distanceBWCustomerAndTaxi=0;
        char nextSpot='Z';
        Taxi bookedTaxi=null;
        int earnings=0;
        String tripDetail="";
        for(Taxi t:freeTaxis){
            distanceBWCustomerAndTaxi=Math.abs(((t.CurrentSpot-'0')-(From-'0'))*15);

            if(distanceBWCustomerAndTaxi<min){
                int distanceBWFromAndTo=Math.abs(((To-'0')-(From-'0'))*15);
                bookedTaxi=t;
                earnings=(distanceBWFromAndTo-5)*10+100;
                int DropTime=PickUpTime+distanceBWFromAndTo/15;
                nextFreeTime=DropTime;
                nextSpot=To;
                tripDetail="    "+CustomerID+"             "+CustomerID+"             "+From+"         "+To+"           "+PickUpTime+"              "+DropTime+"             "+earnings;
                break;
            }
            else{
                min=distanceBWCustomerAndTaxi;
            }
        }
        bookedTaxi.setDetails(true,nextSpot,earnings+bookedTaxi.TotalEarnings,nextFreeTime,tripDetail);
        System.out.println("Taxi "+bookedTaxi.TaxiID+" Booked");
    }

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        List<Taxi>Taxis=createTaxis(4);
        int BookingID=1;
        while (true){
            System.out.println("_________________CALL TAXI BOOKING___________________");
            System.out.println("Enter 1 for Booking----------" );
            System.out.println("Enter 2 for Display----------" );
            System.out.println("Enter 3 for Exit   ----------" );
            int ch=in.nextInt();
            switch (ch){
                case 1:
                    System.out.println("Customer Id - "+BookingID);
                    System.out.println("Pickup Point - ");
                    char From=in.next().charAt(0);
                    System.out.println("Drop Point - ");
                    char To=in.next().charAt(0);
                    System.out.println("PickUpTime - ");
                    int PickUpTime=in.nextInt();
                    if(From<'A' || From>'F' || To<'A' || To>'F'){
                        System.out.println("Allocated PickUp and Drops are A,B,C,D,E,F. Customize your input");
                        return;
                    }
                    List<Taxi>freeTaxis=getFreeTaxis(Taxis,From,PickUpTime);
                    if(freeTaxis.size()==0){
                        System.out.println("No more Taxis can be allocating, Exiting");
                        return;
                    }
                    Collections.sort(freeTaxis,(a, b)->a.TotalEarnings-b.TotalEarnings);
                    BookTaxi(BookingID,From,To,PickUpTime,freeTaxis);
                    BookingID++;
                    break;
                case 2:
                    for(Taxi t:Taxis){
                        t.printTaxiDetails();
                    }
                    for(Taxi t:Taxis){
                        t.printDetails();
                    }
                    break;
                case 3:
                    System.exit(1);
                default:
                    System.out.println("Choose among 1,2,3");
                    return;
            }
        }
    }


}
