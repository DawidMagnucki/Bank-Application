package pl.dmagnuckibankapp.dto;

import lombok.*;
import pl.dmagnuckibankapp.model.Client;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ClientDto {

    private String name;
    private String phoneNumber;
    private String indexNumber;
    private List<AccountDto> accountDtos;
    private AddressDto addressDto;

    public Client toEntity() {
        return Client.builder()
                .name(name)
                .phoneNumber(phoneNumber)
                .indexNumber(indexNumber)
//                .address(addressDto.toEntity())
                .build();

    }

}
