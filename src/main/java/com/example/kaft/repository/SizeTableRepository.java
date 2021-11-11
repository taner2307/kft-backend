package com.example.kaft.repository;

import com.example.kaft.enums.Gender;
import com.example.kaft.model.SizeTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SizeTableRepository extends JpaRepository<SizeTable, Long> {

    List<SizeTable> findAllByGender(Gender gender);
}
