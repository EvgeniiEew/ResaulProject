package by.home.hospital.service.impl;

import by.home.hospital.domain.PatientDetails;
import by.home.hospital.service.PatientDetailsRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Transactional
@Service
public class PatientDetailsService implements PatientDetailsRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addPatientDetails(PatientDetails patientDetails) {
        entityManager.persist(patientDetails);
    }

    @Override
    public List<PatientDetails> getPatientDetails() {


        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<PatientDetails> cr = cb.createQuery(PatientDetails.class);

        return entityManager.createQuery(cr.select(cr.from(PatientDetails.class))).getResultList();

    }

    @Override
    public PatientDetails getPatientDetailsById(int id) {
        Query query = entityManager.createQuery("Select u from PatientDetails u WHERE patientId = :id", PatientDetails.class);
        query.setParameter("id", id);
        List<PatientDetails> patientDetailsList = query.getResultList();
        return patientDetailsList.get(0);
    }

    @Override
    public void deletePatientDetails(Integer number) {
        entityManager.remove(new PatientDetails());

    }
}