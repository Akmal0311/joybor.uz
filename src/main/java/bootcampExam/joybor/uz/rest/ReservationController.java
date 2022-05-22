package bootcampExam.joybor.uz.rest;

import bootcampExam.joybor.uz.dao.Hotel;
import bootcampExam.joybor.uz.dao.Reservation;
import bootcampExam.joybor.uz.dto.ResponseDTO;
import bootcampExam.joybor.uz.service.HotelService;
import bootcampExam.joybor.uz.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("reservation")
public class ReservationController {

    private final ReservationService reservationService;

    @GetMapping("/get/{id}")
    public ResponseDTO<Reservation> getById(@PathVariable Integer id){return reservationService.getReservationById(id);}

    @GetMapping("/get-all")
    public ResponseDTO<List<Reservation>> getAll(){ return reservationService.getReservations();}

    @PostMapping("/add")
    public ResponseDTO<Reservation> add(@RequestBody Reservation reservation){ return reservationService.add(reservation);}

    @PutMapping("/update")
    public ResponseDTO<Reservation> update(@RequestBody Reservation reservation){ return reservationService.update(reservation);}

    @DeleteMapping("/delete/{id}")
    public ResponseDTO<Reservation> delete(@PathVariable Integer id){ return reservationService.delete(id);}
}
