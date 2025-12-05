package com.lmca.learnerService.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LearnerRequestDTO {
   @NotBlank()
   private String name;

   @Email
   private String emailId;

   @NotBlank
   private String registeredDate;


}
