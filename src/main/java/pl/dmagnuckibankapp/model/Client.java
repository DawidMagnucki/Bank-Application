package pl.dmagnuckibankapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dmagnuckibankapp.enums.EmploymentStatus;
import pl.dmagnuckibankapp.enums.Permissions;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Client {
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



