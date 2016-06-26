package it.sales.taxes.products;

public class Product {

	private String name; //required
	private int cant; //required
	private double priceWithoutTaxes; //required
	private double basicTax;  //optional, currently it is 10%  
	private double importTax;  //optional, currently it is 5%
	private double priceWithTaxes; //it will be calculated
	private double salesTaxes; //it will be calculated  
	
	private Product(ProductBuilder builder) {
		this.name = builder.name;
		this.cant = builder.cant;
		this.priceWithoutTaxes = builder.priceWithoutTaxes;
		this.basicTax = builder.basicTax;
		this.importTax = builder.importTax;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}

	public double getPriceWithoutTaxes() {
		return priceWithoutTaxes;
	}

	public void setPriceWithoutTaxes(double priceWithoutTaxes) {
		this.priceWithoutTaxes = priceWithoutTaxes;
	}

	public double getPriceWithTaxes() {
		return priceWithTaxes;
	}

	public void setPriceWithTaxes(double priceWithTaxes) {
		this.priceWithTaxes = priceWithTaxes;
	}

	public double getBasicTax() {
		return basicTax;
	}

	public void setBasicTax(double basicTax) {
		this.basicTax = basicTax;
	}

	public double getImportTax() {
		return importTax;
	}

	public void setImportTax(double importTax) {
		this.importTax = importTax;
	}
	
	public double getSalesTaxes() {
		return salesTaxes;
	}

	public void setSalesTaxes(double salesTaxes) {
		this.salesTaxes = salesTaxes;
	}
	
	public static class ProductBuilder {
		private String name; //required
		private int cant; //required
		private double priceWithoutTaxes; //required
		private double basicTax;  //optional because one of products are exempted
		private double importTax;  //optional because one of products are exempted
		
		public ProductBuilder(String name, int cant, double priceWithoutTaxes) {
			this.name = name;
			this.cant = cant;
			this.priceWithoutTaxes = priceWithoutTaxes;
		}
		
		public ProductBuilder withBasicTax(double basicTax) {
			this.basicTax = basicTax;
			return this;
		}

		public ProductBuilder withImportTax(double importTax) {
			this.importTax = importTax;
			return this;
		}
		
		public Product build() {
			return new Product(this);
		}
	}
	
}
