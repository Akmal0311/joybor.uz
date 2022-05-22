package bootcampExam.joybor.uz.rest;

import bootcampExam.joybor.uz.dao.Review;
import bootcampExam.joybor.uz.dto.ResponseDTO;
import bootcampExam.joybor.uz.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("review")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/get/{id}")
    public ResponseDTO<Review> getById(@PathVariable Integer id){
        return reviewService.getReviewById(id);
    }

    @GetMapping("/get-all")
    public ResponseDTO<List<Review>> getAll(){ return reviewService.getReviews();}

    @PostMapping("/add")
    public ResponseDTO<Review> add(@RequestBody Review review){ return reviewService.add(review);}

    @PutMapping("/update")
    public ResponseDTO<Review> update(@RequestBody Review review){ return reviewService.update(review);}

    @DeleteMapping("/delete/{id}")
    public ResponseDTO<Review> delete(@PathVariable Integer id){ return reviewService.delete(id);}
}
