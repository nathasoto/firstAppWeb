package com.sprintdemo.firstappweb.web.controller;

import com.sprintdemo.firstappweb.web.dao.PersonnageDao;
import com.sprintdemo.firstappweb.web.exceptions.PersonnageIntrouvableException;
import com.sprintdemo.firstappweb.web.model.Personnage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //annotation qui regroupe @Controller et @ResponseBody
public class
PersonnageController {

    private final PersonnageDao personnageDao;

    public PersonnageController(PersonnageDao personnageDao) {
        this.personnageDao = personnageDao;
    }

    @GetMapping("/Personnage")
    public List<Personnage> listePersonnage(){
        return personnageDao.findAll();

    }

    @GetMapping(value = "/Personnage/{id}")
    public Personnage afficherPersonnages(@PathVariable int id) {

        Personnage personnage = personnageDao.findById(id);
        if(personnage==null) throw new PersonnageIntrouvableException();
        return personnage;

    }

    @GetMapping(value = "/Personnages/{type}")//Personnages because personnage give Error
    public List<Personnage> afficherPersonnageSelonType(@PathVariable String type) {

        List<Personnage> personnages = personnageDao.findByType(type);
        if(personnages.isEmpty())throw new PersonnageIntrouvableException();
        return personnages;

    }

    @PostMapping(value = "/Personnage")
    public Personnage ajouterPersonnage(@RequestBody Personnage personnage) {

        return personnageDao.save(personnage);
    }

    @PutMapping("/Personnage/{id}")
    Personnage replacePersonnage(@PathVariable int id, @RequestBody Personnage personnage) {

        return personnageDao.updatePersonnage(id,personnage);
    }

    @DeleteMapping(value = "/Personnage/{id}")
    public Personnage supprimerPersonnage(@PathVariable int id){
        return  personnageDao.delete(id);
    }



}
