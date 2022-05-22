package bootcampExam.joybor.uz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {

    private Integer id;

    private String title;

    private String comment;

    private String rating;

    public ReviewDTO(Integer id, String title, String comment) {
        this.id = id;
        this.title = title;
        this.comment = comment;
    }
}
