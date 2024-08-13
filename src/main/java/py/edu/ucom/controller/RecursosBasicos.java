package py.edu.ucom.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("recursos-basicos")
public class RecursosBasicos {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }
  
    @GET
    @Path("/suma")
    @Produces(MediaType.TEXT_PLAIN)
    public Integer suma() {
        return 5+5;
    }
    @GET
    @Path("/resta")
    @Produces(MediaType.TEXT_PLAIN)
    public Integer resta() {
        return 10-5;
    }
}


