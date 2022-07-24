import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    Car car;

    @BeforeEach
    void setup(){
        car = new Car("Volvo", "C220", 10.0, 6.0);
    }

    @Test
    void travelSuccessful() throws InsufficientFuelException {
        assertEquals(4.0,car.driveTrip(100));
    }
    @Test
    void travelUnSuccessful() throws InsufficientFuelException {
        assertEquals(null, car.driveTrip(200));
       // assertThrows(InsufficientFuelException.class , () ->
        //       car.driveTrip(200) , "Missing2.0 fuel");
    }

}