package bootcampExam.joybor.uz.dao;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "hotel")
@Data
@NoArgsConstructor
@Getter
@Setter
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(generator = "hotel_id_seq")
//    @SequenceGenerator(name = "hotel_id_seq",sequenceName = "hotel_id_seq",allocationSize = 1)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;


    public Hotel(Integer id, String name, String address, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
    }
}
