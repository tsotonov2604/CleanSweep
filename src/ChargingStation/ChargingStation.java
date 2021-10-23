package ChargingStation;
import move.Grid;
import battery.Battery;
import java.awt.Point;
import move.Tile;

public class ChargingStation  {

    private Point currentLocation = new Point(0,0);
    private Battery battery = new Battery();
    private double MAX_BATTERY_CAPACITY = 100;
    private Point CHARGING_STATION_LOCATION;

   public void setChargingStationLocation(Grid grid){
        //set initial coordinates of charging station based on floor plan grid - HARDCODED @ POINT 0,0
       //CHARGING_STATION_LOCATION  = initial location; 
        grid.addSweep(0, 0);
        CHARGING_STATION_LOCATION = new Point(0,0); 
   }

   public Point getChargingStationLocation(){   
       System.out.println("Charging station is located at point: " + CHARGING_STATION_LOCATION.toString());
       return CHARGING_STATION_LOCATION;

   }

   public Point navigateToChargingStation(Grid grid, Tile sweep){
       //set the current location to the location of the charging station
        currentLocation = getChargingStationLocation();
        return currentLocation;       
   }

   public void setCurrentLocation(int x, int y){
        //get the current location of the clean sweep from grid and sets it as the current location 
        currentLocation.x = x;
        currentLocation.y = y; 
        //grid.removeSweep(currentLocation.x, currentLocation.y);   set current location of sweep to that of charger i.e 3,3 = 1 
   }
  
   public Point getCurrentLocation(){
       return currentLocation;
   }


   public void charge(){
       System.out.println("Charging...");
       battery.setCurrentBatteryPercent(MAX_BATTERY_CAPACITY);
       System.out.println("Battery is at 100%!");
   }
}
