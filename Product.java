import java.util.*;

public abstract class Product {
	//Variables
	private int itemNo;
	private String productName;
	private int availableQuantity;
	private double price;
	private boolean productStatus;
	
	//Default constructor
	public Product() {
        /*
         this.itemNo = 0;
        this.productName = "";
        this.availableQuantity = 0;
        this.price = 0.0;
        this.productStatus = true;
        */
    }
	
	//Parameterized Constructor
	public Product(int itemNo, String productName, int availableQuantity, double price, boolean productStatus){
		this.itemNo = itemNo;
		this.productName = productName;
		this.availableQuantity = availableQuantity;
		this.price = price;
		this.productStatus = true;
	}
	
	//Item No
	public int getItemNo() {
		return itemNo;
	}
	
	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}
	
	//Product Name
	public String getproductName() {
		return productName;
	}
	
	public void setproductName(String productName) {
		this.productName = productName;
	}
	
	//Available Quantity
	public int getavailableQuantity() {
		return availableQuantity;
	}
	
	public void setavailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}	
	
	//Price
	public double getprice() {
		return price;
	}
	
	public void setprice(double Price) {
		this.price = Price;
	}
	
	//InventoryValue
	public double getinvetoryValue() {
		return price * availableQuantity;
	}
	
	
	//Product Status
	public boolean getproductStatus() {
		return productStatus;
	}
	
	public void setproductStatus(boolean productStatus) {
		this.productStatus = productStatus;
		
	}

	public double getTotalInventoryValue() {
        return this.price * this.availableQuantity;
    }

    public void addStock(int availableQuantity) {
        if (this.productStatus) {
            this.availableQuantity += availableQuantity;
        } else {
            System.out.println("Product is discontinued. Cannot add stock.");
        }
    }

    public void deductStock(int availableQuantity) {
        if (this.productStatus && this.availableQuantity >= availableQuantity) {
            this.availableQuantity -= availableQuantity;
        } else {
            System.out.println("Cannot deduct stock from discontinued product line.");
        }
    }
    
	public String toString() {
		return "Item number		:" + itemNo + 
				"\nProduct name		:" + productName + 
				"\nQuantity available		:"  + availableQuantity + 
				"\nPrice (RM)		:" + price + 
				"\nInventory value (RM) :" + (price * availableQuantity) + 
				"\nProduct status		:" + productStatus;
	}
	
	
}
