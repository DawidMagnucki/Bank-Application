package pl.dmagnuckibankapp.model;

import jakarta.persistence.*;
import lombok.*;
import pl.dmagnuckibankapp.dto.AddressDto;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String street;
    private String city;
    private String zipCode;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private Client client;

    public AddressDto toDto() {
        return AddressDto.builder()
                .street(street)
                .city(city)
                .zipCode(zipCode)
                .build();

    }
}
