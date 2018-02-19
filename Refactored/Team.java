
public class Team {

	stats stats=new stats();
	String name;
	players players = new players();
	Player p1, p2, p3, p4, p5;
	int score;
	int wins = 0;
	//what a team will consist of
	public Team(String name, Player p1, Player p2, Player p3, Player p4, Player p5){
		this.name=name;
		this.p1=p1;
		this.p2=p2;
		this.p3=p3;
		this.p4=p4;
		this.p5=p5;
	}
	
	public String getName(){
		return name;
	}
	
	
	
}
