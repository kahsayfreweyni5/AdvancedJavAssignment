package com.freweyni.resourcemanagement.repository;

import com.freweyni.resourcemanagement.model.Resources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourcesRepository extends JpaRepository<Resources,Long> {
}
