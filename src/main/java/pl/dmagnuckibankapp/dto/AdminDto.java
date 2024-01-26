package pl.dmagnuckibankapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdminDto {

    private String username;
    private String password;
    private String indexNumber;
//    private String email;
//    private String phoneNumber;
//    private Permissions permissions;

}
