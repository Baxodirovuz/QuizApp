package Service;

import lombok.*;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Subject {
    protected  String id = UUID.randomUUID().toString();
    private String name;
    private String description;
}
