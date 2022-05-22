package bootcampExam.joybor.uz.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(generator = "reservation_id_seq")
    @SequenceGenerator(name = "reservation_id_seq", sequenceName = "reservation_id_seq",allocationSize = 1)
    private Integer id;

    @Column(name = "access_date")
    private Date access_date;

    @Column(name = "checkout_date")
    private Date checkout_date;

    @Column(name = "checkin")
    private boolean checkin;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cus_id", referencedColumnName = "id")
    private Customer customer;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;

    public Reservation(Integer id, Date access_date, Date checkout_date, boolean checkin) {
        this.id = id;
        this.access_date = access_date;
        this.checkout_date = checkout_date;
        this.checkin = checkin;
    }
}
