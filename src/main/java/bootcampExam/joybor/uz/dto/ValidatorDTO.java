package bootcampExam.joybor.uz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidatorDTO {

    private String fieldName;
    private String error;
}