package pl.dmagnuckibankapp.model;

import jakarta.persistence.*;
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
    private Long id;
    private String name;
    private String phoneNumber;
    private String indexNumber;

    @OneToMany
    private Account account;

}



