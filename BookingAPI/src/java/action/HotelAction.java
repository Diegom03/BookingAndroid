package action;

import DAO.HotelDAO;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Hotel;

public class HotelAction implements interfaces.Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String cadDestino = "";
        String action = (String) request.getParameter("ACTION");
        String[] arrayAction = action.split("\\.");
        switch (arrayAction[1]) {

            case "FIND_ALL":
                cadDestino = findAll(request, response);
                break;
        }
        return cadDestino;
    }
    
    private String findAll(HttpServletRequest request, HttpServletResponse response) {
        int id_Hotel = 0;
        HotelDAO hotelDao = new HotelDAO();
        Hotel hotel = new Hotel();
        String descripcion = request.getParameter("DESCRIPCION");
        
        if(request.getParameter("ID_HOTEL")!=null){
            id_Hotel = Integer.parseInt(request.getParameter("ID_PELICULA"));
        }
        if(descripcion!=null && descripcion.length()>0){
            hotel.setDescripcion(descripcion);
        }
        if(id_Hotel>0){
            hotel.setId_Hotel(id_Hotel);
        }
        ArrayList<Hotel> hoteles = hotelDao.findAll(hotel);
        return Hotel.toArrayJSon(hoteles);
        //return Pelicula.toCadena(peliculas.get(0));

    }
}
