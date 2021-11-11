package com.example.kaft.repository;

import com.example.kaft.enums.Gender;
import com.example.kaft.model.SizeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SizeTableRepository extends JpaRepository<SizeTable, Long> {

    List<SizeTable> findAllByGender(Gender gender);

    @Query("select m from SizeTable m where (:height BETWEEN m.bodyHeightMin AND m.bodyHeightMax) AND" +
            " (:weight BETWEEN m.bodyWeightMin AND m.bodyWeightMax) AND m.gender = :gender")
    SizeTable getValue(double height, double weight, Gender gender);
}
