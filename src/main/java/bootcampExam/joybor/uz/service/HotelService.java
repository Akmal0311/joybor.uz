package bootcampExam.joybor.uz.service;

import bootcampExam.joybor.uz.dto.ResponseDTO;
import bootcampExam.joybor.uz.dao.Hotel;
import bootcampExam.joybor.uz.dto.ValidatorDTO;
import bootcampExam.joybor.uz.helper.HttpCode;
import bootcampExam.joybor.uz.helper.HttpMessage;
import bootcampExam.joybor.uz.helper.Validation;
import bootcampExam.joybor.uz.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;

    public ResponseDTO<Hotel> getHotelById(Integer id) {

        Hotel hotel = hotelRepository.getById(id);

        if (hotel != null) {
            return new ResponseDTO<>(true, HttpCode.OK, HttpMessage.OK, hotel );
        }
        return new ResponseDTO<>(false, HttpCode.NOT_FOUND, HttpMessage.NOT_FOUND, null);
    }

    public ResponseDTO<List<Hotel>> getHotels(){

        List<Hotel> hotels = hotelRepository.getHotels();

        if(!hotels.isEmpty()) {
            return new ResponseDTO<>(true, HttpCode.OK, HttpMessage.OK, hotels);
        }
        return new ResponseDTO<>(false, HttpCode.NOT_FOUND, HttpMessage.NOT_FOUND, hotels);
    }

    public ResponseDTO<Hotel> add(Hotel hotel) {
        try {
            List<ValidatorDTO> errors = Validation.validateHotel(hotel);
            if(errors.size()!=0) {
                return new ResponseDTO<>(false, HttpCode.VALIDATION_ERROR, HttpMessage.VALIDATION_ERROR, hotel, errors);
            }
            return new ResponseDTO<>(true, HttpCode.OK, HttpMessage.OK, hotelRepository.save(hotel));
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseDTO<>(false,HttpCode.DATABASE_ERROR, HttpMessage.DATABASE_ERROR, null);
        }
    }

    public ResponseDTO<Hotel> update(Hotel hotel) {

        Hotel hotel1 = hotelRepository.save(hotel);

        if (hotel1 != null) {
            return new ResponseDTO<>(true, HttpCode.OK, HttpMessage.OK, hotel1);
        }
        return new ResponseDTO<>(false, HttpCode.DATABASE_ERROR, HttpMessage.DATABASE_ERROR,null);
    }

    public ResponseDTO<Hotel> delete(Integer id) {

        hotelRepository.deleteById(id);

        if (hotelRepository.getById(id) == null) {
            return new ResponseDTO<>(true, HttpCode.OK, HttpMessage.OK,  null);
        }
        return new ResponseDTO<>(false, HttpCode.NOT_FOUND, HttpMessage.NOT_FOUND, null);
    }
}
