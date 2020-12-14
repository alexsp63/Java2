package models;

import javax.persistence.*;

@Entity
@Table(name = "test")
public class Test {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private Test_list test;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    public Test(){}

    public int getRow_id() {
        return row_id;
    }

    public Test_list getTest() {
        return test;
    }

    public void setTest(Test_list test) {
        this.test = test;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Test\n{" +
                "row_id=" + row_id +
                ",\n test=" + test +
                ",\n question=" + question +
                '}';
    }
}
