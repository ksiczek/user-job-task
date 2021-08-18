package it.instrumentarium.jobs.control;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/people")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2021-08-18T11:45:35.555634972+02:00[Europe/Warsaw]")public interface PeopleApi {

    @GET
    @Produces({ "application/json" })
    List<Person> peopleGet(@QueryParam("page")  @DefaultValue("0")   Integer page,@QueryParam("size")  @DefaultValue("20")   Integer size,@QueryParam("sort")    List<String> sort);

    @DELETE
    @Path("/{id}")
    Response peopleIdDelete(@PathParam("id") Long id);

    @GET
    @Path("/{id}")
    @Produces({ "application/json" })
    Response peopleIdGet(@PathParam("id") Long id);

    @PUT
    @Path("/{id}")
    @Consumes({ "application/json" })
    void peopleIdPut(@PathParam("id") Long id,@Valid PersonUpdate personUpdate);

    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    Response peoplePost(@Valid PersonRegistration personRegistration);
}
