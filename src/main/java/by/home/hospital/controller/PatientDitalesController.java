package by.home.hospital.controller;

import by.home.hospital.dto.PatientWhisStatusDto;
import by.home.hospital.service.IPatientDetailsService;
import by.home.hospital.service.impl.PatientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PatientDitalesController {
    @Autowired
    private IPatientDetailsService service;
    @Autowired
    private PatientDetailsService patientDetailsService;

    @PostMapping("/patient/stat/{id}" )
    public String patientStatusСhange(@PathVariable("id") Integer id ) {
        service.patientStatusСhange(id);
        return "redirect:/patient/stat";
    }

    private final String patientNotExamid = "patientsNotExamindedList";


    @GetMapping("/patient/stat")
    public String getDoctorDetails(Model model) {
        List<PatientWhisStatusDto> patientsNotExaminded = this.patientDetailsService.getPatientsNotExaminded();
        model.addAttribute("patientsNotExaminded", patientsNotExaminded);
        return this.patientNotExamid;
    }

}
