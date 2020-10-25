package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LangRepository {
    private List<Language> languages;

    LangRepository() {
        languages = new ArrayList<>(5);
        languages.add(new Language(0, "Hello", "en"));
        languages.add(new Language(1, "Witam", "pl"));
        languages.add(new Language(2, "Привет", "ru"));
    }

    Optional<Language> findById(Integer id) {
        return languages.stream().
                filter(l -> l.getId().equals(id))
                .findFirst();
    }
}
