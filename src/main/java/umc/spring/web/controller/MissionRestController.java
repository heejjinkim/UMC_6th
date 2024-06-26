package umc.spring.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.service.MissionService.MissionService;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

    private final MissionService missionService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.createResultDTO> join(@RequestBody @Valid MissionRequestDTO.CreateDTO request){
        Mission mission = missionService.createMission(request);
        return ApiResponse.onSuccess(MissionConverter.toCreateResultDTO(mission));
    }
}
