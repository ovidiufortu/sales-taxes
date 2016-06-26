package it.sales.taxes.calculator;

import java.util.List;
import java.util.ListIterator;

import it.sales.taxes.products.Product;

public class TaxCalculator {

	public void calculate(List<Product> goodsList) {

		ListIterator<Product> iterator = goodsList.listIterator();

		while (iterator.hasNext()) {

			Product product = iterator.next();
			
			//calculate priceWithTaxes
			//1. get the applicable taxes for current product
			double applicableTaxes = product.getBasicTax() + product.getImportTax();
			//2. calculate value of taxes
			double taxesValue = product.getPriceWithoutTaxes() * applicableTaxes;
			product.setSalesTaxes(taxesValue);
			//set price with taxes
			double priceWithTaxes = product.getPriceWithoutTaxes()  + product.getSalesTaxes();
			
			product.setPriceWithTaxes(priceWithTaxes);
			
		}
		
	}

}
