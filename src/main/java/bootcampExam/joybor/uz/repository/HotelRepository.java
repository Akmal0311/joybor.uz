package bootcampExam.joybor.uz.repository;

import bootcampExam.joybor.uz.dao.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
}
