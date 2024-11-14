package com.Mascotas.Rest_DB.MascotasController;


import com.Mascotas.Rest_DB.MascotasEntity.Mascotas;
import com.Mascotas.Rest_DB.Services.MascotasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/mascotas")
public class MascotasController {


        private final MascotasServices mascotasServices;

        @Autowired
        public MascotasController(MascotasServices mascotasServices) {
            this.mascotasServices = mascotasServices;
        }

        @GetMapping
        public List<Mascotas> getMascotas() {
            return mascotasServices.getAllMascotas();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Mascotas> getMascotas(@PathVariable UUID id) {
            Optional<Mascotas> mascotas = mascotasServices.getMascotasById(id);
            return mascotas.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }

        @PostMapping
        public ResponseEntity<String> createMascotas(@RequestBody Mascotas mascotas) {
            String response = mascotasServices.createMascotas(mascotas);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        }

        @PutMapping("/{id}")
        public ResponseEntity<String> updateMascotas(@PathVariable Long id, @RequestBody Mascotas mascotas) {
            String response = mascotasServices.updateMascota(id, mascotas);
            if ("Mascota actualizada".equals(response)) {
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<String> deleteMascotas(@PathVariable Long id) {
            String response = mascotasServices.deleteMascotas(UUID.randomUUID());
            if ("Mascota eliminada".equals(response)) {
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        }
    }
