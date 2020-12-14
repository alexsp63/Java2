package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;

    private String name;

    @OneToMany(mappedBy = "test_list", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Test_list> test_lists;

    public Subject(){}

    public Subject(String name){
        this.name = name;
        this.test_lists = new ArrayList<Test_list>();
    }

    public int getRow_id() {
        return row_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Test_list> getTest_lists() {
        return test_lists;
    }

    public void setTest_lists(List<Test_list> test_lists) {
        this.test_lists = test_lists;
    }

    @Override
    public String toString() {
        return "Subject\n{" +
                "row_id=" + row_id +
                ",\n name='" + name + '\'' +
                ",\n test_lists=" + test_lists +
                '}';
    }
}
