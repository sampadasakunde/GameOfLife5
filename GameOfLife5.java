package coditationtest;

import java.util.Scanner;

public class GameOfLife5 {

	//variable declaration and initialization
	int M = 5, N = 5;
	Scanner sc=new Scanner(System.in);

	public static void main(String[] args)
	{
		int n=1;
		Scanner sc=new Scanner(System.in);

		//creating obj. of class to call methods
		GameOfLife5 ob=new GameOfLife5();
		do {

			System.out.println("=======================GAME Program==============================");
			System.out.println("1.Start Play and GetNext Generation and Check Cell State\n2. EXIT ");
			System.out.print("Enter choice =");
			int ch=sc.nextInt();

			switch(ch)
			{
			
			case 1:int iteration=4;
				ob.test(iteration);
			break;

			case 2:System.exit(0);

			break;

			default:
				System.out.println("Wrong Choice...!!");

			}

			System.out.print("Do u want to continue press 1 otherwise 0 = ");
			n=sc.nextInt();
		}while(n!=0);

	} 

	public void test(int noIterations)
	{
		int M = 5, N = 5;

		// Intiliazing the grid.
		int[][] grid = {{0, 0, 0, 0, 0},
				{0, 0, 0, 1, 0},
				{0, 0, 1, 1, 0},
				{0, 0, 0, 1, 0},
				{0, 0, 0, 0, 0}}; 


		// Displaying the grid
		System.out.println("Original Generation");
		displayGrid(grid);   

		for (int i = 0 ; i < noIterations ; i++) {
			System.out.println("\n\n"+(i+1)+" Generation");
			grid=nextGeneration(grid,M,N);
			displayGrid(grid);
			printCellState(grid);
		}
	}
	public void displayGrid(int[][] grid)
	{
		int M = 5, N = 5;

		for (int i = 0; i < M; i++)
		{
			for (int j = 0; j < N; j++)
			{
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();

		}
	}


	//printing state of an individual state
	public void printCellState(int[][] grid)
	{
		int counte = 0;
		System.out.println("Enter The Cell Which You Want To Check ");

		System.out.println("Enter Row plz be sure index start from zero ");
		int r=sc.nextInt();

		System.out.println("Enter Column plz be sure column index start from zero");
		int c=sc.nextInt();

		if(r<M && c<N)
		{	
			for(int i=0;i<M;i++)
			{
				for(int j=0;j<N;j++)
					if(grid[r][c]==0)
						counte=0;
					else
						counte=1;
			}	


			if(counte==0)
				System.out.println("cell status is Dead");
			if(counte==1)
				System.out.println("cell status is Live");

		}
		else
		{
			System.out.println("Plz Enter Correct Rows And Column");
			printCellState(grid);
		}

	}


	// Function to print next generation
	public int[][] nextGeneration(int grid[][], int M, int N)
	{
		int[][] future = new int[M][N];

		// Loop through every cell
		for (int l = 1; l < M - 1; l++)
		{
			for (int m = 1; m < N - 1; m++)
			{
				// finding no Of Neighbours that are alive
				int liveNeighbours = 0;
				for (int i = -1; i <= 1; i++)
					for (int j = -1; j <= 1; j++)
						liveNeighbours=liveNeighbours+ grid[l + i][m + j];

				// The cell needs to be subtracted from its neighbors as it was counted before
				liveNeighbours =liveNeighbours-grid[l][m];

				// Implementing the Rules of Life

				// Cell is lonely and dies
				if ((grid[l][m] == 1) && (liveNeighbours < 2))
					future[l][m] = 0;

				// Cell dies due to over population
				else if ((grid[l][m] == 1) && (liveNeighbours > 3))
					future[l][m] = 0;
				// A new cell is born if liveNeighbours count  are 2 or 3
				else if ((grid[l][m] == 1) && (liveNeighbours==2 || liveNeighbours == 3))
					future[l][m] = 1;

				// A new cell is born
				else if ((grid[l][m] == 0) && (liveNeighbours == 3))
					future[l][m] = 1;


				// Remains the same
				else
					future[l][m] = grid[l][m];
			}
		}

		int[][] future1 = new int[M][N];

		for (int i = 0; i < M; i++)
		{
			for (int j = 0; j < N; j++)
			{
				future1[i][j]=future[i][j];

			}
		}

		return future1;
	}
}
/*
=======================GAME Program==============================
1.Start Play and GetNext Generation and Check Cell State
2. EXIT 
Enter choice =1
Original Generation
0 0 0 0 0 
0 0 0 1 0 
0 0 1 1 0 
0 0 0 1 0 
0 0 0 0 0 


1 Generation
0 0 0 0 0 
0 0 1 1 0 
0 0 1 1 0 
0 0 1 1 0 
0 0 0 0 0 


Enter The Cell Which You Want To Check 
Enter Row plz be sure index start from zero 
2
Enter Column plz be sure column index start from zero
2
cell status is Live


2 Generation
0 0 0 0 0 
0 0 1 1 0 
0 1 0 0 0 
0 0 1 1 0 
0 0 0 0 0 
Enter The Cell Which You Want To Check 
Enter Row plz be sure index start from zero 
2
Enter Column plz be sure column index start from zero
2
cell status is Dead


3 Generation
0 0 0 0 0 
0 0 1 0 0 
0 1 0 0 0 
0 0 1 0 0 
0 0 0 0 0 
Enter The Cell Which You Want To Check 
Enter Row plz be sure index start from zero 
2
Enter Column plz be sure column index start from zero
2
cell status is Dead


4 Generation
0 0 0 0 0 
0 0 0 0 0 
0 1 1 0 0 
0 0 0 0 0 
0 0 0 0 0 
Enter The Cell Which You Want To Check 
Enter Row plz be sure index start from zero 
2
Enter Column plz be sure column index start from zero
2
cell status is Live
Do u want to continue press 1 otherwise 0 = 1
=================GAME Program========================
1.Start Play and GetNext Generation and Check Cell State
2. EXIT 
Enter choice =2
*/
