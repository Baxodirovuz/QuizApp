package Data;

import Service.Additional.Language;
import Service.Additional.Level;
import Service.Additional.Role;
import Service.Question;
import Service.Quiz;
import Service.Subject;
import Service.User;

import java.util.ArrayList;
import java.util.UUID;

public class Data {

    public ArrayList<User> usersList = new ArrayList<>();

    public User user = new User();

    public void defaultItems() {
        user.setId(UUID.randomUUID().toString());
        user.setUsername("Jaloliddin");
        user.setPassword("1234");
        user.setRole(Role.USER);
        user.setLanguage(Language.UZ);
        usersList.add(user);
        user.setUsername(UUID.randomUUID().toString());
        user.setUsername("Alex");
        user.setPassword("alex1234");
        user.setRole(Role.ADMIN);
        user.setLanguage(Language.EN);
        usersList.add(user);

        Question question = new Question();
        Subject subject = new Subject();
        question.setId(UUID.randomUUID().toString());
        question.setQuestion("Internet qachon paydo bo`lgan?");
        question.setLanguage(Language.UZ);
        question.setSubjectId(subject.getId());
        question.setLevel(Level.EASY);
        uzQuizzes.add(question);

        question.setId(UUID.randomUUID().toString());
        question.setQuestion("When did the Internet appear?");
        question.setLanguage(Language.EN);
        question.setSubjectId(subject.getId());
        question.setLevel(Level.EASY);
        enQuizzes.add(question);

        question.setId(UUID.randomUUID().toString());
        question.setQuestion("Когда появился Интернет??");
        question.setLanguage(Language.RU);
        question.setSubjectId(subject.getId());
        question.setLevel(Level.EASY);
        ruQuizzes.add(question);
    }

    public void print(String str) {
        System.out.print(str);
    }
    public void println(String str) {
        System.out.println(str);
    }


    public ArrayList<Question> uzQuizzes = new ArrayList<>();                          // 1-10 IT, 11-20 History
    public ArrayList<Question> ruQuizzes = new ArrayList<>();                          // 1-10 IT, 11-20 History
    public ArrayList<Question> enQuizzes = new ArrayList<>();                          // 1-10 IT, 11-20 History

}
