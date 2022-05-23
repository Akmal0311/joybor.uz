package bootcampExam.joybor.uz.repository;

import bootcampExam.joybor.uz.dao.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AmenityRepository extends JpaRepository<Amenity,Integer> {
}
