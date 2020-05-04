package com.example.zadanierekrutacyjne.controller;

import com.example.zadanierekrutacyjne.dto.WorkerDTO;
import com.example.zadanierekrutacyjne.exception.ResourceNotFoundException;
import com.example.zadanierekrutacyjne.model.Worker;
import com.example.zadanierekrutacyjne.service.WorkerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/workers")
    public List<WorkerDTO> getAllWorkers(){
        return  workerService.getAllWorkers().stream()
                .map(worker -> modelMapper.map(worker, WorkerDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/workers/{id}")
    public WorkerDTO getWorkersById(@PathVariable(value = "id") Long workerId) throws ResourceNotFoundException {
        return modelMapper.map(workerService.getWorkersById(workerId), WorkerDTO.class);
    }

    @PostMapping("/workers")
    public Worker createWorker(@RequestBody @Validated WorkerDTO workerDTO){
        return workerService.createWorker(workerDTO);
    }

    @PutMapping("/workers/{id}")
    public WorkerDTO updateWorker(@PathVariable(value = "id") Long workerId,
                                  @Validated @RequestBody WorkerDTO workerDTO)
            throws ResourceNotFoundException {
        return modelMapper.map(workerService.updateWorker(workerId, workerDTO), WorkerDTO.class);
    }

    @DeleteMapping("/workers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWorker(@PathVariable(value = "id") Long workerId)
            throws ResourceNotFoundException {
        workerService.deleteWorker(workerId);
    }
}
