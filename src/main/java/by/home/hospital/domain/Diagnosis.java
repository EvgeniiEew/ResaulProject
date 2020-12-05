package by.home.hospital.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    public Diagnosis(String name) {
        this.name = name;
    }

    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private String name;
    @OneToMany(mappedBy = "diagnosis")
    private List<DiagnosisPatient> diagnosisPatients;

}