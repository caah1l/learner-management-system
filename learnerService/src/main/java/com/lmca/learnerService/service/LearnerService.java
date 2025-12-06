package com.lmca.learnerService.service;

import com.lmca.learnerService.dto.LearnerRequestDTO;
import com.lmca.learnerService.dto.LearnerResponseDTO;
import com.lmca.learnerService.exception.EmailAlreadyExistsException;
import com.lmca.learnerService.mapper.LearnerMapper;
import com.lmca.learnerService.model.Learner;
import com.lmca.learnerService.repository.LearnerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class LearnerService {

    private LearnerRepository learnerRepository;
    //private LearnerMapper learnerMapper;

    public List<LearnerResponseDTO> getLearners(){
        List<Learner> learners = learnerRepository.findAll();

        return learners.stream().
                map(x -> LearnerMapper.toLearnerResponseDto(x)).toList();
    }

    public LearnerResponseDTO createLearner(LearnerRequestDTO learnerRequestDTO){
         if(learnerRepository.existsByEmailId(learnerRequestDTO.getEmailId())){
             throw new EmailAlreadyExistsException("Learner with this email Id already exists");
         }

          Learner newLearner = learnerRepository.save(LearnerMapper.roLearnerEntity(learnerRequestDTO));

          return LearnerMapper.toLearnerResponseDto(newLearner);
    }


}
