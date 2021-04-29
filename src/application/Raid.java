package application;

import java.util.Random;

public class Raid {
	int disk_size;
	int disk_number;
	int[][] disks;
	int[][] hamming_disks;
	
	
	public Raid()
	{
		disk_size=4;
		disk_number=4;
		disks = new int[disk_size][disk_number];			//4x4
		hamming_disks = new int[disk_size][disk_number-1];  //4x3
	}
	
	public void fillDisks()
	{
		Random random = new Random();
		for(int i=0; i<disk_number;i++)
		{
			for(int j=0; j<disk_size;j++)
			{
				disks[i][j]=random.nextInt(2);
			}
		}
	}
	
	public void generateECC()
	{
		for(int i=0; i<disk_size; i++)
		{
			for(int j=0; j<disk_number-1; j++)
			{
				hamming_disks[i][j]=parity(i,j);
			}
			
		}
	}
	
	//hamming0 = 0,1,3
	//hamming1 = 0,2,3
	//hamming2 = 1,2,3
	public int parity(int row, int column)
	{
		int result;
		if(column==0)
		{
			result=(disks[row][0]+disks[row][1]+disks[row][3])%2;
		}
		else if(column==1)
		{
			result=(disks[row][0]+disks[row][2]+disks[row][3])%2;
		}
		else //column==2
		{
			result=(disks[row][1]+disks[row][2]+disks[row][3])%2;
		}
		return result;
	}
	
	public void errorInDisks()
	{
		String message="";
		
		//random position of error
		Random random = new Random();
		int row = random.nextInt(disk_size);
		int column = random.nextInt(disk_number);
		message+="Error in disk: " + column + " at position: " + row;
		
		//flip bit
		if(disks[row][column]==1)
		{
			disks[row][column] = 0;
		}
		else
		{
			disks[row][column] = 1;
		}
		
		message+="\nChanged bit to: " + disks[row][column] + "\n";
		System.out.println(message);
	}
	
	public void errorInHammingDisks()
	{
		String message="";
		
		//random position of error
		Random random = new Random();
		int row = random.nextInt(disk_size);
		int column = random.nextInt(disk_number-1);
		message+="Error in hamming disk: " + column + " at position: " + row;
		
		//flip bit
		if(hamming_disks[row][column]==1)
		{
			hamming_disks[row][column] = 0;
		}
		else
		{
			hamming_disks[row][column] = 1;
		}
		
		message+="\nChanged bit to: " + hamming_disks[row][column] + "\n";
		System.out.println(message);
	}
	
	
	
	//bit 1 - zmiana e1, e2      bez zmian- e3
	//bit 2 - zmiana e1, e3      bez zmian- e2
	//bit 3 - zmiana e2, e3      bez zmian- e1
	//bit 4 - zmiana e1, e2, e3
	public void fixBits()
	{
		
	}
	
	public String toString()
	{
		String result="RAID";
		
		//disks
		for(int i=0; i<disk_number; i++)
		{
			result+="\nDisk" + i + ": ";
			for(int j=0; j<disk_size; j++)
			{
				result+=disks[j][i];
			}
		}
		
		/*System.out.println(disks[0][0] +"+"+ disks[1][0]+"+"+disks[2][0] +"+"+ disks[3][0]);
		System.out.println(disks[0][1] +"+"+ disks[1][1]+"+"+disks[2][1] +"+"+ disks[3][1]);
		System.out.println(disks[0][2] +"+"+ disks[1][2]+"+"+disks[2][2] +"+"+ disks[3][2]);
		System.out.println(disks[0][3] +"+"+ disks[1][3]+"+"+disks[2][3] +"+"+ disks[3][3]);*/
		
		//hamming disks
		for(int i=0; i<disk_number-1; i++)
		{
			result+="\nHamming Disk" + i + ": ";
			for(int j=0; j<(disk_size); j++)
			{
				result+=hamming_disks[j][i];
			}
		}
		result+="\n";
		
		return result;
	}

}
