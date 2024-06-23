//Refrigerator
	public class Refrigerator extends Product{
		private String doorDesign;
		private String color;
		private double capacity;
		
		//Constructor
		
		public Refrigerator(int itemNo, String productName, int availableQuantity, double price, boolean productStatus, 
				String doorDesign, String color, double capacity) {
			super(itemNo, productName, availableQuantity, price, productStatus);
			this.doorDesign = doorDesign;
			this.color = color;
			this.capacity = capacity;
		}
		
		//Door Design
		public String getdoorDesign() {
			return doorDesign;
		}
		public void setdoorDesign(String doorDesign) {
			this.doorDesign = doorDesign;
		}
		
		//Color
		public String getcolor() {
			return color;
		}
				
		public void setColor(String color) {
			this.color = color;			
		}
		
		//Capacity
		public double getcapacity() {
			return capacity;
		}	
		
		public void setcapacity(double capacity) {
			this.capacity = capacity;		
		}	
		
		public double getRefrigeratorStockValue() {
	        return getTotalInventoryValue();
	    }
		
		public String toString() {
			
			super.toString();
			 return "Item number: " + super.getItemNo() +
		            "\nProduct name: " + super.getproductName() +
		            "\nDoor design: " + doorDesign +
		            "\nColor: " + color +
		            "\nCapacity (in Litres): " + capacity +
		            "\nQuantity available: " + super.getavailableQuantity() +
		            "\nPrice (RM): " + super.getprice() +
		            "\nInventory value (RM): " + getRefrigeratorStockValue() +
		            "\nProduct status: " + super.getproductStatus();
			}
		}
		