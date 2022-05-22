package bootcampExam.joybor.uz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {

    private Integer id;

    private Date access_date;

    private Date checkout_date;

    private boolean checkin;

    public ReservationDTO(Integer id, Date access_date, Date checkout_date) {
        this.id = id;
        this.access_date = access_date;
        this.checkout_date = checkout_date;
    }
}
