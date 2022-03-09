/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.ait.rest.bank;

import ie.ait.dao.bank.BankDao;
import ie.ait.dao.bank.BankAccount;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author A00261481
 */
public class BankResource {
    
     @POST
    @Produces({MediaType.TEXT_HTML})
    @Consumes(MediaType.APPLICATION_XML)
    public void postStudent(BankAccount bankAccount){
                   BankDao.instance.create(bankAccount);
            }
    
}
