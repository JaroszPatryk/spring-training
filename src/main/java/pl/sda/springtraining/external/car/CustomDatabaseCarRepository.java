package pl.sda.springtraining.external.car;

import pl.sda.springtraining.api.model.SearchParams;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public interface CustomDatabaseCarRepository {

    List<CarEntity> findBasedOnSearchParams(SearchParams searchParams);
}
