package CarsService.Cars.Service;

import CarsService.Cars.Entity.Cars;
import CarsService.Cars.Entity.CarsResponse;
import CarsService.Cars.Entity.Inventory;
import CarsService.Cars.Exception.CarNotFoundException;
import CarsService.Cars.Repo.CarsRepository;
import CarsService.Cars.Repo.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CarsServiceImpl implements CarsService{

    @Autowired
    public CarsRepository carsRepository;
    @Autowired
    public InventoryRepository inventoryRepository;
    @Override
    public Mono<CarsResponse> saveCar(Cars car) {
        return carsRepository.existsByEngineNo(car.getEngineNo())
                .flatMap(exists1 -> {
                    if (exists1) {
                        return Mono.just(car).map(t -> new CarsResponse(t.getEngineNo(), t.getMaker(), t.getModel(),
                                        t.getMfgYear(), "Car is already listed."));
                    } else {
                        return inventoryRepository.existsByModel(car.getModel())
                                .flatMap(exists2 -> {
                                    if (exists2) {
                                        Mono<Inventory> inventoryMono = inventoryRepository.findByModel(car.getModel());
                                        //int c = inventoryMono.filter(i->i.getCount());
                                        //int c = inventoryMono.map(i->i.getCount()).toString();
                                        //int count = 1 + 1;
                                        //Flux<Cars> carsFlux = carsRepository.findAll().filter(t->t.getModel().equals(car.getModel()));

                                        //int count = 1 + inventoryMono.flatMapIterable(f -> f.getCount());
                                        Inventory inventory = new Inventory(car.getModel(), car.getMaker(),
                                                2, car.getMfgYear());
                                        return Mono.zip(Mono.just(car).flatMap(carsRepository::save)
                                                        , Mono.just(inventory).flatMap(inventoryRepository::save))
                                                .map(t -> new CarsResponse(t.getT1().getEngineNo(), t.getT1().getMaker(),
                                                        t.getT1().getModel(), t.getT1().getMfgYear(), "Car Added"));
                                    } else {
                                        Inventory inventory = new Inventory(car.getModel(), car.getMaker(), 1, car.getMfgYear());
                                        return Mono.zip(Mono.just(car).flatMap(carsRepository::save)
                                                        , Mono.just(inventory).flatMap(inventoryRepository::save))
                                                .map(t -> new CarsResponse(t.getT1().getEngineNo(), t.getT1().getMaker(),
                                                        t.getT1().getModel(), t.getT1().getMfgYear(), "Car Added"));
                                    }
                                });
                    }
                });
    }

    @Override
    public Flux<Cars> getCarsInfo() {
        return carsRepository.findAll();
    }

    @Override
    public Mono<Cars> getCarById(int engineNo) throws CarNotFoundException {
        return carsRepository.existsByEngineNo(engineNo)
                .flatMap(exists1 -> {
                    if (exists1) {
                        return carsRepository.findByEngineNo(engineNo);
                    } else {
                        try {
                            throw new CarNotFoundException("Car is not listed with engine number " + engineNo);
                        } catch (CarNotFoundException e) {
                            throw new RuntimeException(e);
                        }
                    }
                });
    }

    @Override
    public Flux<Cars> getCarByMaker(String maker) {
        return carsRepository.findByMaker(maker);
    }

    @Override
    public Flux<Cars> getCarByModel(String model) {
        return carsRepository.findByModel(model);
    }
}
