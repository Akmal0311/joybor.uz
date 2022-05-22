package bootcampExam.joybor.uz.service;

import bootcampExam.joybor.uz.dao.Review;
import bootcampExam.joybor.uz.dto.ResponseDTO;
import bootcampExam.joybor.uz.dto.ValidatorDTO;
import bootcampExam.joybor.uz.helper.HttpCode;
import bootcampExam.joybor.uz.helper.HttpMessage;
import bootcampExam.joybor.uz.helper.Validation;
import bootcampExam.joybor.uz.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ResponseDTO<Review> getReviewById(Integer id) {

        Review review = reviewRepository.getById(id);

        if (review != null){
            return new ResponseDTO<>(true, HttpCode.OK, HttpMessage.OK, review);
        }
        return new ResponseDTO<>(false, HttpCode.NOT_FOUND, HttpMessage.NOT_FOUND, null);
    }

    public ResponseDTO<List<Review>> getReviews() {

        List<Review> reviews = reviewRepository.getReviews();

        if (reviews != null) {
            return new ResponseDTO<>(true, HttpCode.OK, HttpMessage.OK, reviews);
        }
        return new ResponseDTO<>(false, HttpCode.NOT_FOUND, HttpMessage.NOT_FOUND, null);
    }

    public ResponseDTO<Review> add(Review review) {

        try {
            List<ValidatorDTO> errors = Validation.validateReview(review);

            if(errors.size() > 0) return new ResponseDTO<>(false, HttpCode.VALIDATION_ERROR, HttpMessage.VALIDATION_ERROR, review,errors);

            return new ResponseDTO<>(true, HttpCode.OK, HttpMessage.OK, review);


        }catch (Exception e){
            e.printStackTrace();
            return new ResponseDTO<>(false, HttpCode.DATABASE_ERROR, HttpMessage.DATABASE_ERROR, null);
        }
    }

    public ResponseDTO<Review> update(Review review) {

        Review review1 =  reviewRepository.save(review);

        if (review1 != null){
            return new ResponseDTO<>(true,HttpCode.OK,HttpMessage.OK,review1);
        }
        return new ResponseDTO<>(false, HttpCode.NOT_FOUND, HttpMessage.NOT_FOUND, null);
    }


    public ResponseDTO<Review> delete(Integer id) {
        reviewRepository.deleteById(id);

        if (reviewRepository.getById(id) == null) {
            return new ResponseDTO<>(true,  HttpCode.OK, HttpMessage.OK, null);
        }
        return new ResponseDTO<>(false, HttpCode.NOT_FOUND, HttpMessage.NOT_FOUND, null);
    }
}
