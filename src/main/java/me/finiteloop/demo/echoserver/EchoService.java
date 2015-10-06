/**
 * 
 */
package me.finiteloop.demo.echoserver;

/**
 * 
 */

import java.io.IOException;
import java.util.Properties;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 * @author klimaye
 *
 */
@Path("/echo")
public class EchoService {

	Properties properties = null;

	public EchoService() throws IOException{
	}
	
	
	@GET
	@Path("/{message}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response echoMessage(@PathParam("message") String message) {

		ResponseBuilder builder = null;
		StringBuffer buffer = new StringBuffer("|");
				buffer.append(message);
				buffer.append("|");
				buffer.append(" from Echo Service on OpenShift!");
				
		builder = Response.ok();
		builder.entity(buffer.toString());

		return builder.build();
	}

}