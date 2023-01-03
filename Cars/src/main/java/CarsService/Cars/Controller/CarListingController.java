package CarsService.Cars.Controller;

import CarsService.Cars.Entity.Cars;
import CarsService.Cars.Entity.CarsResponse;
import CarsService.Cars.Exception.CarNotFoundException;
import CarsService.Cars.Repo.CarsRepository;
import CarsService.Cars.Service.CarsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@RestController
public class CarListingController {


    @Autowired
    public CarsService carsService;

    @PostMapping(value = "/addCar")
    public Mono<CarsResponse> addCar(@RequestBody Cars car) {
        return carsService.saveCar(car);
    }

    @GetMapping("/getCarsInfo")
    public Flux<Cars> getCarsInfo(){
        return carsService.getCarsInfo();
    }

    @GetMapping("/getCarByEngineNo/{engineNo}")
    public Mono<Cars> getCarById(@PathVariable int engineNo) throws CarNotFoundException {
        return carsService.getCarById(engineNo);
    }

    @GetMapping("/getCarByMaker/{maker}")
    public Flux<Cars> getCarByMaker(@PathVariable String maker) {
        return carsService.getCarByMaker(maker);
    }

    @GetMapping("/getCarByModel/{model}")
    public Flux<Cars> getCarByModel(@PathVariable String model) {
        return carsService.getCarByModel(model);
    }

}