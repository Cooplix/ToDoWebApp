package app;

import java.util.Optional;

class HelloService {
    static final String FALLBACK_NAME = "world";
    static final Language FALLBACK_LANG = new Language(1L, "Hello", "en");
    private LangRepository repository;

    HelloService() {
        this(new LangRepository());
    }

     HelloService(LangRepository repository) {
        this.repository = repository;
    }

    String prepareGreeting(String name) {
        return prepareGreeting(name, FALLBACK_LANG.getId());
    }

    String prepareGreeting(String name, Long langId) {
        String welcomeMsg = repository.findById(langId).orElse(FALLBACK_LANG).getGreetingMsg();
        String nameWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME);
        return welcomeMsg + " " + nameWelcome + "!";
    }
}
