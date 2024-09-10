package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;


/**
 * Hello world!
 *
 */
public class App 
{

    public static void main( String[] args )
    {
        TruckService truckService = new TruckService();

        Truck tata = new Truck ("TATA","2019",1000,"rajesh");
        Truck volvo = new Truck ("VOLVO","2023",1000,"Akash");
        Truck Mahindra  = new Truck ("Mahindra","2022",1000,"jai");

        //adding data into database
        truckService.addTruck(tata);
        truckService.addTruck(volvo);
        truckService.addTruck(Mahindra);

        //fetch
         Truck truck = truckService.getTruckById(1);
        System.out.println("Truck data :" + truck);

        //update truck data
        truck.setDriver_name("ramesh");
        truckService.updateTruck(truck);
        System.out.println("updated truck dta  : " + truckService.getTruckById(1));

        //get all truck data
        List<Truck>allTrucks = truckService.getAllTrucks();
        System.out.println("all trucks in DB :");
        for (Truck truck1:allTrucks)
        {
            System.out.println(truck1);
        }

        //delete Truck data
        truckService.deleteTruck(2);
        System.out.println("data deleted by Id : " + 2);
        allTrucks = truckService.getAllTrucks();
        System.out.println("all trucks after all operations : ");
        System.out.println(allTrucks);
    }
}
