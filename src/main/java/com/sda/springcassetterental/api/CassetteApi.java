package com.sda.springcassetterental.api;

import com.sda.springcassetterental.dao.entity.Cassette;
import com.sda.springcassetterental.manager.CassetteManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/CassetteRental")
public class CassetteApi {
    private CassetteManager cassetteManager;

    @Autowired
    public CassetteApi(CassetteManager cassetteManager) {
        this.cassetteManager = cassetteManager;
    }

    @GetMapping("/all")
    public Iterable<Cassette> getAll() {
        return this.cassetteManager.findAll();
    }

    @GetMapping
    public Optional<Cassette> getById(@RequestParam Long id) {
        return this.cassetteManager.findById(id);
    }

    @PostMapping
    public Cassette post(@RequestBody Cassette cassette) {
        return this.cassetteManager.save(cassette);
    }

    @PutMapping
    public Cassette put(@RequestBody Cassette cassette) {
        return this.cassetteManager.save(cassette);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        this.cassetteManager.deleteById(id);
    }

}
