package BuildingBlocks;

import java.util.*;

public class BuildingBlocks 
{
    static int numberOfFloors = 0; 
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> inputLL = new LinkedList<Integer>();
        
        System.out.println("enter the total no of floors in the building");
        numberOfFloors = sc.nextInt();
        for(int i=0; i< numberOfFloors; i++)
        {
            System.out.println("enter the floor size given on day : " + (i+1));
            inputLL.add(sc.nextInt());   
        }
        displayOrderOfConstruction(inputLL, numberOfFloors);
        
        
    }
    
    static void displayOrderOfConstruction(LinkedList<Integer> inputLL, int numberOfFloors)
    {
        System.out.print("\nThe order of construction is as follows\n");   
        int max = numberOfFloors ;
        for(int j=0; j<inputLL.size(); j++)
        {
            if(inputLL.get(j) != 0)
            {
                if(inputLL.get(j) == max)
                {
                    System.out.print("\nDay : " + (j+1) + "\n" + inputLL.get(j));
                    max = max - 1;
                    inputLL.set(j,0);
                    if((j+1) == numberOfFloors)
                    {
                        for(int i = max ; i>0 ; i--)
                        {
                            System.out.print(" " + i );   
                        }
                    }
                    else if(j>0)
                    {
                        for(int k=j-1;k>=0;k--)
                        {
                            if(inputLL.get(k) == max)
                            {
                                System.out.print(" " + inputLL.get(k));  
                                max = max-1;
                                inputLL.set(k,0);
                            }
                        }
                    }
                }
                else if(inputLL.get(j)<max)
                {
                    System.out.print("\nDay : " + (j+1) + "\n");
                }
                    
            }
        }
        
    }
    
}