
package ucom.py.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ucom.py.entities.HolaMundo;
import ucom.py.entities.apiresponse.Gastos;
import ucom.py.model.response.ApiResponse;
import ucom.py.services.api.ApiResponseService;
import ucom.py.services.api.GenericDAOServicesWithJson;

@Path("/api-examples")
public class ApiResponseResource {
    @Inject
    private ApiResponseService servicioConInject;

    private GenericDAOServicesWithJson serviceConConstructor;

    public ApiResponseResource(GenericDAOServicesWithJson instanciaService) {
        this.serviceConConstructor = instanciaService;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String recursoBasicoTest() {
        return "Se crea un nuevo recurso en OpenApi";
    }
    @GET
    @Path("clase-generica")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResponse<HolaMundo> retornoDeClaseGenerica() {
        @SuppressWarnings({ "rawtypes", "unchecked" })
        ApiResponse<HolaMundo> respuesta = new ApiResponse();
        respuesta.setCode(200);
        respuesta.setMessage("Primer mensaje");
        HolaMundo hm = new HolaMundo();
        hm.setNobmre("Jhony");
        hm.setEdad(29);
        hm.setFechaNacimiento(new Date());
        respuesta.setData(hm);
        return respuesta;
    }
    @GET
    @Path("clase-generica/service/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResponse<String> retornoDeClaseGenericaConServicio(
            @PathParam("id") Integer id) {
        @SuppressWarnings({ "rawtypes", "unchecked" })
        ApiResponse<String> respuesta = new ApiResponse();
        System.out.println(id);
        try {
            if (id == 2) {
                throw new Exception("se nos fue de las manos");
            }
            respuesta.setCode(Response.Status.OK.getStatusCode());
            respuesta.setMessage("Service message");
            respuesta.setData(servicioConInject.responseDummy());
        } catch (Exception e) {
            respuesta.setCode(Response.Status.CONFLICT.getStatusCode());
            respuesta.setMessage("Primer error");
            respuesta.setData(e.getMessage());
        }

        return respuesta;
    }

    @GET
    @Path("gastos/json")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResponse<List<Gastos>> listarGastos() {
        @SuppressWarnings({ "rawtypes", "unchecked" })
        ApiResponse<List<Gastos>> respuesta = new ApiResponse();
        List<Gastos> lista = new ArrayList<>();
        try {
            lista = serviceConConstructor.listar();
            respuesta.setCode(Response.Status.OK.getStatusCode());
            respuesta.setMessage("Listado, ok");
            respuesta.setData(lista);
        } catch (Exception e) {

            respuesta.setCode(Response.Status.CONFLICT.getStatusCode());
            respuesta.setMessage("Listado, no ok\"");
            respuesta.setData(null);
        }

        return respuesta;
    }

    @POST
    @Path("gastos/json")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ApiResponse<Gastos> agregarGastos(Gastos param) {
        @SuppressWarnings({ "rawtypes", "unchecked" })
        ApiResponse<Gastos> respuesta = new ApiResponse();
        try {
            respuesta.setCode(Response.Status.OK.getStatusCode());
            respuesta.setMessage("Listado, ok");
            respuesta.setData(serviceConConstructor.agregar(param));
        } catch (Exception e) {

            respuesta.setCode(Response.Status.CONFLICT.getStatusCode());
            respuesta.setMessage("Listado, no ok\"");
            respuesta.setData(null);
        }

        return respuesta;
    }

}