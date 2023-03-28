/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.Hotel;
import model.HotelArrayList;

/**
 * REST Web Service
 *
 * @author S1-PC56
 */
@Path("generic")
public class HotelApi {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HotelApi
     */
    public HotelApi() {
    }

    /**
     * Retrieves representation of an instance of DAO.HotelApi
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        String opcion = "1";
        ArrayList<Hotel> lstHoteles;
        
        lstHoteles = HotelDAO.findAll(null);
        HotelArrayList hotelesArrayList = new HotelArrayList(lstHoteles);
        String jsonRespuesta = hotelesArrayList.toArrayJson();
        System.out.println("respuesta: " + jsonRespuesta);
        
        return jsonRespuesta;
    }

    /**
     * PUT method for updating or creating an instance of HotelApi
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
