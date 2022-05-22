package bootcampExam.joybor.uz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO<A> {
    private boolean success;
    private Integer code;
    private String message;
    private A data;
    private List<ValidatorDTO> errors;

    public ResponseDTO(boolean success, Integer code, String message, A data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }
}

