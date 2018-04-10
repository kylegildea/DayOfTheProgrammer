import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static String solve(int year)
    {
        HashMap<Integer, Integer>calendar = new HashMap<Integer, Integer>(12);
        calendar = fillCalendar(calendar, year);
        
        return findDay(calendar, year);
    }

    private static String findDay(HashMap<Integer, Integer> calendar, int year) 
    {
    	int day = 256, i = 1;
    	while(day > 31)
    	{
    		day -= calendar.get(i);
    		i++;
    	}
    	StringBuilder date = new StringBuilder();
    	date.append(day + ".0" + i+"."+year);
		return date.toString();
	}

	private static HashMap<Integer, Integer> fillCalendar(HashMap<Integer, Integer> calendar, int year) 
    {
		for(int i = 1; i < 13; i++)
		{
			if(i == 9 || i == 4 || i == 6 || i == 11)
			{
				calendar.put(i, 30);
			}
		
			else if(isLeap(year) && i == 2)
			{
				calendar.put(i, 29);
			}
			else if(i== 2 && year !=1918)
			{
				calendar.put(i, 28);
			}
			else if(i == 2 && year == 1918)
			{
				calendar.put(i, 15);
			}
			else
			{
				calendar.put(i, 31);
			}
		}
			
			return calendar;
	}
	
	private static boolean isLeap(int year) 
	{
		if(isJulian(year))
		{
			return ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0));
		}
		else
		{
			return (year % 4 == 0);
		}
	}

	private static boolean isJulian(int year)
	{
		return (year >= 1919);
	}

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        String result = solve(year);
        System.out.println(result);
    }
}
