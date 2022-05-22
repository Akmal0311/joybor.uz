package bootcampExam.joybor.uz.rest;

import bootcampExam.joybor.uz.dao.Amenity;
import bootcampExam.joybor.uz.dao.Customer;
import bootcampExam.joybor.uz.dto.ResponseDTO;
import bootcampExam.joybor.uz.service.AmenityService;
import bootcampExam.joybor.uz.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/get/{id}")
    public ResponseDTO<Customer> getById(@PathVariable Integer id){ return customerService.getCustomerById(id);}

    @GetMapping("/get-all")
    public ResponseDTO<List<Customer>> getAll(){ return customerService.getCustomers();}

    @PostMapping("/add")
    public ResponseDTO<Customer> add(@RequestBody Customer customer){ return customerService.add(customer);}

    @PutMapping("/update")
    public ResponseDTO<Customer> update(@RequestBody Customer customer){ return customerService.update(customer);}

    @DeleteMapping("/delete/{id}")
    public ResponseDTO<Customer> delete(@PathVariable Integer id){ return customerService.delete(id);}
}
