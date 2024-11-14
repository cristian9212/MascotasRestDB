package com.Mascotas.Rest_DB.Services;

import com.Mascotas.Rest_DB.MascotasEntity.Mascotas;
import com.Mascotas.Rest_DB.Repository.MascotasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MascotasServices {
    private final MascotasRepository mascotasRepository;

    @Autowired
    public MascotasServices(MascotasRepository mascotasRepository) {
            this.mascotasRepository = mascotasRepository;
        }

        public List<Mascotas> getAllMascotas() {
            return mascotasRepository.findAll();
        }

        public Optional<Mascotas> getMascotasById(UUID id) {
            return mascotasRepository.findById(id);
        }

        public String createMascotas(Mascotas mascotas) {
            mascotasRepository.save(mascotas);
            return "Mascota creada";
        }

        public String updateMascota(Long id, Mascotas mascotas) {
            if (mascotasRepository.existsById(UUID.randomUUID())) {
                mascotas.setId(id);
                mascotasRepository.save(mascotas);
                return "Mascota actualizada";
            } else {
                return "Mascota no encontrada";
            }
        }

        public String deleteMascotas(UUID id) {
            if (mascotasRepository.existsById(id)) {
                mascotasRepository.deleteById(id);
                return "Mascota eliminada";
            } else {
                return "Mascota no encontrada";
            }
        }
    }
