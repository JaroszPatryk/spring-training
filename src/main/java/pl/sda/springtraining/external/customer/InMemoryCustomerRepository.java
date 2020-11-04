package pl.sda.springtraining.external.customer;

import org.springframework.stereotype.Component;
import pl.sda.springtraining.domain.customer.Customer;
import pl.sda.springtraining.domain.customer.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class InMemoryCustomerRepository implements CustomerRepository {

    private List<Customer> customers = new ArrayList<>();
    private Long id = 0L;

    @Override
    public Optional<Customer> findOne(Long id) {
        return customers.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public void create(Customer customer) {
        customer.setId(++id);
    }

    @Override
    public void update(Customer customer) {
        delete(customer.getId());
        customers.add(customer);
    }

    @Override
    public void delete(Long id) {
        customers.removeIf(existingCar -> existingCar.getId().equals(id));
    }
}
