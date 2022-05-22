package bootcampExam.joybor.uz.dao;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "amenity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Amenity {

    @Id
    @GeneratedValue(generator = "amenity_id_seq")
    @SequenceGenerator(name = "amenity_id_seq", sequenceName = "amenity_id_seq", allocationSize = 1)
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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private Hotel hotel;

    public Amenity(Integer id, Integer stars, boolean breakfast, boolean restaurant, boolean wifi, boolean pool, boolean gym, boolean spa) {
        this.id = id;
        this.stars = stars;
        this.breakfast = breakfast;
        this.restaurant = restaurant;
        this.wifi = wifi;
        this.pool = pool;
        this.gym = gym;
        this.spa = spa;
    }
}
