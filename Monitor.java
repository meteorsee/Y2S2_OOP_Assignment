//Monitor
	public class Monitor extends Product{
		private String screenType;
		private int resolution;
		private String panelType;
		private int refreshRate;
		private int responseTime;
		private int displaySize;
		
		//Constructor
		public Monitor(int itemNo, String productName, int availableQuantity, double price, boolean productStatus, 
				String screenType, String panelType, int resolution, int refreshRate, int responseTime, int displaySize) {
			super(itemNo, productName, availableQuantity, price, productStatus);
			this.screenType = screenType;
			this.resolution = resolution;
			this.panelType = panelType;
			this.refreshRate = refreshRate;
			this.responseTime = responseTime;
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
		
		//Panel Type
		public String getpanelType() {
			return panelType;
		}
						
		public void setpanelType(String panelType) {
			this.panelType = panelType;	
		}
						
		//Refresh Rate
		public int getrefreshRate() {
			return refreshRate;
		}
								
		public void setrefreshRate(int refreshRate) {
			this.refreshRate = refreshRate;						
		}
		
		//Response Time
		public int getresponseTime() {
			return responseTime;
		}
										
		public void setresponseTime(int responseTime) {
			this.responseTime = responseTime;						
		}
		
		
		//Display Size
		public int getdisplaySize() {
				return displaySize;
		}
			
		public void setdisplaySize(int displaySize) {
			this.displaySize = displaySize;			
		}
		
		public double getMonitorStockValue() {
	        return getTotalInventoryValue();
	    }
		
		public String toString() {
			
			super.toString();
			 return "Item number: " + super.getItemNo() +
		            "\nProduct name: " + super.getproductName() +
		            "\nScreen type: " + screenType +
		            "\nPanel Type: " + panelType +
		            "\nResolution: " + resolution +		            
		            "\nRefresh Rate: " + refreshRate +
		            "\nResponse Time: " + responseTime +
		            "\nDisplay size: " + displaySize +
		            "\nQuantity available: " + super.getavailableQuantity() +
		            "\nPrice (RM): " + super.getprice() +
		            "\nInventory value (RM): " + getMonitorStockValue() +
		            "\nProduct status: " + super.getproductStatus();
		    }
		}
		