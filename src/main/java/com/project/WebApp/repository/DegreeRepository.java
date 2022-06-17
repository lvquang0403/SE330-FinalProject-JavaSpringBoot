package com.project.WebApp.repository;

import com.project.WebApp.model.Degree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DegreeRepository extends JpaRepository<Degree, String> {
}
