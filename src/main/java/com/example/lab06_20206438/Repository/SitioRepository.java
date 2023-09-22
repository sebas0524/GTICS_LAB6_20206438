package com.example.lab06_20206438.Repository;

import com.example.lab06_20206438.Entity.Sitio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SitioRepository extends JpaRepository<Sitio,Integer> {
}
