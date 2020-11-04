package pl.sda.springtraining.external.car;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.sda.springtraining.api.model.SearchParams;
import pl.sda.springtraining.domain.car.Car;
import pl.sda.springtraining.domain.car.CarRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class DatabaseCarRepository implements CarRepository {

    private JpaCarRepository jpaCarRepository;

    @Override
    public Optional<Car> findOne(Long id) {
        return jpaCarRepository.findById(id).map(this::toDomain);
    }

    @Override
    public boolean existsByVin(String vin) {
        return jpaCarRepository.findByVin(vin).isPresent();
    }

    @Override
    public List<Car> findAll() {
        return jpaCarRepository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public void create(Car car) {
        jpaCarRepository.save(toEntity(car));
    }

    @Override
    public void update(Car car) {
        if (!jpaCarRepository.existsById(car.getId())) {
            throw new IllegalStateException("Update object not exist");
        }
        jpaCarRepository.save(toEntity(car));
    }

    @Override
    public void delete(Long id) {
        jpaCarRepository.deleteById(id);
    }

    @Override
    public List<Car> findByParams(SearchParams searchParams) {
        return jpaCarRepository.findBasedOnSearchParams(searchParams)
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());


    }

    private Car toDomain(CarEntity entity) {
        return Car.builder()
                .id(entity.getId())
                .manufacturer(entity.getManufacturer())
                .model(entity.getModel())
                .vin(entity.getVin())
                .yearOfProduction(entity.getYearOfProduction())
                .insuredFrom(entity.getInsurance().getInsuredFrom())
                .insuredTo(entity.getInsurance().getInsuredTo())
                .build();
    }

    private CarEntity toEntity(Car car) {
        return CarEntity.builder()
                .id(car.getId())
                .manufacturer(car.getManufacturer())
                .model(car.getModel())
                .vin(car.getVin())
                .yearOfProduction(car.getYearOfProduction())
                .insurance(InsuranceEntity.builder()
                        .insuredFrom(car.getInsuredFrom())
                        .insuredTo(car.getInsuredTo()).build())
                .build();
    }
}
