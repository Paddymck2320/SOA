/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.ait;


import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author A00261481
 */
@Path("items")
public class ItemsResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ItemsResource
     */
    public ItemsResource() {
    }

    /**
     * Retrieves representation of an instance of ie.ait.ItemsResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        StringBuffer sb = new StringBuffer();
        
        sb.append("<items>");
        sb.append("<crisps qty='3' />");
        sb.append("<chocolate qty='2' />");
        sb.append("</items>");
        
        return sb.toString();
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
    public String getItem(@PathParam("id") String id){
       
        StringBuffer sb = new StringBuffer();
        sb.append("<item id='" + id + "'/>");
        
        return sb.toString();
    }

    /**
     * PUT method for updating or creating an instance of ItemsResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
