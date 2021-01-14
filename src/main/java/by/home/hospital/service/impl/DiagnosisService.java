package by.home.hospital.service.impl;

import by.home.hospital.domain.Diagnosis;
import by.home.hospital.dto.ExaminationDoctorDto;
import by.home.hospital.service.IDiagnosisService;
import by.home.hospital.service.repository.DiagnosisJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DiagnosisService implements IDiagnosisService {

    @Autowired
    private DiagnosisJpaRepository diagnosisJpaRepository;

    @Override
    public List<Diagnosis> findAll() {
        return this.diagnosisJpaRepository.findAll();
    }

    public Diagnosis save(Diagnosis diagnosis) {
        return this.diagnosisJpaRepository.save(diagnosis);
    }

    public Diagnosis createDiagnosisFromExaminationDoctorDto(ExaminationDoctorDto examinationDoctorDto) {
        Diagnosis diagnosis = new Diagnosis();
        diagnosis.setName(examinationDoctorDto.getDiagnosis());
        diagnosis.setDate(new Date());
        return this.diagnosisJpaRepository.save(diagnosis);
    }

    public List<Diagnosis> findByDiagnosisDetails_Id(Integer idPatient) {
        return this.diagnosisJpaRepository.findByDiagnosisPatientsId(idPatient);
    }

}
