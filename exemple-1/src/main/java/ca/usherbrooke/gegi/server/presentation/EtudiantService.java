package ca.usherbrooke.gegi.server.presentation;

import ca.usherbrooke.gegi.server.business.Notification;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import java.sql.*;
import java.util.ArrayList;

@Path("")
public class EtudiantService {

    @Context
    HttpServletRequest httpServletRequest;

    @GET
    @Path("etudiant")
    @Produces("application/json")

    public ArrayList<Notification> getNotifications() {
        System.out.println(httpServletRequest.getUserPrincipal().getName());
        int i = 0;
        ArrayList<Notification> notificationArray = new ArrayList<>();
        try{
            Connection conn = DriverManager.getConnection("jdbc:postgresql://zeus.gel.usherbrooke.ca:5432/s3iprojet02", "s3iprojet02", "s3iprojet");
            PreparedStatement st = conn.prepareStatement("SELECT * FROM notification WHERE cip = ? ORDER BY horodatage");
            st.setString(1, httpServletRequest.getUserPrincipal().getName());
            ResultSet rs = st.executeQuery();
            while (rs.next() && i < 20)
            {
                Notification notif = new Notification();
                notif.setId(rs.getString(1));
                notif.setDate(rs.getString(2));
                notif.setDescription(rs.getString(3));
                notif.setExpediteurId(rs.getInt(4));
                notif.setLien(rs.getString(5));
                notificationArray.add(notif);
                i++;
                System.out.println(notif.getDescription());
            }
            rs.close();
            st.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return notificationArray;
    }

}
