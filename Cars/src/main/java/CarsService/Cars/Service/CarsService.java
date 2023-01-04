package CarsService.Cars.Service;

import CarsService.Cars.Entity.Cars;
import CarsService.Cars.Entity.CarsResponse;
import CarsService.Cars.Exception.CarNotFoundException;

import java.util.List;

public interface CarsService {

    public CarsResponse saveCar(Cars car);
    public List<Cars> getCarsInfo();
    public Cars getCarById(int engineNo) throws CarNotFoundException;
    public List<Cars> getCarByMaker(String maker) ;
    public List<Cars> getCarByModel(String model) ;


}
