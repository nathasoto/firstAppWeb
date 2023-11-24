package com.sprintdemo.firstappweb.web.dao;

import org.springframework.stereotype.Repository;
import com.sprintdemo.firstappweb.web.model.Personnage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository //cette annotation est appliquée à la classe afin d'indiquer à Spring qu'il s'agit d'une classe qui gère les données,
public class PersonnageDaoImpl implements PersonnageDao {

    public static List<Personnage> personnages = new ArrayList<>();

    static {

        personnages.add(new Personnage(1, "Natha", "magicien",10));
        personnages.add(new Personnage(2, "Fabian", "guerrier",7));
        personnages.add(new Personnage(3, "Carole", "magicien",11));
    }
    @Override
    public List<Personnage> findAll() {
        return personnages;
    }

    @Override
    public Personnage findById(int id) {

        for (Personnage personnage : personnages){// this don't have error "status": 500
            if (personnage.getId() == id){
                return personnage;
            }
        }
        return null;

        //return  personnages.stream().filter(element ->element.getId()==(id)).toList().getFirst();// return error 500 when id is not found i dont know is the return


    }
    public List<Personnage> findByType(String type) {

        return  personnages.stream().filter(element ->element.getType().equals(type)).toList();

    }

    @Override
    public Personnage save(Personnage personnage) {
        personnages.add(personnage);
        return personnage;
    }

    @Override
    public Personnage updatePersonnage(int id, Personnage personnage) {

        Personnage personnageUpdate = findById(id);
        personnageUpdate.setNom(personnage.getNom());
        personnageUpdate.setType(personnage.getType());
        personnageUpdate.setpointDeVie(personnage.getpointDeVie());

        return personnageUpdate;
    }

    @Override
    public Personnage delete(int id) {

        Personnage personnageRemoved = findById(id);
        personnages.remove(personnageRemoved);
        return  personnageRemoved;
    }
}
