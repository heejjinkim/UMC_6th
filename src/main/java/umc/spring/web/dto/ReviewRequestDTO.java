package umc.spring.web.dto;

import lombok.Getter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.annotation.ExistStore;

public class ReviewRequestDTO {

    @Getter
    public static class JoinDto{
        @ExistMember
        Long memberId;
        @ExistStore
        Long storeId;
        @NotNull
        float score;
        @NotBlank
        String content;
    }
}