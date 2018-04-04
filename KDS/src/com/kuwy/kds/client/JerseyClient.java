package com.kuwy.kds.client;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class JerseyClient {
	private Client client = null;
	private WebTarget target = null;
	private static JerseyClient instance = new JerseyClient();

	public static JerseyClient getInstance() {
		return instance;
	}

	public JerseyClient() {
		client = ClientBuilder.newClient();
		// target = client.target(baseUri).register(new LoggingFilter());
	}

	public void reloadUri(String baseUri) {

	}

	public String postRequest(String baseUri, String json) throws Exception {

		//System.out.println("[" + baseUri + "]URL: Json=>" + json);

		target = client.target(baseUri);
		Response response = target.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(json, MediaType.APPLICATION_JSON),
						Response.class);
		String result = response.readEntity(String.class);
		System.out.println("[" + baseUri + "] Response for URL: Response:"
			+ result);
		
		response.close();
		return result;
	}

	public static String getPinDetails(String pin) throws Exception {

		String response = null;
		try {
			Client client = ClientBuilder.newClient();
			WebTarget target = client.target("http://postalpincode.in/api/pincode/"+pin);
			response = target.request().get(String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public static String getRequest(String dealer) throws Exception{
		// TODO Auto-generated method stub
		String response = null;
		
		try {
			Client client = ClientBuilder.newClient();
			WebTarget target = client.target("http://192.168.1.12:9080/DEALER_SIGNUP/servlet/fetchRegDetails");
			response = target.request().get(String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}
	
}