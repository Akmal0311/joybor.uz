package bootcampExam.joybor.uz.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;


@Data
@NoArgsConstructor
public class RoomDTO {

    private Integer id;

    private String type;

    private BigInteger price;

    public RoomDTO(Integer id, String type, BigInteger price) {
        this.id = id;
        this.type = type;
        this.price = price;
    }
}
