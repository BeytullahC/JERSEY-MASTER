package client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import model.User;

import java.util.List;

/**
 * Created by BeytullahC on 6/3/2015.
 */
public class Tester {

    public static void main(String[] argv) {

        Client client = Client.create();

        String myUrl = "http://localhost:8080/rest/helloworld/user";
        WebResource wr = client.resource(myUrl);
        User resp = wr.accept("application/json").post(User.class, new User("T", "beytullah ç"));
        System.out.println(resp);

        String myUrl2 = "http://localhost:8080/rest/helloworld/users";
        wr = client.resource(myUrl2);
        List<User> response = wr.accept("application/json").post(new GenericType<List<User>>() {});
        System.out.println(response);

    }

}
