package com.example.kaft.model;

import com.example.kaft.enums.Gender;
import com.example.kaft.enums.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSize {

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private double height;

    private double weight;

    private Size sizeSuggestion;
}
