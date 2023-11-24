package com.sprintdemo.firstappweb.web.dao;

import com.sprintdemo.firstappweb.web.model.Personnage;

import java.util.List;

public interface PersonnageDao {
    List<Personnage> findAll();//renvoie la liste complète de tous les personnages

    Personnage findById(int id);//renvoie un personnage par son Id

    List<Personnage>  findByType(String type);//renvoie un personnage par son Type

    Personnage save(Personnage personnage);//ajoute un personnage.

    Personnage updatePersonnage(int id, Personnage personnage);// modifier le personnage identifié par {id} en remplaçant la sa définition actuelle par la définition fournie dans le corps (body) de la requête

    Personnage delete (int id );//supprimer le personnage identifié par {id}, s’il existe

}
