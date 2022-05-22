package bootcampExam.joybor.uz.repository;

import bootcampExam.joybor.uz.dao.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    List<Customer> getCustomers();
}
