package com.example.kaft.service;

import com.example.kaft.enums.Gender;
import com.example.kaft.enums.Size;
import com.example.kaft.model.SizeTable;
import com.example.kaft.model.ProductSize;
import com.example.kaft.repository.SizeTableRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductSizeServiceServiceImpl implements IProductSizeService {

    private final SizeTableRepository sizeTableRepository;

    @Override
    public ProductSize calculateProductSize(ProductSize productSize) {
        List<SizeTable> sizeTableList = sizeTableRepository.findAll();
        for (SizeTable st : sizeTableList) {
            if (productSize.getGender() == st.getGender() &&
                    (productSize.getWeight() > st.getBodyWeightMin() &&
                            productSize.getWeight() < st.getBodyWeightMax()) &&
                    (productSize.getHeight() > st.getBodyHeightMin() &&
                            productSize.getHeight() < st.getBodyHeightMax())) {
                productSize.setSizeSuggestion(st.getSize());
            }
        }
        if (productSize.getSizeSuggestion() == null) {
            productSize.setSizeSuggestion(calculateBMI(productSize.getGender(),
                    productSize.getWeight(), productSize.getHeight()));
        }
        return productSize;
    }

    public Size calculateBMI(Gender gender, double weight, double height) {
        Size calculatedSize = null;
        double bmi = weight / Math.pow((height / 100), 2);
        bmi = gender == Gender.FEMALE ? bmi + 1.0 : bmi;
        System.out.println(bmi);
        if (bmi <= 18.5) {
            calculatedSize = gender == Gender.FEMALE ? Size.XS : Size.S;
        } else if (bmi >= 18.6 && bmi <= 24.9) {
            calculatedSize = gender == Gender.FEMALE ? Size.S : Size.M;
        } else if (bmi >= 25.0 && bmi <= 29.9) {
            calculatedSize = gender == Gender.FEMALE ? Size.M : Size.L;
        } else if (bmi >= 30.0 && bmi <= 31.9) {
            calculatedSize = gender == Gender.FEMALE ? Size.L : Size.XL;
        } else if(bmi >= 32) {
            calculatedSize = Size.XL;
        }
        return calculatedSize;
    }
}
