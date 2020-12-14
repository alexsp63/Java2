package models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;

    //название будут совпадать с названием полей таблицы, так что без Column
    private String text;
    private boolean correct;

    //внешний ключ
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Role question;

    @OneToMany(mappedBy = "student_answer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Student_answer> student_answers;

    public Answer(){}

    public Answer(String text, boolean correct){
        this.text=text;
        this.correct=correct;
        this.student_answers = new ArrayList<Student_answer>();
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

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public Role getQuestion() {
        return question;
    }

    public void setQuestion(Role question) {
        this.question = question;
    }

    public List<Student_answer> getStudent_answers() {
        return student_answers;
    }

    public void setStudent_answers(List<Student_answer> student_answers) {
        this.student_answers = student_answers;
    }

    @Override
    public String toString() {
        return "Answer\n{" +
                "row_id=" + row_id +
                ",\n text='" + text + '\'' +
                ",\n correct=" + correct +
                ",\n question=" + question +
                ",\n student_answers=" + student_answers +
                '}';
    }
}
