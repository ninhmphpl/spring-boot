package com.example.boot.controller;

import com.example.boot.model.Hero;
import com.example.boot.service.IHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/hero")
public class HeroController {
    @Autowired
    private IHeroService heroService;
    @GetMapping
    public ResponseEntity<?> findAll(){
        List<Hero> heroes = heroService.findAll();
        if(heroes.size()==0){
            return new ResponseEntity<>(HttpStatus.valueOf(410));
        }
        return new ResponseEntity<>(heroes, HttpStatus.OK);
    }
}
