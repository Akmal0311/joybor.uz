package bootcampExam.joybor.uz.dao;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "amenity")
@Data
@NoArgsConstructor
@Getter
@Setter
public class Amenity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(name = "amenity_id_seq", sequenceName = "amenity_id_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "stars")
    private Integer stars;

    @Column(name = "breakfast")
    private boolean breakfast;

    @Column(name = "restaurant")
    private boolean restaurant;

    @Column(name = "wifi")
    private boolean wifi;

    @Column(name = "pool")
    private boolean pool;

    @Column(name = "gym")
    private boolean gym;

    @Column(name = "spa")
    private boolean spa;

    @Column(name = "hotel_id")
    private Integer hotel_id;

    public Amenity(Integer id, Integer stars, boolean breakfast, boolean restaurant, boolean wifi, boolean pool, boolean gym, boolean spa, Integer hotel_id) {
        this.id = id;
        this.stars = stars;
        this.breakfast = breakfast;
        this.restaurant = restaurant;
        this.wifi = wifi;
        this.pool = pool;
        this.gym = gym;
        this.spa = spa;
        this.hotel_id = hotel_id;
    }
}
