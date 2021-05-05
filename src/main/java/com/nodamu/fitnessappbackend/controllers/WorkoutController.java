package com.nodamu.fitnessappbackend.controllers;

import com.nodamu.fitnessappbackend.models.Workout;
import com.nodamu.fitnessappbackend.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author profnick
 * 5/5/21
 **/

@RestController
@RequestMapping("/workout")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @PostMapping("/")
    public void add(@RequestBody Workout workout) {
        workoutService.saveWorkout(workout);
    }
    @GetMapping("/")
    public List<Workout> findAll() {
        return workoutService.findWorkouts();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        workoutService.deleteWorkout(id);
    }
}
