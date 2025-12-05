package com.lmca.learnerService.dto;

import lombok.Data;

@Data
public class LearnerResponseDTO {
    private String id;
    private String name;
    private String emailId;
    private String registeredDate;
}
