package bootcampExam.joybor.uz.service;

import bootcampExam.joybor.uz.dao.Reservation;
import bootcampExam.joybor.uz.dto.ResponseDTO;
import bootcampExam.joybor.uz.dto.ValidatorDTO;
import bootcampExam.joybor.uz.helper.HttpCode;
import bootcampExam.joybor.uz.helper.HttpMessage;
import bootcampExam.joybor.uz.helper.Validation;
import bootcampExam.joybor.uz.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ResponseDTO<Reservation> getReservationById(Integer id) {

         Optional<Reservation> reservation = reservationRepository.findById(id);

         if (reservation.isPresent()){
             return new ResponseDTO<>(true, HttpCode.OK, HttpMessage.OK, reservation.get());
         }
         return new ResponseDTO<>(false, HttpCode.NOT_FOUND, HttpMessage.NOT_FOUND, null);
    }

    public ResponseDTO<List<Reservation>> getReservations() {

        List<Reservation> reservations = reservationRepository.findAll();

        if (!reservations.isEmpty()) {
            return new ResponseDTO<>(true, HttpCode.OK, HttpMessage.OK, reservations);
        }
        return new ResponseDTO<>(false, HttpCode.NOT_FOUND, HttpMessage.NOT_FOUND, null);
    }

    public ResponseDTO<Reservation> add(Reservation reservation) {

        try {

            List<ValidatorDTO> errors = Validation.validateReservation(reservation);

            if (errors.size() > 0) return new ResponseDTO<>(false,HttpCode.VALIDATION_ERROR,HttpMessage.VALIDATION_ERROR,reservation,errors);

            return new ResponseDTO<>(true,HttpCode.OK,HttpMessage.OK, reservation);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseDTO<>(false, HttpCode.DATABASE_ERROR, HttpMessage.DATABASE_ERROR, null);
        }
    }

    public ResponseDTO<Reservation> update(Reservation reservation) {

        Reservation reservation1 = reservationRepository.save(reservation);

        if (reservation1.isCheckin()) {
            return new ResponseDTO<>(true, HttpCode.OK, HttpMessage.OK, reservation1);
        }
        return new ResponseDTO<>(false, HttpCode.NOT_FOUND, HttpMessage.NOT_FOUND, null);
    }

    public ResponseDTO<Reservation> delete(Integer id) {
        reservationRepository.deleteById(id);

        if (reservationRepository.findById(id).isPresent()){
            return new ResponseDTO<>(true,HttpCode.OK,HttpMessage.OK,null);
        }
        return new ResponseDTO<>(false, HttpCode.NOT_FOUND, HttpMessage.NOT_FOUND, null);
    }

}
