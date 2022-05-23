package bootcampExam.joybor.uz.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "room")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(name = "room_id_seq",sequenceName = "room_id_seq",allocationSize = 1)
    private Integer id;

    @Column(name = "type")
    private String type;

    @Column(name = "price")
    private BigInteger price;

    @Column(name = "hotel_id")
    private Integer hotel_id;

    public Room(Integer id, String type, BigInteger price) {
        this.id = id;
        this.type = type;
        this.price = price;
    }
}
