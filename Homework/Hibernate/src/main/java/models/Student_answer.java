package models;

import javax.persistence.*;

@Entity
@Table(name = "student_answer")
public class Student_answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private Test_list test;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "answer_id")
    private Answer answer;

    public Student_answer(){}

    public int getRow_id() {
        return row_id;
    }

    public Test_list getTest() {
        return test;
    }

    public void setTest(Test_list test) {
        this.test = test;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Student_answer\n{" +
                "row_id=" + row_id +
                ",\n test=" + test +
                ",\n user=" + user +
                ",\n answer=" + answer +
                '}';
    }
}
