package it.instrumentarium.jobs.control;

import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("/job-offers")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2021-08-18T11:45:35.555634972+02:00[Europe/Warsaw]")public interface JobOffersApi {

    @GET
    @Produces({ "application/json" })
    List<JobOffer> jobOffersGet(@QueryParam("page")  @DefaultValue("0")   Integer page,@QueryParam("size")  @DefaultValue("20")   Integer size,@QueryParam("sort")    List<String> sort);

    @GET
    @Path("/{id}")
    @Produces({ "application/json" })
    JobOffer jobOffersIdGet(@PathParam("id") Long id);

    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    InlineResponse201 jobOffersPost(@Valid JobOffer jobOffer);
}
