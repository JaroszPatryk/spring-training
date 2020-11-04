package pl.sda.springtraining.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import pl.sda.springtraining.domain.customer.Customer;
import pl.sda.springtraining.domain.customer.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@AllArgsConstructor
@Component
public class CustomerApi {

    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getOne(@PathVariable Long customerId) {
        return customerService.getCustomerById(customerId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody Customer customer) {
        customerService.create(customer);
    }

    @PutMapping
    public void updateCustomer(@RequestBody Customer customer){
        customerService.update(customer);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@RequestParam Long customerId){
        customerService.delete(customerId);
    }
}
