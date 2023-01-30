package com.example.boot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Transient
    private List<MultipartFile> imgFile;
    @JsonIgnore
    private String img;
    @ManyToMany
    private List<Img> imgs;
    @Transient
    private Double price;
    private Integer sold;
    private Float rate; //agv rate
    private Long ratings;// amount ratings
    private Double oldPrice;
    private Double newPrice;
    @ManyToMany
    private List<Voucher> voucher;
    @ManyToMany
    private List<Color> color;
    private Integer available;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Brand brand;
    @ManyToOne
    private Location shipForm;
    private String description;
}
