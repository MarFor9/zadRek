package com.example.zadanierekrutacyjne.repository;

import com.example.zadanierekrutacyjne.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepositry extends JpaRepository<Worker, Long> {

}
