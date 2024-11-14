package com.Mascotas.Rest_DB.MascotasEntity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "mascotas")
public class Mascotas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String raza;
    private String region;
    private int edad;


    public String name() {
        return name;
    }

    public Mascotas setName(String name) {
        this.name = name;
        return this;
    }

    public String raza() {
        return raza;
    }

    public Mascotas setRaza(String raza) {
        this.raza = raza;
        return this;
    }

    public String region() {
        return region;
    }

    public Mascotas setRegion(String region) {
        this.region = region;
        return this;
    }

    public int edad() {
        return edad;
    }

    public Mascotas setEdad(int edad) {
        this.edad = edad;
        return this;
    }
}
