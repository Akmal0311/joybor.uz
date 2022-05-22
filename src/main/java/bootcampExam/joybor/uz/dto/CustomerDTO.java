package bootcampExam.joybor.uz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private Integer id;

    private String name;

    private String gender;

    private BigInteger card_number;

    private String tel_number;

    public CustomerDTO(Integer id, String name, BigInteger card_number, String tel_number) {
        this.id = id;
        this.name = name;
        this.card_number = card_number;
        this.tel_number = tel_number;
    }
}
