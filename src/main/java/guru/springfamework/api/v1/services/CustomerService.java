package guru.springfamework.api.v1.services;

import java.util.List;

import guru.springfamework.api.v1.model.CustomerDTO;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerById(Long id);
}
