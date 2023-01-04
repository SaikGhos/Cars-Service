package CarsService.Cars.Service;

import CarsService.Cars.Entity.Cars;
import CarsService.Cars.Entity.CarsResponse;
import CarsService.Cars.Entity.Inventory;
import CarsService.Cars.Exception.CarNotFoundException;
import CarsService.Cars.Repo.CarsRepository;
import CarsService.Cars.Repo.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsServiceImpl implements CarsService{

    @Autowired
    public CarsRepository carsRepository;
    @Autowired
    public InventoryRepository inventoryRepository;
    @Override
    public CarsResponse saveCar(Cars car) {
        boolean exists1 = carsRepository.existsByEngineNo(car.getEngineNo());
        if (exists1) {
            Cars existingCar =  carsRepository.findByEngineNo(car.getEngineNo());
            return new CarsResponse(existingCar.getEngineNo(), existingCar.getMaker(), existingCar.getModel(),
                    existingCar.getMfgYear(), "Car is already listed.");
            /*return new CarsResponse(car.getEngineNo(), car.getMaker(), car.getModel(),
                    car.getMfgYear(), "Car is already listed.");*/
        } else {
            boolean exists2 = inventoryRepository.existsByModel(car.getModel());
            if (exists2) {
                int count = 1 + inventoryRepository.findByModel(car.getModel()).getCount();
                inventoryRepository.save(new Inventory(car.getModel(), car.getMaker(),count, car.getMfgYear()));
            } else {
                inventoryRepository.save(new Inventory(car.getModel(), car.getMaker(), 1, car.getMfgYear()));
            }
            carsRepository.save(car);
            return new CarsResponse(car.getEngineNo(), car.getMaker(), car.getModel(),
                    car.getMfgYear(),  "Car Added");
        }
    }


    @Override
    public List<Cars> getCarsInfo() {
        return carsRepository.findAll();
    }

    @Override
    public Cars getCarById(int engineNo) throws CarNotFoundException {
        boolean exists = carsRepository.existsByEngineNo(engineNo);
        if (!exists) {
            throw new CarNotFoundException("Car is not listed with engine number " + engineNo);
        }
        return carsRepository.findByEngineNo(engineNo);
    }

    @Override
    public List<Cars> getCarByMaker(String maker) {
        return carsRepository.findByMaker(maker);
    }

    @Override
    public List<Cars> getCarByModel(String model) {
        return carsRepository.findByModel(model);
    }
}
