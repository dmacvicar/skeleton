package demo;

import org.rapidoid.annotation.Controller;
import org.rapidoid.annotation.GET;
import org.rapidoid.security.Role;
import org.rapidoid.security.annotation.Administrator;
import org.rapidoid.security.annotation.Roles;

@Controller
public class MyController {
    @GET
    @Administrator
    @Roles({"manager", Role.MODERATOR})
    public Object hi() {

        return "hi";
    }
}
