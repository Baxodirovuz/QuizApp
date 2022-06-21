package Service;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Result {
    private String username;
    private LocalDateTime time;
    private int isRight;
    private int wrong;
    private boolean complete;
}
