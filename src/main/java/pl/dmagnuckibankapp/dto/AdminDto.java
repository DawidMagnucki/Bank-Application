package pl.dmagnuckibankapp.dto;

import lombok.*;
import pl.dmagnuckibankapp.model.Admin;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class AdminDto {

    private String username;
    private String password;
    private String indexNumber;

    public Admin toEntity(){
        return Admin.builder()
                .username(username)
                .password(password)
                .indexNumber(indexNumber)
                .build();
    }
}
