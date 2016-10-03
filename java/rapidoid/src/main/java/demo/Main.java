package demo;

import org.rapidoid.setup.My;
import org.rapidoid.setup.On;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashSet;

public class Main
{
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);
    public static void main( String[] args )
    {
        org.rapidoid.setup.App.bootstrap()
                .adminCenter()
                .auth();

        On.get("/").html((req, resp) -> "this is public!");
        On.get("/manage").roles("manager").html((req, resp) -> "this is private!");

        My.loginProvider((req, username, password) -> username.equals(password));
        My.rolesProvider((req, username) -> new HashSet<String>(Arrays.asList("administrator")));


        LOG.debug("Starting ...");
        //On.port(8888);
        //On.get("/x").json("x");
    }
}