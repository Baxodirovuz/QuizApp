package Service;

import lombok.*;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class QuizQuestions extends Question{
    private String id = UUID.randomUUID().toString();
    private String questionId = super.id;
    private String quizId;
}
