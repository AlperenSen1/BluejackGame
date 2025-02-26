import java.util.Random;
public class Deste{
	public static void main (String[]args){
		GameDeck[] deckGame=new GameDeck[40];/////////////GAMEDECK YARATIR
		int a=1;
		int b=1;
		int c=1;
		for(int i=0;i<10;i++){
			deckGame[i]=new GameDeck((i+1),"Blue");
		}
		for(int i=10;i<20;i++){
			deckGame[i]=new GameDeck(a,"Red");
			a++;
		}
		for(int i=20;i<30;i++){
			deckGame[i]=new GameDeck(b,"Yellow");
			b++;
		}
		for(int i=30;i<40;i++){
			deckGame[i]=new GameDeck(c,"Green");
			c++;
		}
		
		
		
		
		
		
		GameDeck[] deckPlayer1= new GameDeck[48]; ///////////PLAYERDECKTE 3 RANDOM ÇEKİLECEK KISMI YARARTIR
		int d=0;
		int e=0;
		int f=0;
		int g=0;
		int h=0;
		int j=0;
		int k=0;
		for(int i=0;i<6;i++){
			deckPlayer1[i]=new GameDeck((i+1),"Blue");
		}
		for(int i=6;i<12;i++){
			deckPlayer1[i]=new GameDeck(-(d+1),"Blue");
			d++;
		}
		for(int i=12;i<18;i++){
			deckPlayer1[i]=new GameDeck((e+1),"Red");
			e++;
		}
		for(int i=18;i<24;i++){
			deckPlayer1[i]=new GameDeck(-(f+1),"Red");
			f++;
		}
		for(int i=24;i<30;i++){
			deckPlayer1[i]=new GameDeck((g+1),"Yellow");
			g++;
		}
		for(int i=30;i<36;i++){
			deckPlayer1[i]=new GameDeck(-(h+1),"Yellow");
			h++;
		}
		for (int i=36;i<42;i++){
			deckPlayer1[i]=new GameDeck((j+1),"Green");
			j++;
		}
		for(int i=42;i<48;i++){
			deckPlayer1[i]=new GameDeck(-(k+1),"Green");
			k++;
		}
		
		
		
		
		Random r=new Random(System.currentTimeMillis());
		GameDeck[]deckPlayer2=new GameDeck[5];//(%20)FLİP BULUNDURAN DESTE YARATIR
		for(int i=0;i<4;i++){
		deckPlayer2[i]=deckPlayer1[r.nextInt(48)];
		}
		deckPlayer2[4]=new GameDeck(0,"+/-");
		
		
		
		Random q=new Random(System.currentTimeMillis());
		GameDeck[]deckPlayer3=new GameDeck[5];//(%20)DOUBLE BULUNDURAN DESTE YARATIR
		for(int i=0;i<4;i++){
			deckPlayer3[i]=deckPlayer1[q.nextInt(48)];
		}
		deckPlayer3[4]=new GameDeck(0,"Double");
		
		
		
		
		Random y=new Random(System.currentTimeMillis());
		GameDeck[]unHandHuman=new GameDeck[10];//TAMAMLANMAMAIŞ İNSAN DESTESİ
		for(int i=0;i<5;i++){
			unHandHuman[i]=deckGame[y.nextInt(40)];
		}
		for(int i=5;i<8;i++){
			unHandHuman[i]=deckPlayer1[y.nextInt(48)];
		}
		unHandHuman[8]=deckPlayer2[y.nextInt(5)];
		unHandHuman[9]=deckPlayer3[y.nextInt(5)];
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		for(int i=0;i<40;i++){
		System.out.println(deckGame[i].getNumber()+","+deckGame[i].getColour());
		}
		for(int i=0;i<48;i++){
			System.out.println(deckPlayer1[i].getNumber()+","+deckPlayer1[i].getColour());
		}
		for(int i=0;i<5;i++){
			System.out.println(deckPlayer2[i].getNumber()+","+deckPlayer2[i].getColour());
		}
		for(int i=0;i<5;i++){
			System.out.println(deckPlayer3[i].getNumber()+","+deckPlayer3[i].getColour());
		}
		for(int i=0;i<10;i++){
			System.out.println(unHandHuman[i].getNumber()+","+unHandHuman[i].getColour());
		}
		
	}
}