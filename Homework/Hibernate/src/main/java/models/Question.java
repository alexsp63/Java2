package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;

    private String text;
    private int score;
    private boolean active;

    @OneToMany(mappedBy = "answer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Test> tests;

    public Question(){}

    public Question(String text, int score, boolean active){
        this.text = text;
        this.score = score;
        this.active = active;
        this.answers = new ArrayList<Answer>();
        this.tests = new ArrayList<Test>();
    }

    public int getRow_id() {
        return row_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    @Override
    public String toString() {
        return "Question\n{" +
                "row_id=" + row_id +
                ",\n text='" + text + '\'' +
                ",\n score=" + score +
                ",\n active=" + active +
                ",\n answers=" + answers +
                ",\n tests=" + tests +
                '}';
    }
}
