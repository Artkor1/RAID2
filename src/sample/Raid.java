package sample;

import java.util.Arrays;
import java.util.Random;

public class Raid {
    int disk_size;
    int disk_number;
    static int[][] disks;
    static int[][] hamming_disks;


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
        for(int i=0; i<disk_size;i++)
        {
            for(int j=0; j<disk_number;j++)
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

    public int parity(int row, int column)
    {
        int result;
        //h0 - is responsible for d0, d1, d3
        //h1 - is responsible for d0, d2, d3
        //h2 - is responsible for d1, d2, d3
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

    public String errorInDisks()
    {
        String message="";

        //random position of error
        Random random = new Random();
        int row = random.nextInt(disk_size);
        int column = random.nextInt(disk_number);
        message+="Error in disk: " + column + " at position: " + row;

        //flip the bit
        changeBit(row, column, false);

        message+="\nChanged bit to: " + disks[row][column] + "\n";
        //System.out.println(message);
        return message;
    }

    public String errorInHammingDisks()
    {
        String message="";

        //random position of error
        Random random = new Random();
        int row = random.nextInt(disk_size);
        int column = random.nextInt(disk_number-1);
        message+="Error in hamming disk: " + column + " at position: " + row;

        //flip the bit
        changeBit(row,column,true);

        message+="\nChanged bit to: " + hamming_disks[row][column] + "\n";
        //System.out.println(message);
        return message;
    }

    public void changeBit(int row, int column, boolean disk) //disk: false-main disk,  true-hamming disk
    {
        if(disk)
        {
            if(hamming_disks[row][column]==1)
            {
                hamming_disks[row][column] = 0;
            }
            else
            {
                hamming_disks[row][column] = 1;
            }
        }
        else
        {
            if(disks[row][column]==1)
            {
                disks[row][column] = 0;
            }
            else
            {
                disks[row][column] = 1;
            }
        }
    }


    public String fixBits()
    {
        String message="";
        //create new hamming codes
        for(int i=0; i<disk_size; i++)
        {
            //this array will be used to mark which positions in hamming disks changed
            boolean[] changed_hamming = new boolean[disk_number-1];
            Arrays.fill(changed_hamming, false);
            for(int j=0; j<disk_number-1; j++)
            {
                int new_hamming=parity(i,j);

                //if new hamming code is different from the original, correct one, we mark the change
                if(new_hamming!=hamming_disks[i][j])
                {
                    changed_hamming[j]=true;
                }
            }

            //error in disk
            //d0   changed h0, h1      not changed h2
            //d1   changed h0, h2      not changed h1
            //d2   changed h1, h2      not changed h0
            //d3   changed h0, h1, h2

            //error in hamming disk
            //h0   changed h0		   not changed h1,h2
            //h1   changed h1		   not changed h0,h2
            //h2   changed h2		   not changed h0,h1

            //we repair bits accordingly
            if(changed_hamming[0] && changed_hamming[1] && !changed_hamming[2])
            {
                message+=("Repaired error in disk: " + 0 + " at position: " + i + "\n");
                changeBit(i,0,false);
                break;
            }
            else if(changed_hamming[0] && !changed_hamming[1] && changed_hamming[2])
            {
                message+=("Repaired error in disk: " + 1 + " at position: " + i + "\n");
                changeBit(i,1,false);
                break;
            }
            else if(!changed_hamming[0] && changed_hamming[1] && changed_hamming[2])
            {
                message+=("Repaired error in disk: " + 2 + " at position: " + i + "\n");
                changeBit(i,2,false);
                break;
            }
            else if(changed_hamming[0] && changed_hamming[1] && changed_hamming[2])
            {
                message+=("Repaired error in disk: " + 3 + " at position: " + i + "\n");
                changeBit(i,3,false);
                break;
            }
            else if(changed_hamming[0] && !changed_hamming[1] && !changed_hamming[2])
            {
                message+=("Repaired error in hamming disk: " + 0 + " at position: " + i + "\n");
                changeBit(i,0,true);
                break;
            }
            else if(!changed_hamming[0] && changed_hamming[1] && !changed_hamming[2])
            {
                message+=("Repaired error in hamming disk: " + 1 + " at position: " + i + "\n");
                changeBit(i,1,true);
                break;
            }
            else if(!changed_hamming[0] && !changed_hamming[1] && changed_hamming[2])
            {
                message+=("Repaired error in hamming disk: " + 2 + " at position: " + i + "\n");
                changeBit(i,2,true);
                break;
            }
        }

        //System.out.println(message);
        return message;
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


    public String getDiskTable(int a, int b){
        String str = "";
        str += disks[a][b];

        return str;
    }

    public String getHammingDisks(int a, int b){
        String str = "";
        str += hamming_disks[a][b];

        return str;
    }
}
