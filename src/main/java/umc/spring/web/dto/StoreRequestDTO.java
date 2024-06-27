package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import umc.spring.validation.annotation.ExistRegion;

public class StoreRequestDTO {

    @Getter
    public static class JoinDto{
        @NotBlank
        String name;
        @Size(min = 5, max = 12)
        String address;
        @ExistRegion
        Long regionId;
    }


    @Getter
    public static class ReviewCreateDto{
        @NotNull
        private Long memberId;
        @NotNull
        private Long storeId;
        @NotNull
        private float score;
        @NotBlank
        private String content;
    }
}
