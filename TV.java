//TV
	public class TV extends Product{
		private String screenType;
		private int resolution;
		private int displaySize;
		
		//Constructor
		public TV(int itemNo, String productName, int availableQuantity, double price, boolean productStatus, 
				String screenType, int resolution, int displaySize) {
			super(itemNo, productName, availableQuantity, price, productStatus);
			this.screenType = screenType;
			this.resolution = resolution;
			this.displaySize = displaySize;
		}
		//Screen Type
		public String getscreenType() {
			return screenType;
		}
				
		public void setscreenType(String screenType) {
			this.screenType = screenType;	
		}
				
		//Resolution
		public int getresolution() {
				return resolution;
		}
						
		public void setresolution(int Resolution) {
			this.resolution = Resolution;
							
		}
				
		//Display Size
		public int getdisplaySize() {
				return displaySize;
		}
			
		public void setdisplaySize(int displaySize) {
			this.displaySize = displaySize;			
		}
		
		public double getTVStockValue() {
	        return getTotalInventoryValue();
	    }
		
		public String toString() {
			
			super.toString();
			 return "Item number: " + super.getItemNo() +
		            "\nProduct name: " + super.getproductName() +
		            "\nScreen type: " + screenType +
		            "\nResolution: " + resolution +
		            "\nDisplay size: " + displaySize +
		            "\nQuantity available: " + super.getavailableQuantity() +
		            "\nPrice (RM): " + super.getprice() +
		            "\nInventory value (RM): " + getTVStockValue() +
		            "\nProduct status: " + super.getproductStatus();
		    }
		}
		