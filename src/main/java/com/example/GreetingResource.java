package com.example;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/api")
public class GreetingResource {

	@Inject
	GreetingService greetingService;

	@Inject
	@RestClient
	WorldClockService worldClockService;

	@GET
	@Path("hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "Hello RESTEasy";
	}

	@GET
	@Path("greeting/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String greeting(@PathParam String name) {
		return greetingService.greeting(name);
	}

	@GET
	@Path("now")
	@Produces(MediaType.TEXT_PLAIN)
	public String now() {
		return worldClockService.getNow().getCurrentDateTime();
	}

}
