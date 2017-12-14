package br.com.mpedroni.leagueapi.player;

import java.io.IOException;

import br.com.mpedroni.leagueapi.core.API;
import br.com.mpedroni.leagueapi.core.URLCatcher;
import br.com.mpedroni.leagueapi.json.JSONArray;
import br.com.mpedroni.leagueapi.json.JSONObject;

public class RankedQueue {
	
	private Player player;
	private JSONObject object_ranked;
	private JSONObject object_queue;

	public RankedQueue(Player player) {
		this.player = player;
	}
	
	public void fetch() throws IOException {
		String response = new URLCatcher("https://"+this.player.getRegion().toString().toLowerCase()+".api.riotgames.com/lol/league/v3/leagues/by-summoner/"+this.player.getId()+"?api_key="+API.API_KEY).fetch();
		this.object_ranked = new JSONArray(response).getJSONObject(0);
		
		JSONArray entries = this.object_ranked.getJSONArray("entries");
		for (int i = 0; i < entries.length(); i++) {
			JSONObject entries_obj = entries.getJSONObject(i);
			if (entries_obj.getLong("playerOrTeamId") == this.player.getId()) {
				this.object_queue = entries_obj;
				break;
			}
		}
	}
	
	public String getTier() {
		return this.object_ranked.getString("tier");
	}
	
	public String getQueueName() {
		return this.object_ranked.getString("name");
	}
	
	public int getWins() {
		return this.object_queue.getInt("wins");
	}
	
	public int getLosses() {
		return this.object_queue.getInt("losses");
	}
	
	public boolean isVeteran() {
		return this.object_queue.getBoolean("veteran");
	}
	
	public boolean isInactive() {
		return this.object_queue.getBoolean("inactive");
	}
	
	public String getDivision() {
		return this.object_queue.getString("rank");
	}
	
	public int getLeaguePoints() {
		return this.object_queue.getInt("leaguePoints");
	}
	
	public boolean inHotStreak() {
		return this.object_queue.getBoolean("hotStreak");
	}
	
	public Player getPlayer() {
		return this.player;
	}

}
