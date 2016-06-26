package it.sales.taxes.utils;

public class Constants {

	public static final double BASIC_SALES_TAX = 0.1;
	public static final double IMPORT_SALES_TAXES = 0.05;
	
	public static double roundUp(double number) {
		
    	double result = Math.ceil(number * 20.0) / 20.0;
    	
    	return result;
    }
	
}
