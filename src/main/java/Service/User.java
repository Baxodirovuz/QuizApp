package Service;

import Service.Additional.Language;
import Service.Additional.Role;
import lombok.*;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class User {
    protected String id = UUID.randomUUID().toString();
    private String username;
    private String password;
    private Role role;
    private Language language;
}
