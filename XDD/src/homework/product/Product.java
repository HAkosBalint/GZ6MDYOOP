package homework.product;

public class Product {
	private String name;
	private int price;
	
	
	public Product(String name, int price) {
		super();
		this.name = name;
		if(price < 0)
		{
			this.price = 0;
		}
		else
		{
			this.price = price;
		}
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
		if(price < 0)
		{
			
		}
		else
		{
			this.price = price;
		}
	}


	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
	
	public void decreasePrice(int percent)
	{
		double elso = 100 - percent;
		double masodik = elso /100;
		this.price = (int)(Math.round(this.price * masodik));
		
		
		
	}
	
	
	public void decreasePrice2(int percent)
	{
		double elso = 100 - percent;
		double masodik = elso /100;
		this.price = (int)(Math.round(this.price * masodik));
		
		
		
	}
	
	
	public void increasePrice(int percentage) {
		if (percentage > 0) {
			price += Math.round(price*(float)percentage/100);
		}	
	}


	
}
