package app;

import org.eclipse.jetty.server.session.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LangRepository {
    Optional<Language> findById(Integer id) {
        var session =  HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        var result = session.get(Language.class, id);


        transaction.commit();
        session.close();

        return Optional.ofNullable(result);

    }
}
