package com.geowarin.rest;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/authentication")
public class AuthenticationResource {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response authenticateUser(@FormParam("username") String username, 
            @FormParam("password") String password) {
    	
//    	String username = credentials.getUsername();
//        String password = credentials.getPassword();

        try {
     
            // Authenticate the user using the credentials provided
            authenticate(username, password);

            // Issue a token for the user
            String token = issueToken(username);

            // Return the token on the response
            return Response.ok(token).build();

        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }      
    }

    private void authenticate(String username, String password) throws Exception {
    	if (Credentials.username.equals(username) && Credentials.password.equals(password)) {
    		// Authenticated
    	} else {
    		throw new NotAuthorizedException("Username or Password do not match.");
    	}
        // Authenticate against a database, LDAP, file or whatever
        // Throw an Exception if the credentials are invalid
    }

    private String issueToken(String username) {
    	Random random = new SecureRandom();
    	String token = new BigInteger(130, random).toString(32);
    	
    	Credentials.token = token;
    	
		return "Bearer " + token;
        // Issue a token (can be a random String persisted to a database or a JWT token)
        // The issued token must be associated to a user
        // Return the issued token
    }
}
