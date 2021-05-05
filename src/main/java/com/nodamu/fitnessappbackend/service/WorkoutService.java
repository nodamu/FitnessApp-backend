package com.nodamu.fitnessappbackend.service;

import com.nodamu.fitnessappbackend.repositories.WorkoutRepository;
import com.nodamu.fitnessappbackend.models.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author profnick
 * 5/5/21
 **/

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    @PreAuthorize("#workout.user == authentication.name")
    public void saveWorkout(Workout workout){
        workoutRepository.save(workout);
    }

    public List<Workout> findWorkouts(){
        return workoutRepository.findAllByUser();
    }

    public void deleteWorkout(int id){
        workoutRepository.deleteById(id);
    }
}
