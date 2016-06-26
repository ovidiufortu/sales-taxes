package it.sales.taxes.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import it.sales.taxes.calculator.TaxCalculator;
import it.sales.taxes.display.ProductsDisplay;
import it.sales.taxes.products.Product;
import it.sales.taxes.utils.Constants;
import junit.framework.TestCase;

public class SalesTest extends TestCase {
	
	private List<Product> productsList;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		productsList = new ArrayList<Product>();
		
	}
	
	@Test
	public void testOutput1() {
		
		productsList.clear();
		
		Product book = new Product.ProductBuilder("book", 1, 12.49).build();
		Product regularProduct = new Product.ProductBuilder("music CD", 1, 14.99).withBasicTax(Constants.BASIC_SALES_TAX).build();
		Product food = new Product.ProductBuilder("chocolate bar",1,  0.85).build();
		
		productsList.add(book);
		productsList.add(regularProduct);
		productsList.add(food);
		
		 TaxCalculator taxCalculator = new TaxCalculator();
		 taxCalculator.calculate(productsList);
		    
		 ProductsDisplay productsDisplay = new ProductsDisplay(1, productsList);
		 productsDisplay.displayReceiptDetails();
	    
	}
	
	@Test
	public void testOutput2() {
		
		productsList.clear();
		
		Product importedFood = new Product.ProductBuilder("imported box of chocolates", 1, 10.00).
				withImportTax(Constants.IMPORT_SALES_TAXES).build();
		
		Product importedRegularProduct = new Product.ProductBuilder("imported bottle of perfume", 1, 47.50).
				withBasicTax(Constants.BASIC_SALES_TAX).withImportTax(Constants.IMPORT_SALES_TAXES).build();
		
		productsList.add(importedFood);
		productsList.add(importedRegularProduct);
		
	    TaxCalculator taxCalculator = new TaxCalculator();
	    taxCalculator.calculate(productsList);
	    
	    ProductsDisplay productsDisplay = new ProductsDisplay(2, productsList);
	    productsDisplay.displayReceiptDetails();

	}
	
	
	@Test
	public void testOutput3() {
		
		productsList.clear();
		
		Product importedPerfumeDior = new Product.ProductBuilder("imported bottle of perfume", 1, 27.99).
				withBasicTax(Constants.BASIC_SALES_TAX).withImportTax(Constants.IMPORT_SALES_TAXES).build();
		
		Product perfumeObsession = new Product.ProductBuilder("bottle of perfume", 1, 18.99).
				withBasicTax(Constants.BASIC_SALES_TAX).build();
		
		Product headachePills = new Product.ProductBuilder("packet of headache pills", 1, 9.75).build();
		
		Product importedChocolates = new Product.ProductBuilder("box of imported chocolates", 1, 11.25).
				withImportTax(Constants.IMPORT_SALES_TAXES).build();
		
		productsList.add(importedPerfumeDior);
		productsList.add(perfumeObsession);
		productsList.add(headachePills);
		productsList.add(importedChocolates);
		
		TaxCalculator taxCalculator = new TaxCalculator();
		taxCalculator.calculate(productsList);
		    
		ProductsDisplay productsDisplay = new ProductsDisplay(3, productsList);
		productsDisplay.displayReceiptDetails();
	    
	}

}
