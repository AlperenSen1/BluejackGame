import java.util.Random;
import java.util.Scanner;
public class Sumh8{
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
		GameDeck[]deckPlayer3=new GameDeck[5];//(%20)DOUBLE BULUNDURAN DESTE YARATIR
		for(int i=0;i<4;i++){
			deckPlayer3[i]=deckPlayer1[r.nextInt(48)];
		}
		deckPlayer3[4]=new GameDeck(0,"Double");
		GameDeck[]unHandHuman=new GameDeck[10];//TAMAMLANMAMAIŞ İNSAN DESTESİ
		for(int i=0;i<5;i++){
			unHandHuman[i]=deckGame[r.nextInt(40)];
		}
		for(int i=5;i<8;i++){
			unHandHuman[i]=deckPlayer1[r.nextInt(48)];
		}
		unHandHuman[8]=deckPlayer2[r.nextInt(5)];
		unHandHuman[9]=deckPlayer3[r.nextInt(5)];
		
		GameDeck[] humanDeck=new GameDeck[5];    // OYUNA HAZIR İNSAN ELİ
		for(int i=0;i<5;i++){
			humanDeck[i]=unHandHuman[r.nextInt(10)];
		}
		GameDeck[]unHandPC=new GameDeck[10];//TAMAMLANAMAIŞ BİLGİSAYAR ELİ
		for(int i=0;i<5;i++){
			unHandPC[i]=deckGame[r.nextInt(40)];
		}
		for(int i=5;i<8;i++){
			unHandPC[i]=deckPlayer1[r.nextInt(48)];
		}
		unHandPC[8]=deckPlayer2[r.nextInt(5)];
		unHandPC[9]=deckPlayer3[r.nextInt(5)];
		
		GameDeck[] pcDeck=new GameDeck[5];// OYUNA HAZIR PC ELİ
		for(int i=0;i<5;i++){
			pcDeck[i]=unHandPC[r.nextInt(10)];
		}
		
		Scanner sc=new Scanner(System.in);
		int sumHuman=deckGame[r.nextInt(40)].getNumber();
		int sumPC=deckGame[r.nextInt(40)].getNumber();
		int HumanWin=0;
		int PCWin=0;
		//// deckGame/humanDeck/pcDeck/deckPlayer1/deckPlayer2/deckPlayer3
		///////////////////////////////////////////////////OYUNUN OYNANIŞI//////////////////////////////////////////////////////////////////////
		
		while(true){
		System.out.println("Your Desk is = "+sumHuman);
		System.out.println("1-End,2-Stand,3-Use Card");
		int a2=sc.nextInt();
		if(a2==3){
			
				for(int i=0;i<5;i++){
				System.out.println("Card"+ (i+1) + "=" + humanDeck[i].getNumber() + "," + humanDeck[i].getColour());
			}
			System.out.println("Enter card number");
			int b4=sc.nextInt()-1;
		 sumHuman+=fonkSwitchHuman3(b4,a2,sumHuman,humanDeck);
		 GameDeck[]newHumanDeck=setHumanDeck(humanDeck,b4);
		 for(int i=0;i<newHumanDeck.length;i++){
		 humanDeck[i]=newHumanDeck[i];
		 }
		}
		if(a2==2){
			sumPC+=fonkSwitchPC2(sumPC,pcDeck);
			if(sumPC<sumHuman){
			System.out.println("Your desk is"+sumHuman);
			System.out.println("PC desk is"+sumPC);
			System.out.println("Human won this hand");
			HumanWin++;
			System.out.println("Human="+HumanWin+"   "+"PC="+PCWin);
			sumHuman=deckGame[r.nextInt(40)].getNumber();
			sumPC=deckGame[r.nextInt(40)].getNumber();
			if(HumanWin==3){
				System.out.println("WİNNER İS HUMAN");
				break;
			}
	         continue;
			}else{
				System.out.println("Your desk is"+sumHuman);
			    System.out.println("PC desk is"+sumPC);
			    System.out.println("PC won this hand");
				PCWin++;
				System.out.println("Human="+HumanWin+"   "+"PC="+PCWin);
			    sumHuman=deckGame[r.nextInt(40)].getNumber();
			    sumPC=deckGame[r.nextInt(40)].getNumber();
				if(PCWin==3){
				System.out.println("WİNNER İS PC");
				break;
			}
				continue;
			}
		}
		sumHuman+=fonkSwitchHuman(a2,sumHuman,humanDeck);
		if(sumHuman>20){
			System.out.println("PC won this hand");
			PCWin++;
			System.out.println("Human="+HumanWin+"   "+"PC="+PCWin);
			sumHuman=deckGame[r.nextInt(40)].getNumber();
			if(PCWin==3){
				System.out.println("WİNNER İS PC");
				break;
			}
			continue;
		}
		int a3=r.nextInt(4);
		if(a3==2){
			System.out.println("PC İS= "+sumPC);
			sumHuman+=fonkSwitchHuman2(sumHuman,humanDeck);
			if(sumHuman>sumPC){
				System.out.println("PC İS="+sumPC);
				System.out.println("Human is="+sumHuman);
				System.out.println("Human won this hand");
				HumanWin++;
				System.out.println("Human="+HumanWin+"   "+"PC="+PCWin);
				sumHuman=deckGame[r.nextInt(40)].getNumber();
			    sumPC=deckGame[r.nextInt(40)].getNumber();
			if(HumanWin==3){
				System.out.println("WİNNER İS HUMAN");
				break;
			}
				continue;
				
		    }else{
				System.out.println("PC İS="+sumPC);
				System.out.println("Human is="+sumHuman);
				System.out.println("PC won this hand");
				PCWin++;
				System.out.println("Human="+HumanWin+"   "+"PC="+PCWin);
				sumHuman=deckGame[r.nextInt(40)].getNumber();
			    sumPC=deckGame[r.nextInt(40)].getNumber();
				if(PCWin==3){
				System.out.println("WİNNER İS PC");
				break;
			}
			continue;
				
		  }
		}
		  
		  
		sumPC+=fonkSwitchPC(a3,sumPC,pcDeck);
		System.out.println("PC desk= "+sumPC);
		if(sumPC>20){
			System.out.println("Human won this hand");
			HumanWin++;
			System.out.println("Human="+HumanWin+"   "+"PC="+PCWin);
			sumPC=deckGame[r.nextInt(40)].getNumber();
			if(HumanWin==3){
				System.out.println("WİNNER İS HUMAN");
				break;
			}
			continue;
		}
		}
		
		
	}
	
	///////////////////////////////////////////////////////FONKSİYONLAR////////////////////////////////////////////////////////////////////////
	public static int fonkSwitchHuman(int a,int c,GameDeck[]arr){
		Scanner sc=new Scanner(System.in);
		int d=0;
		switch(a){
			case 1:
			d=0;
			
			break;
			case 2:
			d=0;
			
			break;
			case 3:
			for(int i=0;i<5;i++){
				System.out.println("Card"+ (i+1) + "=" + arr[i].getNumber() + "," + arr[i].getColour());
			}
			System.out.println("Enter card number");
			int b=sc.nextInt()-1;
			d=arr[b].getNumber();
		}
		return d;
	}
	
	public static int fonkSwitchHuman3(int b, int a,int c,GameDeck[]arr){
		Scanner sc=new Scanner(System.in);
		int d=0;
		switch(a){
			case 1:
			d=0;
			
			break;
			case 2:
			d=0;
			
			break;
			case 3:
			d=arr[b].getNumber();
		}
		return d;
	}
	
	public static GameDeck[] setHumanDeck(GameDeck[]firstDeck,int e ){
		GameDeck[]newArr=new GameDeck[firstDeck.length-1];
		System.arraycopy(firstDeck,0,newArr,0,e);
		System.arraycopy(firstDeck,e+1,newArr,e,firstDeck.length-e-1);
		return newArr;
	}
	
	
	public static int fonkSwitchPC(int a, int c,GameDeck[]arr){
		Random r=new Random(System.currentTimeMillis());
		int d=0;
		switch(a){
			case 1:
			d=0;
			
			break;
			case 2:
			d=0;
			
			break;
			case 3:
			int b=r.nextInt(5);
			d=arr[b].getNumber();
		}
		return d;
	}
	
	public static int fonkSwitchPC2(int c,GameDeck[]arr){
		Random r=new Random(System.currentTimeMillis());
		int a=r.nextInt(2)+1;
		int d=c;
		switch(a){
			case 1:
			d=0;
			
			break;
		
			case 2:
			int b=r.nextInt(5);
			d=arr[b].getNumber();
		}
		return d;
	}
	
	public static int fonkSwitchHuman2(int c,GameDeck[]arr){
		Scanner sc=new Scanner(System.in);
		System.out.println("Your Desk is = "+c);
		System.out.println("1-End,2-Use Card");
		int a=sc.nextInt();
		int d=0;
		switch(a){
			case 1:
			d=0;
			
			break;
			
			case 2:
			for(int i=0;i<5;i++){
				System.out.println("Card"+ (i+1) + "=" + arr[i].getNumber() + "," + arr[i].getColour());
			}
			System.out.println("Enter card number");
			int b=sc.nextInt()-1;
			d=arr[b].getNumber();
		}
		return d;
	}
}