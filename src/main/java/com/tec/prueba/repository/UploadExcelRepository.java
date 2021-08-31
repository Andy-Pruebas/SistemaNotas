package com.tec.prueba.repository;

import com.tec.prueba.entity.UploadExcel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadExcelRepository extends JpaRepository<UploadExcel, Long> {
}
