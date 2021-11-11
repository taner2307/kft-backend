package com.example.kaft.service;

import com.example.kaft.enums.Gender;
import com.example.kaft.enums.Size;
import com.example.kaft.model.ProductSize;
import com.example.kaft.repository.SizeTableRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.TreeMap;

@Service
@AllArgsConstructor
public class ProductSizeServiceServiceImpl implements IProductSizeService {

    private final SizeTableRepository sizeTableRepository;

    @Override
    public ProductSize calculateProductSize(ProductSize productSize) {
        try {
            productSize.setSizeSuggestion(sizeTableRepository.getValue(productSize.getHeight(), productSize.getWeight(), productSize.getGender()).getSize());
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (productSize.getSizeSuggestion() == null) {
            productSize.setSizeSuggestion(calculateBMI(productSize.getGender(),
                    productSize.getWeight(), productSize.getHeight()));
        }
        return productSize;
    }

    public Size calculateBMI(Gender gender, double weight, double height) {
        double bmi = weight / Math.pow((height / 100), 2);
        bmi = gender == Gender.FEMALE ? bmi + 1.0 : bmi;
        TreeMap<Double, Size> gradeMap = new TreeMap<>();
        gradeMap.put(0.0,gender == Gender.FEMALE ? Size.XS : Size.S);
        gradeMap.put(18.6,gender == Gender.FEMALE ? Size.S : Size.M);
        gradeMap.put(25.0,gender == Gender.FEMALE ? Size.M : Size.L);
        gradeMap.put(30.0,gender == Gender.FEMALE ? Size.L : Size.XL);
        gradeMap.put(32.0,Size.XL);

        return gradeMap.floorEntry(bmi).getValue();
    }
}
