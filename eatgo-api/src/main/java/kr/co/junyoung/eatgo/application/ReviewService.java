package kr.co.junyoung.eatgo.application;

import kr.co.junyoung.eatgo.domain.Review;
import kr.co.junyoung.eatgo.domain.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReviewService {

    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    public Review addReview(Review review) {


        return reviewRepository.save(review);

    }
}
