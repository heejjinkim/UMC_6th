package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.service.MissionService.MissionService;
import umc.spring.validation.annotation.ChallengingMission;
import umc.spring.web.dto.MissionRequestDTO;

@Component
@RequiredArgsConstructor
public class MissionChallengingValidator implements ConstraintValidator<ChallengingMission, MissionRequestDTO.ChallengeDTO> {

    private final MissionService missionService;

    @Override
    public void initialize(ChallengingMission constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(MissionRequestDTO.ChallengeDTO values, ConstraintValidatorContext context) {
        boolean isChallenging = missionService.isChallengingMission(values.getMemberId(), values.getMissionId());

        if (isChallenging) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_ALREADY_CHALLENGING.toString()).addConstraintViolation();
        }

        return !isChallenging;
    }
}
