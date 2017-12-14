package br.com.mpedroni.leagueapi;

import java.io.IOException;

import br.com.mpedroni.leagueapi.core.Region;
import br.com.mpedroni.leagueapi.player.Player;
import br.com.mpedroni.leagueapi.player.RankedQueue;

public class Main {

	public static void main(String[] args) {
		Player p = new Player("Pedronisz", Region.BR1);
		RankedQueue queue = p.getRankedQueue();
		try {
			p.fetch();
			queue.fetch();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println(queue.getTier());
		System.out.println(queue.getDivision());
		System.out.println(queue.getWins());
	}

}
