package bootcampExam.joybor.uz.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AmenityDTO {

    private Integer id;

    private Integer stars;

    private boolean breakfast;

    private boolean restaurant;

    private boolean wifi;

    private boolean pool;

    private boolean gym;

    private boolean spa;

    public AmenityDTO(Integer id, Integer stars) {
        this.id = id;
        this.stars = stars;
    }
}
