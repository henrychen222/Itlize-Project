package com.easylearn;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * JersyRESTClient
 *
 */
public class JersyRESTClient {
	public static void main(String[] args) {

		Client client = Client.create();

		WebResource resource = client.resource("http://localhost:8080/REST_JersyFramework_Project/rest/welcome/json/Edward");

		ClientResponse response = resource.accept("text/json").get(ClientResponse.class);

		String output = response.getEntity(String.class);

		System.out.println("Output is received successfully from server...");

		System.out.println(output);

	}
}
