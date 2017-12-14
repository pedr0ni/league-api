package br.com.mpedroni.leagueapi.player;

import java.io.IOException;

import br.com.mpedroni.leagueapi.core.API;
import br.com.mpedroni.leagueapi.core.Region;
import br.com.mpedroni.leagueapi.core.URLCatcher;
import br.com.mpedroni.leagueapi.json.JSONObject;

public class Player {
	
	private Region region;
	private String name;
	private boolean isFetched;
	
	private JSONObject object_basic;
	private RankedQueue queue;

	public Player(String name, Region region) {
		this.name = name;
		this.region = region;
		this.isFetched = false;
	}
	
	public void fetch() throws IOException {
		String response = new URLCatcher("https://"+region.toString().toLowerCase()+".api.riotgames.com/lol/summoner/v3/summoners/by-name/"+this.name+"?api_key="+API.API_KEY).fetch();
		this.object_basic = new JSONObject(response);
		this.isFetched = true;
	}
	
	
	
	public int getProfileIconId() {
		return this.object_basic.getInt("profileIconId");
	}
	
	public String getName() {
		return this.object_basic.getString("name");
	}
	
	public long getSummonerLevel() {
		return this.object_basic.getLong("summonerLevel");
	}
	
	public long getAccountId() {
		return this.object_basic.getLong("accountId");
	}
	
	public long getId() {
		return this.object_basic.getLong("id");
	}
	
	public long getRevisionDate() {
		return this.object_basic.getLong("revisionDate");
	}
	
	public Region getRegion() {
		return this.region;
	}
	
	public boolean isFetched() {
		return this.isFetched;
	}
	
	public RankedQueue getRankedQueue() {
		if (this.queue == null) {
			this.queue = new RankedQueue(this);
		}
		return this.queue;
	}

}
