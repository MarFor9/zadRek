package com.example.zadanierekrutacyjne.controller;

import com.example.zadanierekrutacyjne.exception.ResourceNotFoundException;
import com.example.zadanierekrutacyjne.model.Worker;
import com.example.zadanierekrutacyjne.repository.WorkerRepositry;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named
@ViewScoped
public class WorkerControllerJSF implements Serializable {



    private Worker worker = new Worker();

    private List<Worker> workers = new ArrayList<>();

    @Autowired
    private WorkerRepositry workerRepositry;

    public void fetchAll() {
        workers = workerRepositry.findAll();
    }

    public void save() {
        workerRepositry.save(worker);
        worker = new Worker();
        workers = workerRepositry.findAll();
    }

    public void remove (Worker worker){
        this.workerRepositry.delete(worker);
        workers = workerRepositry.findAll();
    }

    public void edit(Worker worker) {
        this.worker = worker;
    }

    public void refresh(){
        worker = new Worker();
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorker(List<Worker> workers) {
        this.workers = workers;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }


}
