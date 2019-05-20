package com.orenan.griffith;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class InputExample {

	public static void main(String[] args){

		System.out.println("Started");
		
		double[][] summary = new double[4][5];

		summary[0] = getData("C:\\Users\\2975457\\Documents\\inClassJava\\fileIO\\src\\DUBLIN_EXPENSES.txt");
		summary[1] = getData("C:\\Users\\2975457\\Documents\\inClassJava\\fileIO\\src\\LIMERICK_EXPENSES.txt");
		summary[2] = getData("C:\\Users\\2975457\\Documents\\inClassJava\\fileIO\\src\\CORK_EXPENSES.txt");
		
//summarise all data

		for(int i=0;i<=2;i++)
		{
			for(int j=2;j<5;j++){
			summary[3][j] +=summary[i][j];
			}

		}
		//write out results
		try {
			writeResults(summary[3]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	//
	
	
	
private static double[] getData(String fileName)
{

double result[] = new double[5]; //allow up to 5 columns to be calculated
String line[] = new String[2];

File f = new File(fileName);

try {
	
	FileReader fr = new FileReader(f);
	BufferedReader br =new BufferedReader(fr);
	
	br.readLine(); //get rid of first line

	//maybe code here to check headings
	int R = 0;
	while (line != null)
	{ 
		line = br.readLine().split(",");
		System.out.println("Line number: " + R++);
		for(int i=2; i<line.length;i++)
		{
			result[i]+= Double.parseDouble(line[i]); //Adding up.
			System.out.println(result[i]);
		}
	}
}

catch (FileNotFoundException e) {
	e.printStackTrace();
	}

catch (IOException e) {
	e.printStackTrace();
	}

finally {
	System.out.println(Arrays.toString(result));
	
	return result;
	}
}

private static void writeResults(double[] in) throws IOException
{
	
    Date date = Calendar.getInstance().getTime();  
    DateFormat dateFormat = new SimpleDateFormat("  yyyy-MM-dd = hh-mm-ss");  
    String strDate = dateFormat.format(date);  
	
	File out = new File("C:\\Users\\2975457\\Documents\\inClassJava\\fileIO\\src\\results" + strDate + ".txt");
	FileWriter fw = new FileWriter(out);
	BufferedWriter bw = new BufferedWriter(fw);
	
	bw.write("travel,Pay,Misc");
	bw.write(System.lineSeparator());
	
	for (int i=2;i<in.length;i++)
	{
		bw.write(in[i] +" ");
	}
	bw.flush();
	bw.close();
	}

}