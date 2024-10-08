package com.example.Traini8.Service;

import com.example.Traini8.DAO.TrainingCenterRepository;
import com.example.Traini8.Entity.TrainingCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingCenterService {
    @Autowired
    private TrainingCenterRepository trainingCenterRepository;

    public void save(TrainingCenter trainingCenter) {
        trainingCenterRepository.save(trainingCenter);
    }

    public List<TrainingCenter> getAll() {
        return trainingCenterRepository.findAll();
    }
}
