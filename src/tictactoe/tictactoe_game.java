package tictactoe;
import java.io.*;
import java.util.*;

public class tictactoe_game {

	static HashSet<Integer> ur_set = new HashSet<Integer>();
	static HashSet<Integer> comp_set = new HashSet<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] g_board= {
				{' ','|',' ','|',' '},
				{'-','-','-','-','-','-'},
				{' ','|',' ','|',' '},
				{'-','-','-','-','-','-'},
				{' ','|',' ','|',' '}
		};
		
		print_board(g_board);
		
		Scanner in = new Scanner(System.in);
		while(true) {

			System.out.print("Enter any number from 1-9: ");	
			int user_pos = in.nextInt();
			
			while(ur_set.contains(user_pos) || comp_set.contains(user_pos)) {
				System.out.println();
				System.out.println("Position is already taken. Try Again");
				System.out.print("Enter any number from 1-9: ");
				user_pos = in.nextInt();
			}
			
			place_holder(g_board,user_pos,"You");
			
			int com_pos = gen_random();
			
			while(ur_set.contains(com_pos) || comp_set.contains(com_pos)) {
				com_pos = gen_random();
			}
			
			place_holder(g_board,com_pos,"Comp");
			
			String res = checking_winner();
			if(res.length()>0) {
				System.out.println(res);
				break;
			}
			
		}
		
		
	}
	
	public static int gen_random() {
		int max = 9;
		int min = 1;
		int range = max-min +1;
		int res = (int)(Math.random()*range)+min;
		return res;
	}
	
	
	
	private static void print_board(char[][] g_board) {
		
		for(int i=0;i<g_board.length;i++) {
			for(int j=0;j<g_board[0].length;j++) {
				System.out.print(g_board[i][j]);
			}
			System.out.println();
		}
		
	}
	
	private static void place_holder(char [][]g_board,int position_in_board,String user) {
	
		char syb='X'; 
	
		if(user.equals("You")) {
		
			syb = 'X';
			ur_set.add(position_in_board);
	
		}
	 	else if (user.equals("Comp")) {
	 		syb = 'O';
			comp_set.add(position_in_board);
	 	}
	 	else
	 		System.out.println("Invalid Input");
		
		switch(position_in_board) {
		
	        case 1:
		        g_board[0][0]=syb;
		        break;
	        case 2:
		        g_board[0][2]=syb;
		        break;
	        case 3:
		        g_board[0][4]=syb;
		        break;
	        case 4:
		        g_board[2][0]=syb;
		        break;
	        case 5:
		        g_board[2][2]=syb;
		        break;
	        case 6:
		        g_board[2][4]=syb;
		        break;
	        case 7:
		        g_board[4][0]=syb;
		        break;
		    case 8:
		        g_board[4][2]=syb;
		        break;
	        case 9:
		        g_board[4][4]=syb;
		        break;
		     default:
		        System.out.println("Invalid Input");
		}
		
		System.out.println();
		print_board(g_board); 
		
	}
	
	public static String checking_winner() {
		
		HashSet<Integer> r1 = new HashSet<Integer>();
		r1.add(1);r1.add(2);r1.add(3);
		
		HashSet<Integer> r2 = new HashSet<Integer>();
		r2.add(4);r2.add(5);r2.add(6);
		
		HashSet<Integer> r3 = new HashSet<Integer>();
		r3.add(7);r1.add(8);r1.add(9);
		
		HashSet<Integer> c1 = new HashSet<Integer>();
		c1.add(1);c1.add(4);c1.add(7);
		
		HashSet<Integer> c2 = new HashSet<Integer>();
		c2.add(2);c2.add(5);c2.add(8);
		
		HashSet<Integer> c3 = new HashSet<Integer>();
		c3.add(3);c3.add(6);c3.add(9);
		
		HashSet<Integer> d1 = new HashSet<Integer>();
		d1.add(1);d1.add(5);d1.add(9);
		
		HashSet<Integer> d2 = new HashSet<Integer>();
		d2.add(3);d2.add(5);d2.add(7);
		
		HashSet<HashSet> check = new HashSet<HashSet>();
		check.add(r1);check.add(r2);check.add(r3);
		check.add(c1);check.add(c2);check.add(c3);
		check.add(d1);check.add(d2);
		
		for(HashSet I : check) {
			if(ur_set.containsAll(I))
				return "You WON!";
			else if(comp_set.containsAll(I))
			    return "You LOSE!";
		}
		
		if(ur_set.size()+comp_set.size()==9)
			return "Its a DRAW!";
		
		return "";
		
	}

}
