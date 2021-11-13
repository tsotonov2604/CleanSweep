import battery.Battery;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
