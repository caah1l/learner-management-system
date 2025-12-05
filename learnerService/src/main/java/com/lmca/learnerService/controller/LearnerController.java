package com.lmca.learnerService.controller;

import com.lmca.learnerService.dto.LearnerRequestDTO;
import com.lmca.learnerService.dto.LearnerResponseDTO;
import com.lmca.learnerService.service.LearnerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/learners")
@AllArgsConstructor
@NoArgsConstructor
public class LearnerController {

    private LearnerService learnerService;

    @GetMapping
    public ResponseEntity<List<LearnerResponseDTO>> getLearners(){
        List<LearnerResponseDTO> learners = learnerService.getLearners();
        return ResponseEntity.ok().body(learners);
    }

    @PostMapping
    public ResponseEntity<LearnerResponseDTO> createLearner(@Valid @RequestBody LearnerRequestDTO learnerRequestDTO){
        LearnerResponseDTO newLearner = learnerService.createLearner(learnerRequestDTO);
        return ResponseEntity.ok().body(newLearner);

    }

}
