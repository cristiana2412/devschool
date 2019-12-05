package com.ing.tech.model.dto;

import com.ing.tech.model.Team;
import lombok.*;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PersonDTO {
     private String firstName;
     private String lastName;
     private String teamName;

     public PersonDTO(String firstName, String lastName) {
          this.firstName = firstName;
          this.lastName = lastName;
     }
}
