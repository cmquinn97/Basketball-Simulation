import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class game {

	static stats stats = new stats();
	players players = new players();

	public static void main(String[] args) {
		teams teams = new teams();
		Team t1 = null;
		Team t2 = null;
		String[] winners = new String[3];

		// Pick playoffs or one series
		@SuppressWarnings("resource")
		Scanner kb = new Scanner(System.in);
		System.out.println("Playoffs (P) or one game series (O)?");
		String simulate = kb.next().toLowerCase();

		// playoffs
		if (simulate.equals("p")) {
			int round = 0;
			while (round < 3) {
				if (round == 0) {
					t1 = teams.Cavs;
					t2 = teams.Heat;
				}
				if (round == 1) {
					t1 = teams.Clippers;
					t2 = teams.Warriors;
				}
				if (round == 2) {					
					if (winners[1].equals("Cleveland Cavs")) {
						t1 = teams.Cavs;
					} else {
						t1 = teams.Heat;
					}
					if (winners[2].equals("GS Warriors")) {
						t2 = teams.Warriors;
					} else {
						t2 = teams.Clippers;
					}
				}
				// game is simulated
				boolean running = true;
				int t1Wins = 0;
				int t2Wins = 0;
				while (t1Wins < 4 && t2Wins < 4) {
					running = true;
					int i = 0;
					while (i < 475) {
						int shooter = randInt(1, 100);
						if (shooter < 31) {
							if (i % 2 == 0) {// team 1 shooting
								twoPoint(t1.p1, t2.p1, t1);
								threePoint(t1.p1, t2.p1, t1);
							} else {// team 2 shooting
								twoPoint(t2.p1, t1.p1, t2);
								threePoint(t2.p1, t1.p1, t2);
							}

							i++;
						}
						if (shooter > 30 && shooter < 51) {
							if (i % 2 == 0) {// team 1 shooting
								twoPoint(t1.p2, t2.p2, t1);
								threePoint(t1.p2, t2.p2, t1);
							} else {// team 2 shooting
								twoPoint(t2.p2, t1.p2, t2);
								threePoint(t2.p2, t1.p2, t2);
							}

							i++;
						}
						if (shooter > 50 && shooter < 69) {
							if (i % 2 == 0) {// team 1 shooting
								twoPoint(t1.p3, t2.p3, t1);
								threePoint(t1.p3, t2.p3, t1);
							} else {// team 2 shooting
								twoPoint(t2.p3, t1.p3, t2);
								threePoint(t2.p3, t1.p3, t2);
							}

							i++;
						}
						if (shooter > 68 && shooter < 86) {
							if (i % 2 == 0) {// team 1 shooting
								twoPoint(t1.p4, t2.p4, t1);
								threePoint(t1.p4, t2.p4, t1);
							} else {// team 2 shooting
								twoPoint(t2.p4, t1.p4, t2);
								threePoint(t2.p4, t1.p4, t2);
							}

							i++;
						}
						if (shooter > 85) {
							if (i % 2 == 0) {// team 1 shooting
								twoPoint(t1.p5, t2.p5, t1);
								threePoint(t1.p5, t2.p5, t1);
							} else {// team 2 shooting
								twoPoint(t2.p5, t1.p5, t2);
								threePoint(t2.p5, t1.p5, t2);
							}

							i++;
						}
					}

					System.out.println(t1.getName() + " " + t1.stats.score());
					System.out.println(t2.getName() + " " + t2.stats.score() + "\n");

					if (t1.stats.score() > t2.stats.score) {
						t1Wins++;
					} else {
						t2Wins++;
					}
					System.out.println(t1.getName() + " wins: " + t1Wins);
					System.out.println(t2.getName() + " wins: " + t2Wins);

					// asks if you would like to see stats
					while (running) {
						System.out.println("N - " + t1.getName() + " Stats \n" + "H - " + t2.getName() + " Stats \n"
								+ "Q - Quit/Next Game(Out of 7)");
						String choice = kb.next().toLowerCase();
						if (choice.equals("h")) {
							playerStats(t2);
						}
						if (choice.equals("n")) {
							playerStats(t1);
						}
						if (choice.equals("q")) {
							running = false;
							stats.clearStats(t2);
							stats.clearStats(t1);
						} // declares winner
						if (t1Wins == 4) {
							System.out.println(t1.getName() + " won the series");
							if(round<2){
								round++;
								t1.wins++;
								winners[round] = t1.name;
							}else{System.exit(0);}

						} else if (t2Wins == 4) {
							System.out.println(t2.getName() + " won the series");
							if(round<2){
								round++;
								t2.wins++;
								winners[round] = t2.name;
							}else{System.exit(0);}
						}
					}

				}
			}
		}

		// one series
		if (simulate.equals("o")) {
			System.out.println("Team 1 (Cavs, Nuggets, Heat, Warriors, Raptors, Clippers): ");
			String team1 = kb.next().toLowerCase();
			if (team1.equals("cavs")) {
				t1 = teams.Cavs;
			}
			if (team1.equals("heat")) {
				t1 = teams.Heat;
			}
			if (team1.equals("nuggets")) {
				t1 = teams.Nuggets;
			}
			if (team1.equals("warriors")) {
				t1 = teams.Warriors;
			}
			if (team1.equals("raptors")) {
				t1 = teams.Raptors;
			}
			if (team1.equals("clippers")) {
				t1 = teams.Clippers;
			}
			System.out.println("Team 2 (Cavs, Nuggets, Heat, Warriors, Raptors): ");
			String team2 = kb.next().toLowerCase();
			if (team2.equals("cavs")) {
				t2 = teams.Cavs;
			}
			if (team2.equals("heat")) {
				t2 = teams.Heat;
			}
			if (team2.equals("nuggets")) {
				t2 = teams.Nuggets;
			}
			if (team2.equals("warriors")) {
				t2 = teams.Warriors;
			}
			if (team2.equals("raptors")) {
				t2 = teams.Raptors;
			}
			if (team2.equals("clippers")) {
				t2 = teams.Clippers;
			}
			simulate(t1, t2);
		}

	}
	

	//algorithm to simulate for one series, does not work for playoffs.
	public static void simulate(Team t1, Team t2){
		// game is simulated
					boolean running = true;
					int t1Wins = 0;
					int t2Wins = 0;
					while (t1Wins < 4 && t2Wins < 4) {
						running = true;
						int i = 0;
						while (i < 475) {
							int shooter = randInt(1, 100);
							if (shooter < 31) {
								if (i % 2 == 0) {// team 1 shooting
									twoPoint(t1.p1, t2.p1, t1);
									threePoint(t1.p1, t2.p1, t1);
								} else {// team 2 shooting
									twoPoint(t2.p1, t1.p1, t2);
									threePoint(t2.p1, t1.p1, t2);
								}

								i++;
							}
							if (shooter > 30 && shooter < 51) {
								if (i % 2 == 0) {// team 1 shooting
									twoPoint(t1.p2, t2.p2, t1);
									threePoint(t1.p2, t2.p2, t1);
								} else {// team 2 shooting
									twoPoint(t2.p2, t1.p2, t2);
									threePoint(t2.p2, t1.p2, t2);
								}

								i++;
							}
							if (shooter > 50 && shooter < 69) {
								if (i % 2 == 0) {// team 1 shooting
									twoPoint(t1.p3, t2.p3, t1);
									threePoint(t1.p3, t2.p3, t1);
								} else {// team 2 shooting
									twoPoint(t2.p3, t1.p3, t2);
									threePoint(t2.p3, t1.p3, t2);
								}

								i++;
							}
							if (shooter > 68 && shooter < 86) {
								if (i % 2 == 0) {// team 1 shooting
									twoPoint(t1.p4, t2.p4, t1);
									threePoint(t1.p4, t2.p4, t1);
								} else {// team 2 shooting
									twoPoint(t2.p4, t1.p4, t2);
									threePoint(t2.p4, t1.p4, t2);
								}

								i++;
							}
							if (shooter > 85) {
								if (i % 2 == 0) {// team 1 shooting
									twoPoint(t1.p5, t2.p5, t1);
									threePoint(t1.p5, t2.p5, t1);
								} else {// team 2 shooting
									twoPoint(t2.p5, t1.p5, t2);
									threePoint(t2.p5, t1.p5, t2);
								}

								i++;
							}
						}

						System.out.println(t1.getName() + " " + t1.stats.score());
						System.out.println(t2.getName() + " " + t2.stats.score() + "\n");

						if (t1.stats.score() > t2.stats.score) {
							t1Wins++;
						} else {
							t2Wins++;
						}
						System.out.println(t1.getName() + " wins: " + t1Wins);
						System.out.println(t2.getName() + " wins: " + t2Wins);

						// asks if you would like to see stats
						@SuppressWarnings("resource")
						Scanner kb = new Scanner(System.in);
						while (running) {
							System.out.println("N - " + t1.getName() + " Stats \n" + "H - " + t2.getName() + " Stats \n"
									+ "Q - Quit/Next Game(Out of 7)");
							String choice = kb.next().toLowerCase();
							if (choice.equals("h")) {
								playerStats(t2);
							}
							if (choice.equals("n")) {
								playerStats(t1);
							}
							if (choice.equals("q")) {
								running = false;
								stats.clearStats(t2);
								stats.clearStats(t1);
							} // declares winner
							if (t1Wins == 4) {
								System.out.println(t1.getName() + " won the series");
							} else if (t2Wins == 4) {
								System.out.println(t2.getName() + " won the series");
							}
						}

					}
	}
	// Displays stats for each player on selected team
	public static void playerStats(Team team) {
		System.out.println(team.p1.getName() + ": " + team.p1.stats.score() + " points (" + team.p1.stats.threes
				+ " three pointers)");
		System.out.println(team.p2.getName() + ": " + team.p2.stats.score() + " points (" + team.p2.stats.threes
				+ " three pointers)");
		System.out.println(team.p3.getName() + ": " + team.p3.stats.score() + " points (" + team.p3.stats.threes
				+ " three pointers)");
		System.out.println(team.p4.getName() + ": " + team.p4.stats.score() + " points (" + team.p4.stats.threes
				+ " three pointers)");
		System.out.println(team.p5.getName() + ": " + team.p5.stats.score() + " points (" + team.p5.stats.threes
				+ " three pointers)");
	}

	// odds of shooting and making a 2 point shot
	public static void twoPoint(Player offense, Player defense, Team team) {
		int shot = randInt(1, 100);
		int chance = randInt(1, 100);
		if (shot < 85 && chance < offense.twoPt() && randInt(1, 100) > defense.defense) {
			offense.stats.addScore(2);
			team.stats.addScore(2);
		}
	}

	// odds of shooting and making a 3 point shot
	public static void threePoint(Player offense, Player defense, Team team) {
		int shot = randInt(1, 100);
		int chance = randInt(1, 100);
		if (shot > 85 && chance < offense.threePt() && randInt(1, 100) > defense.defense()) {
			offense.stats.addScore(3);
			offense.stats.addThree(1);
			team.stats.addScore(3);
		}
	}

	// creates a random number
	public static int randInt(int min, int max) {
		Random rand = new Random();

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;

		return randomNum;
	}
}
