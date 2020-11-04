package pl.sda.springtraining.domain.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;

    public void create(Customer customer) {
        customerRepository.create(customer);
    }

    public void update(Customer customer) {
        customerRepository.update(customer);
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findOne(id);
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public void delete(Long id) {
        customerRepository.delete(id);
    }
}

