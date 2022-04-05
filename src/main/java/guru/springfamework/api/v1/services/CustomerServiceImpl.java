package guru.springfamework.api.v1.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import guru.springfamework.api.v1.mapper.CustomerMapper;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerMapper CustomerMapper;
    private final CustomerRepository CustomerRepository;

    public CustomerServiceImpl(CustomerMapper CustomerMapper, CustomerRepository CustomerRepository) {
        this.CustomerMapper = CustomerMapper;
        this.CustomerRepository = CustomerRepository;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {

        return CustomerRepository.findAll()
                .stream()
                .map(CustomerMapper::CustomerToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        Optional<Customer> customerOptional = CustomerRepository.findById(id);

        if (!customerOptional.isPresent()) {
            throw new RuntimeException("Customer Not Found!");
        }

        return CustomerMapper.CustomerToCustomerDTO(customerOptional.get());
    }
}
