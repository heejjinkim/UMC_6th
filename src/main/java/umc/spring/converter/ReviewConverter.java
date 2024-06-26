package umc.spring.converter;
import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;


public class ReviewConverter {

    public static ReviewResponseDTO.createResultDTO toCreateResultDTO(Review review){
        return ReviewResponseDTO.createResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.JoinDto request){
        return Review.builder()
                .score(request.getScore())
                .content(request.getContent())
                .build();
    }


}