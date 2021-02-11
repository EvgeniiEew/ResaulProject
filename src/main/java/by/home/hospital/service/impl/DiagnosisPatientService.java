package by.home.hospital.service.impl;

import by.home.hospital.domain.DiagnosisPatient;
import by.home.hospital.domain.ExaminationDoctor;
import by.home.hospital.service.IDiagnosisPatientService;
import by.home.hospital.service.repository.DiagnosisPatientJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class DiagnosisPatientService implements IDiagnosisPatientService {

    private final DiagnosisService diagnosisService;
    private final PatientDetailsService patientDetailsService;
    private final DiagnosisPatientJpaRepository diagnosisPatientJpaRepository;

    @Override
    public DiagnosisPatient save(DiagnosisPatient diagnosisPatient) {
        return this.diagnosisPatientJpaRepository.save(diagnosisPatient);
    }

    @Override
    public void saveDiagnosisPatientFromExaminationDoctorDto(ExaminationDoctor examinationDoctor) {
        DiagnosisPatient diagnosisPatient = new DiagnosisPatient();
        diagnosisPatient.setPatientDetails(this.patientDetailsService.setStatusCheckingByPatientId(examinationDoctor.getPatientId()));
        diagnosisPatient.setDiagnosis(this.diagnosisService.createDiagnosisFromExaminationDoctorDto(examinationDoctor));
        this.diagnosisPatientJpaRepository.save(diagnosisPatient);
    }

}
