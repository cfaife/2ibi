package com.twoibi.entity;

import org.springframework.hateoas.server.reactive.ReactiveRepresentationModelAssemblerBuildDslKt;

import javax.persistence.*;
import java.io.Serializable;
import org.springframework.hateoas.RepresentationModel;


/**
 * @author Clerio Alfredo Faife
 */
@Entity
@Table(name="country")
public class CountryEntity extends RepresentationModel<CountryEntity>  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "name" , unique = true)
    private String name;

    @Column(name = "capital")
    private String capital;

    @Column(name = "region")
    private String region;

    @Column(name = "sub_region")
    private String subRegion;

    @Column(name = "area")
    private Double area;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubRegion() {
        return subRegion;
    }

    public void setSubRegion(String subRegion) {
        this.subRegion = subRegion;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "CountryEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", region='" + region + '\'' +
                ", subRegion='" + subRegion + '\'' +
                ", area=" + area +
                '}';
    }
}
