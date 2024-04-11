package pl.dmagnuckibankapp.dto;

import lombok.*;
import pl.dmagnuckibankapp.model.Address;
import pl.dmagnuckibankapp.model.Client;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AddressDto {

    private String street;
    private String city;
    private String zipCode;
    private ClientDto clientDto;

    public Address toEntity(){
        return Address.builder()
                .street(street)
                .city(city)
                .zipCode(zipCode)
                .build();
    }

}
