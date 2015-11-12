import java.util.*;

public class Lab09 
{
	static int swaps = 0;
    /**
     * Helper method for printing out arrays.
     * @param int[] arr Array of integers to print
     */
    public static void printArray(int[] arr) 
	{
		System.out.print("[ ");
		for (int j=0; j < (arr.length - 1); j++) 
		{
			System.out.print(arr[j] + ", ");
		}
		if (arr.length > 0) 
		{
			System.out.print(arr[arr.length - 1]);
		}
		System.out.println(" ]");
    }

    /**
     * Swap two elements in an array
     * @param int[] arr - the array
     * @param int index1 - the index of first element to swap
     * @param int index2 - the index of the second element to swap
     */

    public static void swap(int[] arr, int index1, int index2) 
	{
		if (index1 == index2) 
		{
			// Do nothing!
		} 
		else 
		{
			int tmp = arr[index1];
			arr[index1] = arr[index2];
			arr[index2] = tmp;
		}
    }

    /**
     * Sort an array in ascending order using the Selection Sort algorithm
     * @param int[] arr - the array
     */
    
    public static int[] bubbleSort(int[] arr)
	{
		swaps = 0; //First, reset swaps to 0
		
		if(arr.length < 2) //If the length is less than 2, it has one or zero elements, so it's already sorted.
		{
			return arr;
		}
		
		int didSwap = 1;
		while(didSwap > 0)
		{
			didSwap = 0;
			for(int i = 0; i < (arr.length - 1); i++)
			{
				if(arr[i] > arr[i + 1]) //If the next element is less than the current element 
				{
					swap(arr, i, (i + 1)); //Swap these two elements
					swaps++; //Increment swaps
					didSwap = 1; //Let the while loop know you made a swap, so it will continue scanning (it's not done til you've made no swaps)
				}
			}
		}
		return arr; 
	}
	
	public static int[] selectionSort(int[] arr) 
	{
		swaps = 0;
		if (arr.length < 2) 
		{
			return arr;
		}
	
		int minIndex = 0;
		int minVal = 0;

		for (int j = 0; j < (arr.length-1); j++) 
		{
			minIndex = j;
			minVal = arr[j];
			for(int k = j + 1; k < arr.length; k++) 
			{
				if (arr[k] < minVal) 
				{
					minVal = arr[k];
					minIndex = k;
				}
			}
			swap(arr, j, minIndex);
			if(j != minIndex)
			{
				swaps++;
			}
		}
		return arr;
    }
	
	public static int[][] deepCopy(int[][] arr) //Method for performing a deep copy on a 2D array. This will return an identical 2D array which can be assigned to a new reference variable
	{
		int[][] a2 = new int[arr.length][]; //Creates a new int array (a2) with initial length the same as arr, and initial columns 0, because we can't determine that right away
		for(int r = 0; r < arr.length; r++) //For every row in arr
		{
			int[] tempArray = new int[arr[r].length];
			for(int c = 0; c < arr[r].length; c++) //For every column associated with each row in arr
			{
				tempArray[c] = arr[r][c]; //Copy every element in every position in arr to the same position in a2
			}
			a2[r] = tempArray;
		}
		return a2; //Return this new array (identical to arr)
	}

    public static void main(String[] args) 
	{
		int[][] a1 = 
		{ 
			{8, 9, 5, 6, 4, 3},
		    {9, 0, 14, 13, 10, 8, 2, 1, 17, 18, 19, 201, 220, 235, 2},
		    {100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100, 1200 },
		    {22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 1},
		    {20, 18, 13, 12, 11, 9, 6, 5, 4, 3, 2, 1, -87, -900, -9, -909, -911, -80, -44, -32, -1000} 
		};
		
		int[][] a2 = deepCopy(a1); //Make a deep copy of a1 and assign a2 as a reference to this copy
		
		System.out.println("Bubblesort: ");
		for(int[] row : a1) //For each row (each row is an array) of a1
		{
			bubbleSort(row);
			printArray(row);
			System.out.println("Swaps: " + swaps);
		}
		
		System.out.println("Selectionsort: ");
		for(int[] row : a2) //For each row (each row is an array) of a2
		{
			selectionSort(row);
			printArray(row);
			System.out.println("Swaps: " + swaps);
		}
		
	}

    
}