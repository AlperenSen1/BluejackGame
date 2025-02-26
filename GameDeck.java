public class GameDeck{
	private int number;
	private String colour;
	
	public GameDeck(int a, String b){
		setNumber(a);
		setColour(b);
	}
	public void setNumber(int a){
	number=a;
	}
	public void setColour(String a){
	colour=a;
	}
	public int getNumber(){
		return number;
	}
	public String getColour(){
		return colour;
	}
	public void print(GameDeck a){
		System.out.println(a.getNumber());
		System.out.println(a.getColour());
	}
}