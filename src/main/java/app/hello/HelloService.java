package app.hello;

import app.lang.LangRepository;
import app.lang.Lang;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

class HelloService {
    static final String FALLBACK_NAME = "world";
    static final Lang FALLBACK_LANG = new Lang(1, "Hello", "en");
    private final Logger logger = LoggerFactory.getLogger(HelloService.class);

    private LangRepository repository;

    HelloService() {
        this(new LangRepository());
    }

     HelloService(LangRepository repository) {
        this.repository = repository;
    }

    String prepareGreeting(String name, String langId) {
        Integer langIdLong;

        try {
            langIdLong = Optional.ofNullable(langId).map(Integer::valueOf).orElse(FALLBACK_LANG.getId());

        } catch (NumberFormatException e) {
                logger.warn("Non numeric language id: " + langId);
                langIdLong = FALLBACK_LANG.getId();
        }


        String welcomeMsg = repository.findById(langIdLong).orElse(FALLBACK_LANG).getGreetingMsg();
        String nameWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME);
        return welcomeMsg + " " + nameWelcome + "!";
    }
}
