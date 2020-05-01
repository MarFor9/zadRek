package com.example.zadanierekrutacyjne.service;

import com.example.zadanierekrutacyjne.dto.WorkerDTO;
import com.example.zadanierekrutacyjne.exception.ResourceNotFoundException;
import com.example.zadanierekrutacyjne.model.Worker;
import com.example.zadanierekrutacyjne.repository.WorkerRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepositry workerRepositry;

    public List<Worker> getAllWorkers() {
        return this.workerRepositry.findAll();
    }

    public Worker createWorker(WorkerDTO workerDTO) {
        Worker worker = new Worker(workerDTO.firstName, workerDTO.lastName, workerDTO.address, workerDTO.mail);
        return workerRepositry.save(worker);
    }

    public Worker getWorkersById(Long workerId)
            throws ResourceNotFoundException {
        Worker worker = workerRepositry.findById(workerId)
                .orElseThrow(() -> new ResourceNotFoundException("Worker not found for this id: " + workerId));
        return worker;
    }

    public Worker updateWorker(Long workerId, WorkerDTO workerDTO)
            throws ResourceNotFoundException {
        Worker worker = workerRepositry.findById(workerId)
                .orElseThrow(() -> new ResourceNotFoundException("Worker not found for this id: " + workerId));
        worker.setFirstName(workerDTO.firstName);
        worker.setLastName(workerDTO.lastName);
        worker.setAddress(workerDTO.address);
        worker.setMail(workerDTO.mail);

        return this.workerRepositry.save(worker);
    }

    public void deleteWorker(Long workerId)
            throws ResourceNotFoundException {
        Worker worker = workerRepositry.findById(workerId)
                .orElseThrow(() -> new ResourceNotFoundException("Worker not found for this id: " + workerId));
        this.workerRepositry.delete(worker);
    }

}
