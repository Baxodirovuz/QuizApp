package Service;

import Service.Additional.Language;
import Service.Additional.Level;
import lombok.*;

import java.util.UUID;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Question extends Subject{
    protected String id = UUID.randomUUID().toString();
    private String question;
    private String subjectId = super.id;
    private Level level;
    private Language language;
}
