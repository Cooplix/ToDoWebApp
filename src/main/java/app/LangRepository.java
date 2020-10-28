package app;

import java.util.List;
import java.util.Optional;

public class LangRepository {
    List<Language> findAll() {
        var session =  HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        var result = session.createQuery("from Language", Language.class).list();

        transaction.commit();
        session.close();

        return result;
    }


    Optional<Language> findById(Integer id) {
        var session =  HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        var result = session.get(Language.class, id);

        transaction.commit();
        session.close();

        return Optional.ofNullable(result);

    }
}
