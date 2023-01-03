package CarsService.Cars.Exception;

public class CarNotFoundException extends Exception {
    public CarNotFoundException() {
        super();
    }

    public CarNotFoundException(String message) {
        super(message);
    }
}
