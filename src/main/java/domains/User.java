package domains;

import lombok.*;
import domains.additional.*;


@Data
@Builder
@ToString
public class User {
    private int id;
    private String UUID;
    private String username;
    private String password;
    private Language language;
    private Role role;
}
