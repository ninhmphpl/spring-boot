package com.example.boot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "img")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Img {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String url;
}
