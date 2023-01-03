package CarsService.Cars.Service;

import CarsService.Cars.Entity.Cars;
import CarsService.Cars.Entity.CarsResponse;
import CarsService.Cars.Exception.CarNotFoundException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CarsService {

    public Mono<CarsResponse> saveCar(Cars car);
    public Flux<Cars> getCarsInfo();
    public Mono<Cars> getCarById(int engineNo) throws CarNotFoundException;
    public Flux<Cars> getCarByMaker(String maker) ;
    public Flux<Cars> getCarByModel(String model) ;


}
