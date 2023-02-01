package obj;

import lombok.*;
import obj.additional.*;

@ToString
@Builder
@Data
public class Quiz {
    private int id;
    private String title;
    private String description;
    private String quesition;
    private Language language;
    private Level level;
}
