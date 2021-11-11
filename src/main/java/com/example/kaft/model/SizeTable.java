package com.example.kaft.model;

import com.example.kaft.enums.Gender;
import com.example.kaft.enums.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SizeTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private double bodyHeightMax;

    private double bodyHeightMin;

    private double bodyWeightMax;

    private double bodyWeightMin;

    @Enumerated(EnumType.STRING)
    private Size size;

    public SizeTable(Gender gender, double bodyHeightMax,
                     double bodyHeightMin, double bodyWeightMax,
                     double bodyWeightMin, Size size) {
        this.gender = gender;
        this.bodyHeightMax = bodyHeightMax;
        this.bodyHeightMin = bodyHeightMin;
        this.bodyWeightMax = bodyWeightMax;
        this.bodyWeightMin = bodyWeightMin;
        this.size = size;
    }

}
