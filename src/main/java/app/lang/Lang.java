package app.lang;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//FIXME
@Table(name = "LANGUAGES")

public class Lang {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy =  "increment")

    private Integer id;
    private String greetingMsg;
    private String code;

    public Lang(Integer id, String greetingMsg, String code) {
        this.id = id;
        this.greetingMsg = greetingMsg;
        this.code = code;
    }

    public Lang() {

    }

    public Integer getId() {
        return id;
    }

    public String getGreetingMsg() {
        return greetingMsg;
    }

    public void setGreetingMsg(String greetingMsg) {
        this.greetingMsg = greetingMsg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
