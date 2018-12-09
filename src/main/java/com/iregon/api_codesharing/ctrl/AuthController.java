package com.iregon.api_codesharing.ctrl;

import com.iregon.api_codesharing.db.DBInteractionImpl;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("auth")
public class AuthController {

    @Path("login/{clientId}")
    @Produces (MediaType.APPLICATION_JSON)
    public String authUser(/*@PathVariable("name") String name*/) throws IOException, ClassNotFoundException, SQLException {
        DBInteractionImpl db = new DBInteractionImpl();
        db.connect();
        ResultSet rs = db.excuteQuery("SELECT * FROM user");
        String response = "";

        while (rs.next()) {
            response += rs.getInt("userID");
            response += "<br>";
        }
        return response;
    }
}
