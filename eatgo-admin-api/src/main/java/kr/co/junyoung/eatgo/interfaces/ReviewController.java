package kr.co.junyoung.eatgo.interfaces;

import kr.co.junyoung.eatgo.application.ReviewService;
import kr.co.junyoung.eatgo.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews")
    public List<Review> list(){

        List<Review> reviews = reviewService.getReviews();
        return reviews;
    }

}
