import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import battery.Battery;

public class BatteryTest {
    Battery battery;

    @BeforeEach
    public void setupBattery(){
        battery = new Battery(); 
    }
    
    @Test 
    public void batteryPercentageIsValid() {       
        assertTrue(battery.getBatteryPercentage() > 0.0);
    }
    
}
