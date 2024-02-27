package pl.dmagnuckibankapp.dto;

import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AdminDto {

    private String username;
    private String password;
    private String indexNumber;

}
