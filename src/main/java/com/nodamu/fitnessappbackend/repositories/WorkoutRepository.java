package com.nodamu.fitnessappbackend.repositories;

import com.nodamu.fitnessappbackend.models.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author profnick
 * 5/5/21
 **/

@Repository
public interface WorkoutRepository extends JpaRepository<Workout,Integer> {

    @Query("SELECT w FROM Workout w WHERE w.user = ?#{authentication.name}")
    List<Workout> findAllByUser();
}
