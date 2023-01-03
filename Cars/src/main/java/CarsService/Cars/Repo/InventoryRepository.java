package CarsService.Cars.Repo;

import CarsService.Cars.Entity.Inventory;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface InventoryRepository extends ReactiveCassandraRepository<Inventory, String> {

    Mono<Boolean> existsByModel(String model);

    @AllowFiltering
    Mono<Inventory> findByModel(String model);

}
