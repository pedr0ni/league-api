package br.com.mpedroni.leagueapi.player;

import java.io.IOException;

import br.com.mpedroni.leagueapi.core.API;
import br.com.mpedroni.leagueapi.core.Region;
import br.com.mpedroni.leagueapi.core.URLCatcher;
import br.com.mpedroni.leagueapi.json.JSONObject;

public class Player {
	
	private Region region;
	
	private String request;
	private JSONObject object;

	public Player(String name, Region region) {
		this.region = region;
		
		this.request = "https://"+region.toString().toLowerCase()+".api.riotgames.com/lol/summoner/v3/summoners/by-name/"+name+"?api_key="+API.API_KEY;
	}
	
	public void fetchBasic() throws IOException {
		String response = new URLCatcher(this.request).fetch();
		this.object = new JSONObject(response);
	}
	
	public int getProfileIconId() {
		return this.object.getInt("profileIconId");
	}
	
	public String getName() {
		return this.object.getString("name");
	}
	
	public int getSummonerLevel() {
		return this.object.getInt("summonerLevel");
	}
	
	public int getAccountId() {
		return this.object.getInt("accountId");
	}
	
	public int getId() {
		return this.object.getInt("id");
	}
	
	public long getRevisionDate() {
		return this.object.getLong("revisionDate");
	}
	
	public Region getRegion() {
		return this.region;
	}

}
