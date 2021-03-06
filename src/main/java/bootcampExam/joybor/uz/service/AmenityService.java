package bootcampExam.joybor.uz.service;

import bootcampExam.joybor.uz.dao.Amenity;
import bootcampExam.joybor.uz.dto.ResponseDTO;
import bootcampExam.joybor.uz.helper.HttpCode;
import bootcampExam.joybor.uz.helper.HttpMessage;
import bootcampExam.joybor.uz.repository.AmenityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AmenityService {

    private final AmenityRepository amenityRepository;

    public ResponseDTO<Amenity> getAmenityById(Integer id) {

        Optional<Amenity> amenity = amenityRepository.findById(id);

        if (amenity.isPresent()) {
            return new ResponseDTO<>(true, HttpCode.OK, HttpMessage.OK, amenity.get());
        }
        return new ResponseDTO<>(false, HttpCode.NOT_FOUND, HttpMessage.NOT_FOUND, null);
    }

    public ResponseDTO<List<Amenity>> getAmenities() {

        List<Amenity> amenities =  amenityRepository.findAll();

        if(!amenities.isEmpty()) {
            return new ResponseDTO<>(true, HttpCode.OK, HttpMessage.OK, amenities );
        }
        return new ResponseDTO<>(false, HttpCode.NOT_FOUND, HttpMessage.NOT_FOUND, null);
    }

    public ResponseDTO<Amenity> add(Amenity amenity) {

        try {
            if (amenity.getStars() != null) {
                return new ResponseDTO<>(true, HttpCode.OK, HttpMessage.OK, amenity);
            }
            return new ResponseDTO<>(false, HttpCode.VALIDATION_ERROR, HttpMessage.VALIDATION_ERROR, amenity);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseDTO<>(false, HttpCode.DATABASE_ERROR, HttpMessage.DATABASE_ERROR, null);
        }
    }

    public ResponseDTO<Amenity> update(Amenity amenity) {

        Amenity amenity1 = amenityRepository.save(amenity);

        if (amenity1 != null) {
            return new ResponseDTO<>(true, HttpCode.OK, HttpMessage.OK, amenity1);
        }
        return new ResponseDTO<>(false, HttpCode.DATABASE_ERROR, HttpMessage.DATABASE_ERROR, null);
    }

    public ResponseDTO<Amenity> delete(Integer id) {
        amenityRepository.deleteById(id);

        if(amenityRepository.findById(id).isPresent()) {
            return new ResponseDTO<>(true, HttpCode.OK, HttpMessage.OK, null );
        }
        return new ResponseDTO<>(false, HttpCode.NOT_FOUND, HttpMessage.NOT_FOUND , null);
    }
}
