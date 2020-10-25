package app;

class Language {
    private Integer id;
    private String greetingMsg;
    private String code;

    public Language(Integer id, String greetingMsg, String code) {
        this.id = id;
        this.greetingMsg = greetingMsg;
        this.code = code;
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
