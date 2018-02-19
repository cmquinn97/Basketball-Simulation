
public class Player {
	int three, two, defense, score;
	String name;
	stats stats=new stats();

	//ratings considered when creating a player
	public Player(String name, int two, int three, int defense){
		this.three=three;
		this.two=two;
		this.defense=defense;
		this.name=name;
	}
	
	int threePt(){
		return three;
	}
	int twoPt(){
		return two;
	}
	int defense(){
		return defense;
	}
	String getName(){
		return name;
	}
	
}
