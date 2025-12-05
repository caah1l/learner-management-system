package com.lmca.learnerService.mapper;

import com.lmca.learnerService.dto.LearnerRequestDTO;
import com.lmca.learnerService.dto.LearnerResponseDTO;
import com.lmca.learnerService.model.Learner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class LearnerMapper {
    public static LearnerResponseDTO toLearnerResponseDto(Learner learner){
        LearnerResponseDTO learnerDto = new LearnerResponseDTO();

        learnerDto.setId(learner.getId().toString());
        learnerDto.setName(learner.getName());
        learnerDto.setEmailId(learnerDto.getEmailId());
        learnerDto.setRegisteredDate(learner.getRegisteredDate().toString());

        return learnerDto;
    }

    public static Learner roLearnerEntity(LearnerRequestDTO learnerRequestDto){
        Learner learner = new Learner();

        learner.setName(learnerRequestDto.getName());
        learner.setEmailId(learnerRequestDto.getEmailId());
        learner.setRegisteredDate(LocalDate.parse(learnerRequestDto.getRegisteredDate()));

        return learner;
    }
}
