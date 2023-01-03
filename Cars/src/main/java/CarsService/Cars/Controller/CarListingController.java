package CarsService.Cars.Controller;

import CarsService.Cars.Entity.Cars;
import CarsService.Cars.Entity.CarsResponse;
import CarsService.Cars.Repo.CarsRepository;
import CarsService.Cars.Service.CarsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/carListing")
public class CarListingController {


    @Autowired
    public CarsService carsService;

    @PostMapping(value = "/addCar")
    public Mono<CarsResponse> addCar(@RequestBody Cars car) {
        return carsService.saveCar(car);
    }
    @PostMapping(value = "/addCars")
    public Flux<Cars> addCars(Cars cars) {
        return carsService.saveCars(cars);
    }
    @GetMapping("/getCarsInfo")
    public Flux<Cars> getCarsInfo(){
        return carsService.getCarsInfo();
    }

    @GetMapping("/getCarById")
    public Mono<Cars> getCarById(){
        return carsService.getCarById();
    }

    @GetMapping("/getCarByMaker")
    public Mono<Cars> getCarByMaker(){
        return carsService.getCarByMaker();
    }

    @GetMapping("/getCarByModel")
    public Mono<Cars> getCarByModel(){
        return carsService.getCarByModel();
    }

}