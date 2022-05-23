package bootcampExam.joybor.uz.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

@Entity
@Table(name = "reservation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(name = "reservation_id_seq", sequenceName = "reservation_id_seq",allocationSize = 1)
    private Integer id;

    @Column(name = "access_date")
    private Date access_date;

    @Column(name = "checkout_date")
    private Date checkout_date;

    @Column(name = "checkin")
    private boolean checkin;

    @Column(name = "cus_id")
    private Integer cus_id;

    @Column(name = "room_id")
    private Integer room_id;


    public Reservation(Integer id, Date access_date, Date checkout_date, boolean checkin) {
        this.id = id;
        this.access_date = access_date;
        this.checkout_date = checkout_date;
        this.checkin = checkin;
    }
}
