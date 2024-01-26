package pl.dmagnuckibankapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.dmagnuckibankapp.enums.Permissions;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Admin {

    private String username;
    private String password;
    private String indexNumber;
    private String email;
    private String phoneNumber;
    private Permissions permissions;

}
