package obj;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import obj.additional.*;


@Data
@Builder
@ToString
public class User {
    private int id;
    private String username;
    private String password;
    private Language language;
    private Role role;
}
