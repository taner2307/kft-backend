package com.example.kaft.service;

import com.example.kaft.enums.Gender;
import com.example.kaft.enums.Size;
import com.example.kaft.model.SizeTable;
import com.example.kaft.repository.SizeTableRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SizeServiceImpl implements ISizeService {

    private final SizeTableRepository sizeTableRepository;

    @PostConstruct
    private void init() {
        List<SizeTable> sizeTableList = new ArrayList<>();
        sizeTableList.add(new SizeTable(Gender.MALE, 155,140,55,40, Size.S));
        sizeTableList.add(new SizeTable(Gender.MALE, 170,155,70,55, Size.S));
        sizeTableList.add(new SizeTable(Gender.MALE, 185,170,85,70, Size.M));
        sizeTableList.add(new SizeTable(Gender.MALE, 200,185,100,85,Size.L));
        sizeTableList.add(new SizeTable(Gender.MALE, 210,200,120,100,Size.XL));
        sizeTableList.add(new SizeTable(Gender.FEMALE, 155,140,55,40, Size.XS));
        sizeTableList.add(new SizeTable(Gender.FEMALE, 170,155,70,55, Size.S));
        sizeTableList.add(new SizeTable(Gender.FEMALE, 185,170,85,70, Size.M));
        sizeTableList.add(new SizeTable(Gender.FEMALE, 200,185,100,85,Size.L));
        sizeTableList.add(new SizeTable(Gender.FEMALE, 210,200,120,100,Size.XL));
        sizeTableRepository.saveAll(sizeTableList);
    }

    @Override
    public List<SizeTable> sizeTableList(Gender gender) {
        List<SizeTable> sizeList = sizeTableRepository.findAllByGender(gender);
        return sizeList;
    }
}
