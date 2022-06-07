package com.project.WebApp.repository;

import com.project.WebApp.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position,String> {
}
