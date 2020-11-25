package by.home.hospital.service.impl;

import by.home.hospital.domain.Credentials;
import by.home.hospital.service.CredentialsRepository;
import by.home.hospital.service.until.ISessionProvider;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Service
public class CredentialsService implements CredentialsRepository {
    private ISessionProvider sessionProvider;

    public CredentialsService(ISessionProvider sessionProvider) {
        this.sessionProvider = sessionProvider;
    }

    @Override
    public void addCredentials(Credentials credentials) {
        Session entityManager = sessionProvider.getEntityManager().getCurrentSession();
        entityManager.getTransaction().begin();
        entityManager.persist(credentials);
        entityManager.getTransaction().commit();

    }

    @Override
    public List<Credentials> getCredentials() {

        EntityManager entityManager = sessionProvider.getEntityManager().createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Credentials> cr = cb.createQuery(Credentials.class);

        return entityManager.createQuery(cr.select(cr.from(Credentials.class))).getResultList();

    }

    @Override
    public void deleteCredentials(Integer number) {

        EntityManager entityManager = sessionProvider.getEntityManager().createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.remove(new Credentials());
        entityManager.getTransaction().commit();

    }

}
