package Service;

import Service.Additional.Language;
import lombok.*;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Quiz extends User{
    Subject subject = new Subject();
    private String id = UUID.randomUUID().toString();
    private String userId = super.id;
    private String subjectId = subject.getId();
    private Language language;
    private Boolean completed;
    private Integer quizCount;
}
