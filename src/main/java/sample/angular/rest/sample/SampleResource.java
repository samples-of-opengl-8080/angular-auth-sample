package sample.angular.rest.sample;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("sample")
public class SampleResource {
    
    @GET
    public Response method() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
        return Response.ok().entity(format.format(new Date())).build();
    }
}
