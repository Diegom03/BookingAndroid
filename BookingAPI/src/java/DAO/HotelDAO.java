package DAO;

import interfaces.IDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Hotel;
import utils.ConnectionFactory;
import utils.MotorSQL;

public class HotelDAO implements IDAO <Hotel, Integer> {
    private final String SQL_FINDALL = "SELECT * FROM `pelicula` WHERE 1=1 ";

    private final String SQL_ADD = "INSERT INTO `pelicula` (`Titulo`, `Precio`, `Duracion`, `Trailer`, `Sinopsis`, `N_Votos`, `S_Puntuacion`, `Fecha_Estreno`) VALUES ";

    private final String SQL_DELETE = "DELETE FROM `pelicula` WHERE ID_Pelicula=";

    private final String SQL_UPDATE = "UPDATE `pelicula` SET ";

    private MotorSQL motorSql;
    
    public HotelDAO() {
        motorSql = ConnectionFactory.selectDb();
    }

    @Override
    public int add(Hotel bean) {
        int resp = 0;
        try {
            motorSql.connect();

            String sql = SQL_ADD + "('"
                    + bean.getNombre()+ "', '"
                    + bean.getDescripcion() + "', '"
                    + bean.getPais() + "', '"
                    + bean.getUbicacion() + "', '"
                    + bean.getUrl() + "', '"
                    + bean.getId_Hotel() + "', '"
                    + bean.getHabitaciones() + "', '"
                    + bean.getPuntuacion() + "');";

            resp = motorSql.execute(sql);

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();

        }
        if (resp > 0) {
            System.out.println("Película insertada con exito.");
        }
        return resp;
    }

    @Override
    public int delete(Integer id_Hotel) {
        int resp = 0;
        motorSql.connect();
        try {
            String sql = SQL_DELETE + id_Hotel;
            //desactivo la restriccion de claves foráneas para borrado
            motorSql.execute("SET FOREIGN_KEY_CHECKS=0;");
            resp = motorSql.execute(sql);
            //vuelvo a activar la restricción de claves foráneas
            motorSql.execute("SET FOREIGN_KEY_CHECKS=1;");

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();

        }
        if (resp > 0) {
            System.out.println("Borrado con exito.");
        } else {
            System.out.println("No se pudo borrar.");
        }
        return resp;
    }

    @Override
    public ArrayList<Hotel> findAll(Hotel bean) {
        ArrayList<Hotel> hoteles = new ArrayList<>();
        String sql= SQL_FINDALL;
        try {
            //1º) 
            motorSql.connect();
            if (bean != null) {
                if (bean.getNombre() != null) {
                    sql += "AND NOMBRE='" + bean.getNombre() + "'";
                }
                if (bean.getDescripcion() != null) {
                    sql += "AND DESCRIPCION='" + bean.getDescripcion() + "'";
                }

                if (bean.getPais() != null) {
                    sql += "AND PAIS='" + bean.getPais() + "'";
                }
                if (bean.getUbicacion() != null) {
                    sql += "AND UBICACION='" + bean.getUbicacion() + "'";
                }
                if (bean.getUrl() != null) {
                    sql += "AND URL='" + bean.getUrl() + "'";
                }
                if (bean.getId_Hotel() != 0) {
                    sql += "AND ID_HOTEL='" + bean.getId_Hotel() + "'";
                }
                if (bean.getHabitaciones() != 0) {
                    sql += "AND HABITACION='" + bean.getHabitaciones() + "'";
                }
                if (bean.getPuntuacion() != 0) {
                    sql += "AND PUNTUACION='" + bean.getPuntuacion() + "'";
                }
            }

            System.out.println(sql);
            ResultSet rs = motorSql.executeQuery(sql);

            while (rs.next()) {
                Hotel hotel = new Hotel();
                
                hotel.setNombre(rs.getString(1));
                hotel.setDescripcion(rs.getString(2));
                hotel.setPais(rs.getString(3));
                hotel.setUbicacion(rs.getString(4));
                hotel.setUrl(rs.getString(5));
                hotel.setId_Hotel(rs.getInt(6));
                hotel.setHabitaciones(rs.getInt(7));
                hotel.setPuntuacion(rs.getInt(8));

                hoteles.add(hotel);

            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            motorSql.disconnect();
        }
        return hoteles;
    }

    @Override
    public int update(Hotel bean) {
        int resp = 0;
        String sql;
        try {
            motorSql.connect();

            if (bean == null) {
                System.out.println("Introduzca datos a modificar");
            } else {

                sql = SQL_UPDATE;
                if (bean.getNombre() != null) {
                    sql += "NOMBRE='" + bean.getNombre() + "'";
                }

                if (bean.getDescripcion() != null) {
                    sql += "DESCRIPCION='" + bean.getDescripcion() + "'";
                }

                if (bean.getPais() != null ) {
                    sql += "PAIS='" + bean.getPais() + "'";
                }

                if (bean.getUbicacion() != null) {
                    sql += "UBICACION='" + bean.getUbicacion() + "', ";
                }

                if (bean.getUrl() != null) {
                    sql += "URL='" + bean.getUrl() + "'";
                }

                if (bean.getHabitaciones() > 0) {
                    sql += "HABITACIONES='" + bean.getHabitaciones() + "'";
                }

                if (bean.getPuntuacion() > 0) {
                    sql += "PUNTUACION  ='" + bean.getPuntuacion() + "'";
                }

                sql += " WHERE `Id_Hotel`=" + bean.getId_Hotel() + ";";
                System.out.println(sql);
                resp = motorSql.execute(sql);
            }

        } catch (Exception e) {

        } finally {
            motorSql.disconnect();
        }

        if (resp > 0) {
            System.out.println("Pelicula actualizada con éxito.");
        } else {
            System.out.println("No se pudo actualizar.");
        }
        return resp;
    }
    
}