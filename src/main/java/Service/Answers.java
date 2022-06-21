package Service;

import lombok.*;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Answers extends Question {
    private String id = UUID.randomUUID().toString();
    private String questionId = super.id;
    private int answers;
    private int isRight;
}
