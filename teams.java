public class teams {

	players players = new players();
	//creating teams
	Team Heat = new Team("Miami Heat", players.Hassan, players.Dragic, players.Winslow, players.Richardson,
			players.Johnson);
	Team Nuggets = new Team("Denver Nuggets", players.Mudiay, players.Jokic, players.Chandler, players.Nurkic,
			players.Murray);
	Team Cavs = new Team("Cleveland Cavs", players.LeBron, players.Kyrie, players.Love, players.Smith,
			players.Thompson);
	Team Warriors = new Team("GS Warriors", players.Curry, players.Durant, players.Klay, players.Green, players.Pachullia);
	Team Clippers = new Team("LA Clippers", players.Paul, players.Griffin, players.Jordan, players.Reddick, players.Crawford);
	Team Raptors = new Team("Toronto Raptors", players.Derozan, players.Lowry, players.Valencunias, players.Carrol, players.Joseph);
}

