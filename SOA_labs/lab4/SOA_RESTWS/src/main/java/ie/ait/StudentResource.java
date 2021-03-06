/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.ait;

import java.io.IOException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Context;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author a00266219
 */

@Path("students")
public class StudentResource {
   
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Student> getStudents() {
        System.out.println("Hello.. Testing");
        return StudentDao.instance.getStudents();
    }
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{studentId}")
    public Student getStudent(@PathParam("studentId") String id) {
        return StudentDao.instance.getStudent(Integer.parseInt(id));
    }
    
    @POST
    @Produces({MediaType.TEXT_HTML})
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void postStudent(@FormParam("id") int id,
            @FormParam("name") String name,
            @FormParam("address") String address,
            @FormParam("course") String course,
            @Context HttpServletResponse servletResponse) throws IOException {
        
                   Student student = new Student();
                   student.setId(id);
                   student.setCourse(course);
                   student.setName(name);
                   student.setAddress(address);
                   StudentDao.instance.create(student);
                   servletResponse.sendRedirect("../index.html");
            }
    
    @DELETE
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("{studentId}")
    public Response deleteStudent(@PathParam("studentId") String id) {
        
        StudentDao.instance.delete(Integer.parseInt(id));
        return Response.status(200).entity("Operation Successful").build();
    }
    
    @PUT
    @Produces({MediaType.TEXT_HTML})
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("{studentId}")
    public void putStudent(@FormParam("name") String name,
            @FormParam("address") String address,
            @FormParam("course") String course,
            @Context HttpServletResponse servletResponse) throws IOException {
        
                   Student student = new Student();
                   student.setCourse(course);
                   student.setName(name);
                   student.setAddress(address);
                   StudentDao.instance.create(student);
                   servletResponse.sendRedirect("../index.html");
            }
}