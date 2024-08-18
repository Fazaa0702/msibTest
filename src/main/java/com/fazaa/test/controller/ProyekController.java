package com.fazaa.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fazaa.test.model.Proyek;
import com.fazaa.test.repository.ProyekRepository;

@RestController
@RequestMapping("/api")
public class ProyekController {
    @Autowired
    private ProyekRepository proyekRepository;

    @PostMapping("/proyek")
    public ResponseEntity<Proyek> addProyek(@RequestBody Proyek proyek) {
        Proyek newProyek = proyekRepository.save(proyek);
        return new ResponseEntity<>(newProyek, HttpStatus.CREATED);
    }

    @GetMapping("/proyek")
    public List<Proyek> getAllProyek() {
        return proyekRepository.findAll();
    }

    @PutMapping("/proyek/{id}")
    public ResponseEntity<Proyek> updateProyek(@PathVariable Long id, @RequestBody Proyek proyekDetails) {
        Proyek proyek = proyekRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proyek not found for this id :: " + id));
        proyek.setNamaProyek(proyekDetails.getNamaProyek());
        proyek.setClient(proyekDetails.getClient());
        proyek.setTglMulai(proyekDetails.getTglMulai());
        proyek.setTglSelesai(proyekDetails.getTglSelesai());
        proyek.setPimpinanProyek(proyekDetails.getPimpinanProyek());
        proyek.setKeterangan(proyekDetails.getKeterangan());
        final Proyek updatedProyek = proyekRepository.save(proyek);
        return ResponseEntity.ok(updatedProyek);
    }

    @DeleteMapping("/proyek/{id}")
    public Map<String, Boolean> deleteProyek(@PathVariable Long id) {
        Proyek proyek = proyekRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Proyek not found for this id :: " + id));
        proyekRepository.delete(proyek);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
