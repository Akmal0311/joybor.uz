package bootcampExam.joybor.uz.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "review")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {

    @Id
    @GeneratedValue(generator = "review_id_seq")
    @SequenceGenerator(name = "review_id_seq", sequenceName = "review_id_seq",allocationSize = 1)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "comment")
    private String comment;

    @Column(name = "rating")
    private String rating;

    @OneToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "cus_id", referencedColumnName = "id")
    private Customer customer;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private Hotel hotel;

    public Review(Integer id, String title, String comment, String rating) {
        this.id = id;
        this.title = title;
        this.comment = comment;
        this.rating = rating;
    }
}
