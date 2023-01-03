package CarsService.Cars.Repo;

import CarsService.Cars.Entity.Cars;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CarsRepository extends ReactiveCassandraRepository<Cars, Integer> {

    @AllowFiltering
    public Mono<Cars> findByEngineNo(int engineNo);
    @AllowFiltering
    public Flux<Cars> findByMaker(String maker);
    @AllowFiltering
    public Flux<Cars> findByModel(String model);
    @AllowFiltering
    Mono<Boolean> existsByEngineNo(Integer id);

}
