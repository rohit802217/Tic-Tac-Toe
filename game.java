package project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class project {
	static ArrayList<Integer>playerpositions=new ArrayList<Integer>();
	static ArrayList<Integer>cpupositions=new ArrayList<Integer>();



	public static void main(String[] args) {
		char[][]gameBord= {{' ','|', ' ','|',' '},
				           {'-','+', '+','+','-'},
				           {' ','|', ' ','|',' '},
			              {'-','+', '-','+','-'},
				            {' ','|', ' ','|',' '}};

		while(true) {
			Scanner sc=new Scanner (System.in);
			System.out.println("enter your plaement (1-9)");
			int playerpos=sc.nextInt();
			System.out.println(playerpos);
			placepiece(gameBord ,playerpos ,"player");
			Random rand=new Random();
			int cpupos=rand.nextInt(9)+1;
			placepiece(gameBord ,cpupos ,"cpu");
			printGameBord(gameBord); 
			String result=  checkwinner();
			System.out.println(result);
		}
	}
	public static void printGameBord(char[][] gameBord) {
		for(char[]row:gameBord) {
			for(char c:row) {
				System.out.print(c);
			}
			System.out.println();

		}

	}
	public static void placepiece(char[][] gameBord , int pos,String user) {
		char symbol=' ';
		if(user.equals("player")) {
			symbol='x';
			playerpositions.add(pos);
		}
		else if(user.equals("cpu")) {
			symbol='0';
			cpupositions.add(pos);
		}
		switch(pos) {
		case 1: gameBord[0][0]=symbol;break;
		case 2: gameBord[0][2]=symbol;break;
		case 3: gameBord[0][4]=symbol;break;
		case 4: gameBord[2][0]=symbol;break;
		case 5: gameBord[2][2]=symbol;break;
		case 6: gameBord[2][4]=symbol;break;
		case 7: gameBord[4][0]=symbol;break;
		case 8: gameBord[4][2]='x';break;
		case 9: gameBord[4][4]='x';break;
		}
	}
	public static String checkwinner() {
		List topRow=Arrays.asList(1,2,3);
		List midRow=Arrays.asList(4,5,6);
		List botRow=Arrays.asList(7,8,9);
		List leftcol=Arrays.asList(1,4,7);
		List midcol=Arrays.asList(2,5,8);
		List rightcol=Arrays.asList(3,6,9);
		List cros1=Arrays.asList(1,5,9);
		List cros2=Arrays.asList(7,5,3);

		List<List>winning= new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(leftcol);
		winning.add(midcol);
		winning.add(rightcol);
		winning.add(cros1);
		winning.add(cros2);
		for(List l:winning) {
			if(playerpositions.containsAll(l)) {
				return "congratulations you won!";
			}
			else if(cpupositions.contains(l)) {
				return "cpu wins ! soerry";
			}
			else if(playerpositions.size()+cpupositions.size()==9) {
				return "CAT!";

			}
		}

		return "";
	}

}
