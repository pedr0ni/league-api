package br.com.mpedroni.leagueapi.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLCatcher {
	
	private String url;

	public URLCatcher(String url) {
		this.url = url;
	}
	
	public String fetch() throws IOException {
		URL website = new URL(this.url);
	    URLConnection connection = website.openConnection();
	    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

	    StringBuilder response = new StringBuilder();
	    String inputLine;

	    while ((inputLine = in.readLine()) != null) 
	    	response.append(inputLine);

	    in.close();

	    return response.toString();
	}

}
