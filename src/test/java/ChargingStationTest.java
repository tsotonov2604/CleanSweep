import java.awt.Point;
import battery.Battery;
import org.junit.jupiter.api.Test;
import ChargingStation.ChargingStation;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChargingStationTest {
    ChargingStation chargingStation;
    Battery battery;

    @BeforeEach
    public void setupChargingStation(){
        chargingStation = new ChargingStation();
        battery = new Battery();
    }

    @Test 
    public void isChargingStationLocationValid(){
        Point startingLocation = new Point(0,0);
        assertEquals(chargingStation.getCurrentLocation(), startingLocation);
    }
    
    @Test 
    public void isCharging(){
        chargingStation.charge();
        double batteryFull = 100; 
        assertEquals(batteryFull, battery.getCurrentBatteryPercent());
    }
  
}
