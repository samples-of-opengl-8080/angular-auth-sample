package sample.angular.rest.session;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import sample.angular.app.session.SimpleLoginService;

@Path("session")
@RequestScoped
public class SessionResource {
    
    @Inject
    private SimpleLoginService loginService;
    
    @Inject
    private UserSession userSession;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(LoginForm form) {
        System.out.println("login");
        
        if (this.loginService.validate(form.getPassword())) {
            this.userSession.start();
            return Response.ok().build();
        } else {
            return Response.status(Status.UNAUTHORIZED).build();
        }
    }
    
    @GET
    public Response inquire() {
        if (this.userSession.isLogged()) {
            return Response.ok().build();
        } else {
            return Response.status(Status.UNAUTHORIZED).build();
        }
    }
    
    @DELETE
    public Response logout() {
        System.out.println("logout");
        this.userSession.end();
        return Response.ok().build();
    }
}
