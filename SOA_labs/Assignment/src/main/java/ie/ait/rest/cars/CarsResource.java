/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.ait.rest.cars;

import ie.ait.dao.cars.Cars;
import ie.ait.dao.cars.CarDao;
import java.io.IOException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Context;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author A00261481
 */
@Path("cars")
public class CarsResource {
    
    @HEAD
    public Response doHead() {
        return Response.noContent().status(Response.Status.NO_CONTENT).build();
    }
    
    @OPTIONS
    public Response doOptions() {
        Set<String> api = new TreeSet<>();
        api.add("GET");
        api.add("DELETE");
        api.add("POST");
        api.add("HEAD");
        
        return Response.noContent().status(Response.Status.NO_CONTENT).build();
    }
    
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Cars> getCars() {
        return CarDao.instance.getCars();
    }
    
}
