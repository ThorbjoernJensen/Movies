package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.MovieDTO;
import entities.Movie;
import utils.EMF_Creator;
import facades.MovieFacade;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

//Todo Remove or change relevant parts before ACTUAL use
@Path("movie")
public class MovieRessource {

    private final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private final MovieFacade FACADE = MovieFacade.getFacadeExample(EMF);
    private final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }

    @Path("count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getRenameMeCount() {

        long count = FACADE.getRenameMeCount();
        //System.out.println("--------------->"+count);
        return "{\"count\":" + count + "}";  //Done manually so no need for a DTO
    }


    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllMovies() {
        List<MovieDTO> moviesDTO = FACADE.getAll();
        return new Gson().toJson(moviesDTO);

    }

    @Path("{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getMovieById(@PathParam("id") Long id) {
        MovieDTO movieDTO = FACADE.getById(id);
        return new Gson().toJson(movieDTO);
    }



    @Path("title/{title}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getEmployeeById(@PathParam("title") String title) {
        MovieDTO movieDTO = FACADE.getMovieByTitle(title);
        return new Gson().toJson(movieDTO);
    }

}
