package com.example.Traini8.Controller;

import com.example.Traini8.Entity.TrainingCenter;
import com.example.Traini8.Service.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TrainingCenterController {
    @Autowired
    private TrainingCenterService trainingCenterService;

    @PostMapping("/save")
    public ResponseEntity<TrainingCenter>saveNewTrainingCenter(@Valid @RequestBody  TrainingCenter trainingCenter){
        trainingCenterService.save(trainingCenter);
        return new ResponseEntity<>(trainingCenter, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<TrainingCenter>>allCenter(){
        List<TrainingCenter>allCenters=trainingCenterService.getAll();
        return new ResponseEntity<>(allCenters,HttpStatus.FOUND);
    }
}
