package guru.springfamework.controllers.v1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.api.v1.model.CustomerListDTO;
import guru.springfamework.api.v1.services.CustomerService;

@Controller
@RequestMapping("/api/v1/customers/")
public class CustomerController {

    private final CustomerService CustomerService;

    public CustomerController(CustomerService CustomerService) {
        this.CustomerService = CustomerService;
    }

    @GetMapping
    public ResponseEntity<CustomerListDTO> getallCatetories(){

        return new ResponseEntity<CustomerListDTO>(
                new CustomerListDTO(CustomerService.getAllCustomers()), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerDTO> getCustomerByName( @PathVariable String id){
        return new ResponseEntity<CustomerDTO>(
                CustomerService.getCustomerById(Long.valueOf(id)), HttpStatus.OK
        );
    }
}
