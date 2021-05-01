package homework.bookhierachy;

import homework.tax.Taxable;

public abstract class Product implements Taxable {
	private String name;
	private int price;
	private int taxPercent;
	private String currency;
	
	private final int EUR_EXCHANGE_RATE = 300;
	
	public static void changeCurrency(Product[] products, String targetCurrency) {
		for(Product product : products) {
			if(!product.currency.equals(targetCurrency)) {
				product.setCurrency(targetCurrency);
			}
		}
	}
	
	public static int comparePrice(Product first, Product second) {
		if(first.price > second.price) return 1;
		if(first.price < second.price) return 2;
		return 0;
	}
	
	public Product(String name, int price) {
		super();
		this.name = name;
		setPrice(price);
		this.currency = "Ft";
	}
	
	public Product(String name, int price, int taxPercent) {
		this(name, price);
		setTax(taxPercent);
	}
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", gross price=" + getTaxedValue() + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if (price < 0) {
			return;
		}
		this.price = price;
	}
	
	public abstract int getUnitPrice();
	
	public void decreasePrice(int percent) {
		int diff = (int)Math.round(percent / 100.0 * this.price);
		this.price -= diff;
	}
	
	public void increasePrice(double szazalek) {
        if(szazalek <= 0) {
        	return;
        }
        
        this.price += (int)Math.round((double)price * szazalek/100);
    }

	@Override
	public void setTax(double tax) {
		this.taxPercent = tax > 0 ? (int)tax : Taxable.taxPercent;
		
	}

	@Override
	public double getTax() {
		return price * taxPercent /100;
	}

	@Override
	public double getTaxedValue() {
		return price + getTax();
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		if(currency.equals("Euro")) {
			if(this.currency.equals("Ft")) {
				this.price = (int)Math.round((double)this.price / EUR_EXCHANGE_RATE);
			}
			this.currency = currency;
		}
		else if(currency.equals("Ft")) {
			if(this.currency.equals("Euro")) {
				this.price *= EUR_EXCHANGE_RATE;
			}
			this.currency = currency;
		}
		
	}
    	
}
