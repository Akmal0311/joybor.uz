package bootcampExam.joybor.uz.rest;

import bootcampExam.joybor.uz.dto.ResponseDTO;
import bootcampExam.joybor.uz.dao.Hotel;
import bootcampExam.joybor.uz.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("hotel")
public class HotelController {

    private final HotelService hotelService;

    @GetMapping("/get/{id}")
    public ResponseDTO<Hotel> getById(@PathVariable Integer id){
        return hotelService.getHotelById(id);
    }

    @GetMapping("/get-all")
    public ResponseDTO<List<Hotel>> getAll(){ return hotelService.getHotels();}

    @PostMapping("/add")
    public ResponseDTO<Hotel> add(@RequestBody Hotel hotel){ return hotelService.add(hotel);}

    @PutMapping("/update")
    public ResponseDTO<Hotel> update(@RequestBody Hotel hotel){ return hotelService.update(hotel);}

    @DeleteMapping("/delete/{id}")
    public ResponseDTO<Hotel> delete(@PathVariable Integer id){ return hotelService.delete(id);}
}
