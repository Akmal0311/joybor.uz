package bootcampExam.joybor.uz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDTO {

    private Integer id;

    private String name;

    private String address;

    private String email;

    public HotelDTO(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }


}
