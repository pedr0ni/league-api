package br.com.mpedroni.leagueapi;

import java.io.IOException;

import br.com.mpedroni.leagueapi.core.Region;
import br.com.mpedroni.leagueapi.player.Player;

public class Main {

	public static void main(String[] args) {
		Player p = new Player("Pedronisz", Region.BR1);
		try {
			p.fetchBasic();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(p.getSummonerLevel());
	}

}
