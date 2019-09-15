package com.sda.springcassetterental.manager;

import com.sda.springcassetterental.dao.CassetteRepo;
import com.sda.springcassetterental.dao.entity.Cassette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.sda.springcassetterental.dao.entity.FilmCategory.ACTION;
import static com.sda.springcassetterental.dao.entity.FilmCategory.DRAMA;

@Service
public class CassetteManager {

    private CassetteRepo cassetteRepo;

    @Autowired
    public CassetteManager(CassetteRepo cassetteRepo) {
        this.cassetteRepo = cassetteRepo;
    }

    public Iterable<Cassette> findAll() {
        return this.cassetteRepo.findAll();
    }

    public Optional<Cassette> findById(Long id) {
        return cassetteRepo.findById(id);
    }

    public Cassette save(Cassette cassette) {
        return cassetteRepo.save(cassette);
    }

    public void deleteById(Long id) {
        cassetteRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDatabase() {
        save(new Cassette("Titanic", DRAMA, 10.0));
        save(new Cassette("James Bond", ACTION, 15.0));
        save(new Cassette("Tomb Raider", ACTION, 17.0));
    }
}
