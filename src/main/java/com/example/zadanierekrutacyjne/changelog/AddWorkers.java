package com.example.zadanierekrutacyjne.changelog;

import com.example.zadanierekrutacyjne.model.Worker;
import com.example.zadanierekrutacyjne.repository.WorkerRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AddWorkers {

    private WorkerRepositry workerRepositry;

    @Autowired
    public AddWorkers(WorkerRepositry workerRepositry) {
        this.workerRepositry = workerRepositry;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void runExample() {
        List<Worker> workers = new ArrayList<>();
        workers.add(new Worker("Jan", "Kowalski", "Poznan", "jankowalski@gamil.com"));
        workers.add(new Worker("Adam", "Nowak", "Warszawa", "adamnowak@gamil.com"));
        workers.add(new Worker("Grzegorz", "Mazur", "Gdansk", "grzegorzmaz@gamil.com"));
        workers.add(new Worker("Jaroslaw", "Stach", "Warszawa", "jarstach@gamil.com"));

        for(Worker worker : workers) {
            workerRepositry.save(worker);
        }
    }
}
