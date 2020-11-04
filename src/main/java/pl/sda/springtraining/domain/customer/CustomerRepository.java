package pl.sda.springtraining.domain.customer;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {

    Optional<Customer> findOne(Long id);
    List<Customer> findAll();
    void create(Customer customer);
    void update(Customer customer);
    void delete(Long id);
}
