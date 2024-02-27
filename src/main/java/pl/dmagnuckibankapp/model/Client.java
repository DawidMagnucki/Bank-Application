package pl.dmagnuckibankapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import pl.dmagnuckibankapp.enums.EmploymentStatus;
import pl.dmagnuckibankapp.enums.Permissions;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String fullName;
    private String idCard;
//    private LocalDate dateOfBirth;
//    private String email;
//    private String phoneNumber;
//    private String residentialAddress;
//    private EmploymentStatus employmentStatus;
//    private String occupation;
//    private double annualIncome;
//    private Permissions permissions;

}



