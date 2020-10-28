package app.todo;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//FIXME
@Table(name = "TODOS")

public class Todo {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy =  "increment")

    private Integer id;
    private String text;
    private Boolean done;

    public Todo(Integer id, String text, Boolean done) {
        this.id = id;
        this.text = text;
        this.done = done;
    }

    public Todo() {

    }

    public Integer getId() {
        return id;
    }

    public String getGreetingMsg() {
        return text;
    }

    public void setGreetingMsg(String greetingMsg) {
        this.text = greetingMsg;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean code) {
        this.done = code;
    }
}
