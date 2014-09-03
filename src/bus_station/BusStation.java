package bus_station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BusStation 
{
	public static boolean check(int a[], int value) 
	{
		long total = 0;
		for(int i = 0; i < a.length; i++)
		{
			if(total + a[i] > value)
			{
				return false;
			}
			total += a[i];
			if(total == value)
			{
				total = 0;
			}
		}
		return (total == 0);
	}
	
	public static void fillBus(int a[], long sum) 
	{
		List<Integer> result = new ArrayList<Integer>(); 
		for(int i = 1; i * i <= sum; i++)
		{
			if(check(a,i))
			{
				result.add(i);
			}
			if((sum / i) != i && check(a, (int)(sum / i)))
			{
				result.add((int)(sum / i));
			}
		}
		Collections.sort(result);
		for(int i:result)
		{
			System.out.print(i + " ");
		}
	}
	
	public static void main(String args[]) 
	{
		Scanner sr = new Scanner(System.in);
		int n = sr.nextInt();
		int a[] = new int[n];
		long sum = 0;
		for(int i = 0; i < n; i++)
		{
			a[i] = sr.nextInt();
			sum += a[i];
		}
		fillBus(a,sum);
		sr.close();
	}
}
