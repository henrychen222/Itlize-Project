package com.easylearn;

import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;


@Path("/welcome")
public class WelcomeMessageService {

	@GET
	@Path("/html/{param}")
	@Produces("text/html")
	public Response getWelcomeMessageHTML(@PathParam("param") String user) {

		String output = " <h1> <center> Welcome to Jersy RESTFul web services : " + user +" </center> </h1>";
		System.out.println(user);
		return Response.status(200).entity(output).build();

	}
	
	@GET
	@Path("/xml/{param}")
	@Produces("text/xml")
	public Response getWelcomeMessageXML(@PathParam("param") String user) {

		String output = " <h1> <center> Welcome to Jersy RESTFul web services : " + user +" </center> </h1>";

		return Response.status(200).entity(output).build();

	}
	
	@GET
	@Path("/text/{param}")
	@Produces("text/plain")
	public Response getWelcomeMessageTEXT(@PathParam("param") String user) {

		String output = " <h1> <center> Welcome to Jersy RESTFul web services : " + user +" </center> </h1>";

		return Response.status(200).entity(output).build();

	}
	
	@GET
	@Path("/json/{param}")
	@Produces("text/json")
	public Response getWelcomeMessageJSON(@PathParam("param") String user) {

		String output = " {\"menu\": { \"id\": \"file\",\"value\": \"File\",\"popup\": { \"menuitem\": [ {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},{\"value\": \"Open\", \"onclick\": \"OpenDoc()\"}, {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"} ] }}}";

		return Response.status(200).entity(output).build();

	}


}
