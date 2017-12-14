# League-API

API feita em Java para o League of Legends.

## Iniciando

Você precisa de uma conta no jogo League of Legends para adquirir uma chave de API.

## Exemplos

```
Player p = new Player("Pedronisz", Region.BR1);
try {
  p.fetchBasic();
	} catch (IOException e) {
	  e.printStackTrace();
	}
System.out.println(p.getSummonerLevel());
```

## Build

* [Java](https://www.java.com/pt_BR/)
* [Riot Games API](https://developer.riotgames.com/)

## Autor

* **Matheus Pedroni** - [Pedr0ni](https://github.com/Pedr0ni)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
