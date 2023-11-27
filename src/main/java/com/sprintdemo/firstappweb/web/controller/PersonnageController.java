package com.sprintdemo.firstappweb.web.controller;

import com.sprintdemo.firstappweb.web.dao.PersonnageDao;
import com.sprintdemo.firstappweb.web.exceptions.PersonnageIntrouvableException;
import com.sprintdemo.firstappweb.web.model.Personnage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //annotation qui regroupe @Controller et @ResponseBody
public class
PersonnageController {

    private final PersonnageDao personnageDao;

    public PersonnageController(PersonnageDao personnageDao) {
        this.personnageDao = personnageDao;
    }

    @GetMapping("/Personnages")
    public List<Personnage> listePersonnage(){
        return personnageDao.findAll();

    }
    @Operation(summary = "Get a personnage by id")
    @ApiResponses(value = {
            @ApiResponse (responseCode = "200", description = "Found the personnage",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Personnage.class)) }),//show the schema
            @ApiResponse (responseCode = "404", description = "personnage not found",
                    content = @Content)
     })
    @GetMapping(value = "/Personnage/{id}")
    public Personnage afficherPersonnages(@Parameter(description = "id of personnage to be searched") @PathVariable int id) {

        Personnage personnage = personnageDao.findById(id);
        if(personnage==null)  throw new PersonnageIntrouvableException();
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
    @Operation (summary = "Supprimer un personnage par son id")
    public Personnage supprimerPersonnage(@PathVariable int id){
        return  personnageDao.delete(id);
    }



}
