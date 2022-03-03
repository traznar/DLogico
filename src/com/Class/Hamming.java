package com.Class;

import java.util.*;

class Hamming
{
	private int[] value;
	public void hamming(String number) {
		int r=0,m=number.length(); 
		while(true)
		{
			if(m+r+1<=Math.pow(2,r))
			{
				break;
			}
			r++;
		}
		System.out.println("Number of parity bits needed : "+r);
		int transLength = number.length()+r,temp=0,temp2=0,j=0;
		int transMsg[]=new int[transLength+1]; //+1 because starts with 1
		for(int i=1;i<=transLength;i++)
		{
			temp2=(int)Math.pow(2,temp);
			if(i%temp2!=0)
			{
				transMsg[i]=Integer.parseInt(Character.toString(number.charAt(j)));
				j++;
			}
			else
			{
				temp++;
			}
		}
		for(int i=1;i<=transLength;i++)
		{
			System.out.print(transMsg[i]);
		}
		System.out.println();	

		for(int i=0;i<r;i++)
		{
			int smallStep=(int)Math.pow(2,i);
			int bigStep=smallStep*2;
			int start=smallStep,checkPos=start;
			System.out.println("Calculating Parity bit for Position : "+smallStep);
			System.out.print("Bits to be checked : ");
			while(true)
			{
				for(int k=start;k<=start+smallStep-1;k++)
				{
					checkPos=k;
					System.out.print(checkPos+" ");
					if(k>transLength)
					{
						break;
					}
					transMsg[smallStep]^=transMsg[checkPos];
				}
				if(checkPos>transLength)
				{
					break;
				}
				else
				{
					start=start+bigStep;
				}
			}
			System.out.println();
		}	
		//Display encoded message
		System.out.print("Hamming Encoded Message : ");
		for(int i=1;i<=transLength;i++)
		{
			System.out.print(transMsg[i]);
		}
		System.out.println();
		value=transMsg;
		
	}

}
