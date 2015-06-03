package rest;

import com.sun.net.httpserver.HttpServer;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by BeytullahC on 6/3/2015.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/helloworld")
public class HelloRESTful {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces(MediaType.TEXT_PLAIN)
    public String getClichedMessage() {
        // Return some cliched textual content
        return "Hello World";
    }

    @GET
    @Path(value = "/TEST")
    @Produces(MediaType.TEXT_PLAIN)
    public String test(){
        return "test ok";
    }

    @GET
    @Path("/name/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getName(@PathParam("name")String name){
        return "hello "+name;

    }

    @GET
    @Path("/user/{name}/{surname}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public User getUser(@PathParam("name")String name,@PathParam("surname")String surname){
        return new User(name,surname);
    }

    @GET
    @Path("/name")
    @Produces(MediaType.TEXT_PLAIN)
    public String getNameByQuery(@QueryParam("name")String name){
        return "hello "+name;
    }

    @GET
    @Path("/user")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public User getUserByQueryParam(@QueryParam("name")String name,@QueryParam("surname")String surname){
        return new User(name,surname);
    }

    @PUT
    @Path("/user")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public User putUserBy( User user){
        return user;
    }

    @POST
    @Path("/user")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public User putUserUsingPost( User user){
        return user;
    }

    @POST
    @Path("/users")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public List<User> getAllUserUsingPost(){
        List<User> user= new ArrayList<User>();
        user.add(new User("BEYTULLAH","C"));
        user.add(new User("ILYAS","ÇANKAYA"));
        user.add(new User("HANEFİ","ÇETİNKAYA"));
        return user;
    }

}
