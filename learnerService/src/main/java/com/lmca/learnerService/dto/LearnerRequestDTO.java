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

   public @NotBlank() String getName() {
      return name;
   }

   public void setName(@NotBlank() String name) {
      this.name = name;
   }

   public @Email String getEmailId() {
      return emailId;
   }

   public void setEmailId(@Email String emailId) {
      this.emailId = emailId;
   }

   public @NotBlank String getRegisteredDate() {
      return registeredDate;
   }

   public void setRegisteredDate(@NotBlank String registeredDate) {
      this.registeredDate = registeredDate;
   }
}
