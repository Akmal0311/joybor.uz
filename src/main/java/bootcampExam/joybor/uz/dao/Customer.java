package bootcampExam.joybor.uz.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(name = "customer_id_seq",sequenceName = "customer_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "card_number")
    private BigInteger card_number;

    @Column(name = "tel_number")
    private String tel_number;

    public Customer(Integer id, String name, String gender, BigInteger card_number, String tel_number) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.card_number = card_number;
        this.tel_number = tel_number;
    }
}
