package CarsService.Cars.Controller;

import CarsService.Cars.Entity.Cars;
import CarsService.Cars.Entity.CarsResponse;
import CarsService.Cars.Exception.CarNotFoundException;
import CarsService.Cars.Repo.CarsRepository;
import CarsService.Cars.Service.CarsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class CarListingController {


    @Autowired
    public CarsService carsService;

    @PostMapping(value = "/addCar")
    public CarsResponse addCar(@RequestBody Cars car) {
        return carsService.saveCar(car);
    }

    @GetMapping("/getCarsInfo")
    public List<Cars> getCarsInfo(){
        return carsService.getCarsInfo();
    }

    @GetMapping("/getCarByEngineNo/{engineNo}")
    public Cars getCarById(@PathVariable int engineNo) throws CarNotFoundException {
        return carsService.getCarById(engineNo);
    }

    @GetMapping("/getCarByMaker/{maker}")
    public List<Cars> getCarByMaker(@PathVariable String maker) {
        return carsService.getCarByMaker(maker);
    }

    @GetMapping("/getCarByModel/{model}")
    public List<Cars> getCarByModel(@PathVariable String model) {
        return carsService.getCarByModel(model);
    }

}