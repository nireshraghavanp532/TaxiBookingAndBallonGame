import java.util.*;
//All about TAXI details
public class Taxi {
    //define the required parameters
     boolean booked;
     char CurrentSpot;
     int TotalEarnings,freeTime;
    static int TaxiCount=0;
     int TaxiID=0;
    //public static int TaxiID=0;

    // define the data structures to be used
    List<String>trips;

    //create constructor
    public Taxi(){
        booked=false;
        trips=new ArrayList<>();
        TotalEarnings=0;
        TaxiCount++;//gives taxi count
        TaxiID=TaxiCount;//generate the taxiID on count
        freeTime=6;//service start by 6am
        CurrentSpot='A';//all taxi are currently at Spot A
    }
    public  void setDetails(boolean booked,char CurrentSpot,int totalEarnings,int freeTime,String tripDetails){
        this.booked=booked;
        this.CurrentSpot=CurrentSpot;
        this.TotalEarnings=totalEarnings;
        this.freeTime=freeTime;
        this.trips.add(tripDetails);
    }


    public  void printDetails(){
        System.out.println("Taxi- "+this.TaxiID+" Total Earnings- "+this.TotalEarnings);
        System.out.println("TaxiID____BookingID_____CustomerID______From______To______PickUpTIme_________DropTIme______AMount___  ");
        for(String trip :this.trips){
            System.out.println(this.TaxiID+"        "+trip);
        }
        System.out.println("_______________________________________________________________________________________________________");
    }
    public void printTaxiDetails(){
        System.out.println("Taxi - "+this.TaxiID+"  Total Earnings- "+this.TotalEarnings+"  Current Spot- "+this.CurrentSpot+"  Free Time-"+this.freeTime);
        System.out.println();
    }



}