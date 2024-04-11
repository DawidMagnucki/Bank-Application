package pl.dmagnuckibankapp.model;

import jakarta.persistence.*;
import lombok.*;
import pl.dmagnuckibankapp.dto.ClientDto;
import pl.dmagnuckibankapp.enums.EmploymentStatus;
import pl.dmagnuckibankapp.enums.Permissions;

import java.time.LocalDate;
import java.util.List;

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

    @ToString.Exclude
    @OneToMany(mappedBy = "client")
    private List<Account> accounts;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Address address;

    public ClientDto toDto() {
        return ClientDto.builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .indexNumber(indexNumber)
                .addressDto(address.toDto())
                .build();
    }

}



