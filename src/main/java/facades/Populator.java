/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.MovieDTO;
import entities.Movie;

import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

/**
 *
 * @author tha
 */
public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        MovieFacade fe = MovieFacade.getFacadeExample(emf);
        fe.create(new MovieDTO(new Movie("Ivanhoe", "Victor Hugo")));
        fe.create(new MovieDTO(new Movie("Bedstefar med svolvstikkerne", "H.C.Andersen")));
        fe.create(new MovieDTO(new Movie("First blood 3", "Marx")));
    }
    
    public static void main(String[] args) {
        populate();
    }
}
