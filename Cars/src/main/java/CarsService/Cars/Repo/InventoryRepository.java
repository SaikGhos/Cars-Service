package CarsService.Cars.Repo;

import CarsService.Cars.Entity.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory, String> {

    public Boolean existsByModel(String model);
    public Inventory findByModel(String model);

}
