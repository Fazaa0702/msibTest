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

import com.fazaa.test.model.Lokasi;
import com.fazaa.test.repository.LokasiRepository;




@RestController
@RequestMapping("/api")
public class LokasiController {
    
    @Autowired
    private LokasiRepository lokasiRepository;

    @PostMapping("/lokasi")
    public ResponseEntity<Lokasi> addLokasi (@RequestBody Lokasi lokasi) {
        Lokasi newLokasi = lokasiRepository.save(lokasi);
        return new ResponseEntity<>(newLokasi,HttpStatus.CREATED);        
    }

    @GetMapping("/lokasi")
    public List<Lokasi> getAllLokasi () {
        return lokasiRepository.findAll();
    }

    @PutMapping("/lokasi/{id}")
    public ResponseEntity<Lokasi> updateLokasi(@PathVariable Long id, @RequestBody Lokasi lokasiDetails) {
        Lokasi lokasi = lokasiRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Lokasi not found for this id :: " + id));
        lokasi.setNamaLokasi(lokasiDetails.getNamaLokasi());
        lokasi.setProvinsi(lokasiDetails.getProvinsi());
        lokasi.setKotaKabupaten(lokasiDetails.getKotaKabupaten());
        lokasi.setNegara(lokasiDetails.getNegara());
        final Lokasi updatedLokasi = lokasiRepository.save(lokasi);
        return ResponseEntity.ok(updatedLokasi);
    }

     @DeleteMapping("/lokasi/{id}")
    public Map<String, Boolean> deleteLokasi(@PathVariable Long id) {
        Lokasi lokasi = lokasiRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lokasi not found for this id :: " + id));
        lokasiRepository.delete(lokasi);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
}
