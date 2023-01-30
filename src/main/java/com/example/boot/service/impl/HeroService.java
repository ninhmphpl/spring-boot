package com.example.boot.service.impl;

import com.example.boot.model.Hero;
import com.example.boot.repository.HeroRepository;
import com.example.boot.service.IHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public class HeroService implements IHeroService {
    @Autowired
    private HeroRepository heroRepository;

    @Override
    public List<Hero> findAll() {
        return heroRepository.findAll();
    }

    @Override
    public Optional<Hero> findById(Long aLong) {
        return heroRepository.findById(aLong);
    }

    @Override
    public Hero save(Hero hero) {
        return heroRepository.save(hero);
    }

    @Override
    public void deleteById(Long aLong) {
        heroRepository.deleteById(aLong);
    }
}
