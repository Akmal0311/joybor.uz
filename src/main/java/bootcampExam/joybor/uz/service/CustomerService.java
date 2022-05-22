package bootcampExam.joybor.uz.service;

import bootcampExam.joybor.uz.dao.Customer;
import bootcampExam.joybor.uz.dto.ResponseDTO;
import bootcampExam.joybor.uz.dto.ValidatorDTO;
import bootcampExam.joybor.uz.helper.HttpCode;
import bootcampExam.joybor.uz.helper.HttpMessage;
import bootcampExam.joybor.uz.helper.Validation;
import bootcampExam.joybor.uz.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public ResponseDTO<Customer> getCustomerById(Integer id) {

        Customer customer = customerRepository.getById(id);

        if (customer!=null) {
            return new ResponseDTO<>(true, HttpCode.OK, HttpMessage.OK, customer);
        }
        return new ResponseDTO<>(false, HttpCode.NOT_FOUND, HttpMessage.NOT_FOUND, null);
    }

    public ResponseDTO<List<Customer>> getCustomers() {

        List<Customer> customers = customerRepository.getCustomers();

        if (customers != null) {
            return new ResponseDTO<>(true, HttpCode.OK, HttpMessage.OK, customers);
        }
        return new ResponseDTO<>(false, HttpCode.NOT_FOUND, HttpMessage.NOT_FOUND, null);
    }

    public ResponseDTO<Customer> add(Customer customer) {

        try {

            List<ValidatorDTO> errors = Validation.validateCustomer(customer);

            if (errors.size() > 0) return new ResponseDTO<>(false,HttpCode.VALIDATION_ERROR, HttpMessage.VALIDATION_ERROR,customer,errors);

            return new ResponseDTO<>(true, HttpCode.OK, HttpMessage.OK, customer);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseDTO<>(false, HttpCode.DATABASE_ERROR, HttpMessage.DATABASE_ERROR, null);
        }
    }

    public ResponseDTO<Customer> update(Customer customer) {

        Customer customer1 = customerRepository.save(customer);

        if (customer1 != null) {
            return new ResponseDTO<>(true, HttpCode.OK, HttpMessage.OK,  customer1);
        }
        return new ResponseDTO<>(false, HttpCode.NOT_FOUND , HttpMessage.NOT_FOUND, null);
    }
    public ResponseDTO<Customer> delete(Integer id) {
        customerRepository.deleteById(id);

        if(customerRepository.getById(id) == null) {
            return new ResponseDTO<>(true,0,"OK", null);
        }
        return new ResponseDTO<>(false, HttpCode.NOT_FOUND , HttpMessage.NOT_FOUND, null);
    }
}
