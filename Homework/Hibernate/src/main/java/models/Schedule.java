package models;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int row_id;

    private int duration;
    private Date start_dt;
    private Time start_time;
    private Date end_dt;
    private Time end_time;
    private boolean activate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id")
    private Test test;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    public Schedule(){}

    /*public Schedule(int duration, Date start_dt, Time start_time, Date end_dt, Time end_time, boolean activate){
        this.duration = duration;
        this.start_dt = start_dt;
        this.start_time = start_time;
        this.end_dt = end_dt;
        this.end_time = end_time;
        this.activate = activate;
    }

     */

    public int getRow_id() {
        return row_id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Date getStart_dt() {
        return start_dt;
    }

    public void setStart_dt(Date start_dt) {
        this.start_dt = start_dt;
    }

    public Time getStart_time() {
        return start_time;
    }

    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_dt() {
        return end_dt;
    }

    public void setEnd_dt(Date end_dt) {
        this.end_dt = end_dt;
    }

    public Time getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }

    public boolean isActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }

    @Override
    public String toString() {
        return "Schedule\n{" +
                "row_id=" + row_id +
                ",\n duration=" + duration +
                ",\n start_dt=" + start_dt +
                ",\n start_time=" + start_time +
                ",\n end_dt=" + end_dt +
                ",\n end_time=" + end_time +
                ",\n activate=" + activate +
                ",\n test=" + test +
                ",\n group=" + group +
                '}';
    }
}
