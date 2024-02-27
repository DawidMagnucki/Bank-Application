package pl.dmagnuckibankapp.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ClientDto {

    private String name;
    private String phoneNumber;
    private String indexNumber;

}
