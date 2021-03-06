package com.example.uberritz.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.uberritz.model.Plat;
import com.example.uberritz.service.PlatService;

@RestController
public class PlatController {

    @Autowired
    private PlatService platService;

    @PostMapping("/plat")
    public Plat createPlat(@RequestBody Plat plat) {
        return platService.savePlat(plat);
    }

    @GetMapping("/plats")
    public Iterable<Plat> getPlats() {
        return platService.getPlats();
    }

    @GetMapping("/plat/{id}")
    public Plat getPlat(@PathVariable("id") final Long id) {
        Optional<Plat> plat = platService.getPlat(id);
        if(plat.isPresent()) {
            return plat.get();
        } else {
            return null;
        }
    }

    @PutMapping("/plat/{id}")
    public Plat updatePlat(@PathVariable("id") final Long id, @RequestBody Plat plat) {
        Optional<Plat> p = platService.getPlat(id);
        if(p.isPresent()) {
            Plat currentPlat = p.get();

            String nom = plat.getNom();
            if(nom != null) {
                currentPlat.setNom(nom);
            }

            int prix = plat.getPrix();
            currentPlat.setPrix(prix);

            platService.savePlat(currentPlat);
            return currentPlat;
        } else {
            return null;
        }
    }

	@DeleteMapping("/plat/{id}")
    public void deletePlat(@PathVariable("id") final Long id) {
        platService.deletePlat(id);
    }

}