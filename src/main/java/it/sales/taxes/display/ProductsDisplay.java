package it.sales.taxes.display;

import java.math.BigDecimal;
import java.util.List;
import java.util.ListIterator;

import it.sales.taxes.products.Product;
import it.sales.taxes.utils.Constants;

public class ProductsDisplay {
	
	private List<Product> productsList;
	private int currOutput;

    public ProductsDisplay(int currentOutput, List<Product> productsList) {
	    this.currOutput = currentOutput;
    	this.productsList = productsList;	
	}
    
    public void displayReceiptDetails() {
    	ListIterator<Product> iterator = productsList.listIterator();

    	System.out.println("");
		System.out.println("Output " + this.currOutput + ":");
		
		double salesTaxesTotal = 0;
		double grandTotal = 0;
		
		while (iterator.hasNext()) {

			Product product = iterator.next();

			salesTaxesTotal += product.getSalesTaxes();
			grandTotal += product.getPriceWithTaxes(); 
			
			System.out.println(product.getCant() + " " + product.getName() + " at " +			
					new BigDecimal(product.getPriceWithTaxes()).setScale(2, BigDecimal.ROUND_HALF_UP));
			
		}
		
		System.out.println("Sales Taxes: " +  Constants.roundUp(salesTaxesTotal));
		System.out.println("Total: " + Constants.roundUp(grandTotal));
    }
    
}
