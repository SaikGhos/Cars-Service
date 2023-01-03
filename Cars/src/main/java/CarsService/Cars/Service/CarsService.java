package CarsService.Cars.Service;

import CarsService.Cars.Entity.Cars;
import CarsService.Cars.Entity.CarsResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CarsService {

    public Mono<CarsResponse> saveCar(Cars car);
    public Flux<Cars> saveCars(Cars cars);
    public Flux<Cars> getCarsInfo();
    public Mono<Cars> getCarById();
    public Mono<Cars> getCarByMaker();
    public Mono<Cars> getCarByModel();


}
