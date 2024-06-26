package umc.spring.web.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import umc.spring.validation.annotation.ExistStore;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class CreateDTO{
        @ExistStore
        Long storeId;
        @NotBlank
        String title;
        @NotBlank
        String content;
        @NotNull
        Integer point;
        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate deadline;
    }
}