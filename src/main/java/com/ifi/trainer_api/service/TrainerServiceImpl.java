package com.ifi.trainer_api.service;

import com.ifi.trainer_api.bo.Trainer;
import com.ifi.trainer_api.repository.TrainerRepository;
import org.springframework.stereotype.Service;

@Service
public class TrainerServiceImpl implements TrainerService {

    private TrainerRepository trainerRepository;

    public TrainerServiceImpl(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }

    @Override
    public Iterable<Trainer> getAllTrainers() {
        return this.trainerRepository.findAll();
    }

    @Override
    public Trainer getTrainer(String name) {
        return this.trainerRepository.findById(name).orElse(null);
    }

    @Override
    public Trainer createTrainer(Trainer trainer) {
        return this.trainerRepository.save(trainer);
    }

    @Override
    public Trainer replaceTrainer(Trainer newTrainer, String name) {

        return this.trainerRepository.findById(name)
                .map(trainer -> {
                    trainer.setName(newTrainer.getName());
                    return this.trainerRepository.save(trainer);
                })
                .orElseGet(() -> {
                    newTrainer.setName(name);
                    return this.trainerRepository.save(newTrainer);
                });
    }

    @Override
    public void deleteById(String name) { this.trainerRepository.deleteById(name);}
}
