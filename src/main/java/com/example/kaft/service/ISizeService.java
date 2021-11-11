package com.example.kaft.service;

import com.example.kaft.enums.Gender;
import com.example.kaft.model.SizeTable;

import java.util.List;

public interface ISizeService {

    List<SizeTable> sizeTableList(Gender gender);
}
