package com.Rest.Api.HTTPCLIENT;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;

public class HttpGetMethod {

	
	
	
	
	@Test
	public void HttpGetRequest() {
		CloseableHttpResponse response =null;
	
		CloseableHttpClient httpclient=HttpClientBuilder.create().build();
		//1.create a get request with url:
		HttpGet getrequest = new HttpGet("https://gorest.co.in/public/v2/users?name=kamal&status=inactive");
		
		//2 .add header
		getrequest.addHeader("Authorization","Bearer 7ed0d7f31bc21caed71d3b3ece46fa2dd5a94208ef6215d5eec2b913c71a85a4");
		
		//3.execute the api
		try {
			response=httpclient.execute(getrequest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	int statuscode=	response.getStatusLine().getStatusCode();
	System.out.println(statuscode);
		
	}
	
	
	
}
