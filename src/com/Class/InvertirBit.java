package com.Class;

import java.util.Arrays;
import java.util.Scanner;

public class InvertirBit {
	public static void InvertirBit(int [] lista){//actualizar el nombre del arreglo
		System.out.println("Código antes de invertir el bit: "+Arrays.toString(lista).replaceAll("\\[|\\]|,", ""));
	    Scanner posicion = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Ingrese la posicion del bit para invertir:");
	    int num = posicion.nextInt();
	    if (num<12) {
	    	
	    if (lista[num]==0){
	    lista[num]=1;
	    System.out.println("Código despues de invertir el bit: "+ Arrays.toString(lista).replaceAll("\\[|\\]|,", ""));
	    }
	    else {
	        lista[num]=0;
	        System.out.println("Código despues de invertir el bit: "+Arrays.toString(lista).replaceAll("\\[|\\]|,", ""));
	    }
	    }
	    else {
	    	System.out.println("El numero de posicion debe ser menor que 12.");
	    	InvertirBit(lista);
	    }
		}
}
