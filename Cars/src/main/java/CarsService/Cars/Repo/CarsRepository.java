package CarsService.Cars.Repo;

import CarsService.Cars.Entity.Cars;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CarsRepository extends MongoRepository<Cars, Integer> {

    public Cars findByEngineNo(int engineNo);
    public List<Cars> findByMaker(String maker);
    public List<Cars> findByModel(String model);
    public Boolean existsByEngineNo(Integer id);

}
