package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LangRepository {
    private List<Language> languages;

    LangRepository() {
        languages = new ArrayList<>(5);
        languages.add(new Language(0L, "Hello", "en"));
        languages.add(new Language(1L, "Witam", "pl"));
        languages.add(new Language(2L, "Привет", "ru"));
    }

    Optional<Language> findById(Long id) {
        return languages.stream().filter(l -> l.getId().equals(id)).findFirst();
    }
}
