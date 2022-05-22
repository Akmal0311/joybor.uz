package bootcampExam.joybor.uz.rest;

import bootcampExam.joybor.uz.dao.Hotel;
import bootcampExam.joybor.uz.dao.Room;
import bootcampExam.joybor.uz.dto.ResponseDTO;
import bootcampExam.joybor.uz.service.HotelService;
import bootcampExam.joybor.uz.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("room")
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/get/{id}")
    public ResponseDTO<Room> getById(@PathVariable Integer id){return roomService.getRoomById(id);}

    @GetMapping("/get-all")
    public ResponseDTO<List<Room>> getAll(){ return roomService.getRooms();}

    @PostMapping("/add")
    public ResponseDTO<Room> add(@RequestBody Room room){ return roomService.add(room);}

    @PutMapping("/update")
    public ResponseDTO<Room> update(@RequestBody Room room){ return roomService.update(room);}

    @DeleteMapping("/delete/{id}")
    public ResponseDTO<Room> delete(@PathVariable Integer id){ return roomService.delete(id);}
}
