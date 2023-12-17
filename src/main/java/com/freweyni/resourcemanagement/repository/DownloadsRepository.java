package com.freweyni.resourcemanagement.repository;

import com.freweyni.resourcemanagement.model.Downloads;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DownloadsRepository extends JpaRepository<Downloads,Long> {
}
