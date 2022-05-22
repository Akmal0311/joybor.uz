package bootcampExam.joybor.uz.service;

import bootcampExam.joybor.uz.dao.Hotel;
import bootcampExam.joybor.uz.dao.Room;
import bootcampExam.joybor.uz.dto.ResponseDTO;
import bootcampExam.joybor.uz.dto.ValidatorDTO;
import bootcampExam.joybor.uz.helper.HttpCode;
import bootcampExam.joybor.uz.helper.HttpMessage;
import bootcampExam.joybor.uz.helper.Validation;
import bootcampExam.joybor.uz.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final RoomRepository roomRepository;

    public ResponseDTO<Room> getRoomById(Integer id) {

        Room room = roomRepository.getById(id);

        if (room != null) {
            return new ResponseDTO<>(true, HttpCode.OK, HttpMessage.OK, room);
        }
        return new ResponseDTO<>(false, HttpCode.NOT_FOUND, HttpMessage.NOT_FOUND, null);
    }

    public ResponseDTO<List<Room>> getRooms(){

        List<Room> rooms =  roomRepository.getRooms();

        if (rooms != null){
            return new ResponseDTO<>(true,HttpCode.OK, HttpMessage.OK, rooms);
        }
        return new ResponseDTO<>(false, HttpCode.NOT_FOUND, HttpMessage.NOT_FOUND, null);
    }

    public ResponseDTO<Room> add(Room room) {

        try {
            List<ValidatorDTO> errors = Validation.validateRoom(room);

            if (errors.size() > 0) return new ResponseDTO<>(false, HttpCode.NOT_FOUND, HttpMessage.NOT_FOUND, null);

            return new ResponseDTO<>(true, HttpCode.OK, HttpMessage.OK, room);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseDTO<>(false, HttpCode.DATABASE_ERROR, HttpMessage.DATABASE_ERROR, null);
        }
    }

    public ResponseDTO<Room> update(Room room) {

        Room room1 = roomRepository.save(room);

        if (room1 != null){
            return new ResponseDTO<>(true,HttpCode.OK,HttpMessage.OK, room1);
        }
        return new ResponseDTO<>(false, HttpCode.NOT_FOUND, HttpMessage.NOT_FOUND, null);
    }

    public ResponseDTO<Room> delete(Integer id) {
        roomRepository.deleteById(id);

        if (roomRepository.getById(id) == null) {
            return new ResponseDTO<>(true, HttpCode.OK, HttpMessage.OK, null );
        }
        return new ResponseDTO<>(false, HttpCode.NOT_FOUND, HttpMessage.NOT_FOUND, null);
    }
}
