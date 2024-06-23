//Printer
	public class Printer extends Product{
		private String maxPaperSize;
		private int maxResolution;
		private String color;
		private int paperTrayCapacity;
		
		//Constructor
		
		public Printer(int itemNo, String productName, int availableQuantity, double price, boolean productStatus, 
				String maxPaperSize, int maxResolution, String color, int paperTrayCapacity) {
			super(itemNo, productName, availableQuantity, price, productStatus);
			this.maxPaperSize = maxPaperSize;
			this.maxResolution = maxResolution;
			this.color = color;
			this.paperTrayCapacity = paperTrayCapacity;
		}
		
		//Door Design
		public String getMaxPaperSize() {
			return maxPaperSize;
		}
		public void setMaxPaperSize(String maxPaperSize) {
			this.maxPaperSize = maxPaperSize;
		}
		
		//Resolution
		public int getResolution() {
			return maxResolution;
		}	
				
		public void setResolution(int maxResolution) {
			this.maxResolution = maxResolution;		
		}
		
		//Color
		public String getcolor() {
			return color;
		}
				
		public void setColor(String color) {
			this.color = color;			
		}
		
		//Paper Tray Capacity
		public int getPaperTrayCapacity() {
			return paperTrayCapacity;
		}	
		
		public void setPaperTrayCapacity(int paperTrayCapacity) {
			this.paperTrayCapacity = paperTrayCapacity;		
		}	
		
		public double getPrinterStockValue() {
	        return getTotalInventoryValue();
	    }
		
		public String toString() {
			
			super.toString();
			 return "Item number: " + super.getItemNo() +
		            "\nProduct name: " + super.getproductName() +
		            "\nMax Paper Size: " + maxPaperSize +
		            "\nColor: " + color +
		            "\nResolution: " + maxResolution +
		            "\nPaperTray Capacity: " + paperTrayCapacity +
		            "\nQuantity available: " + super.getavailableQuantity() +
		            "\nPrice (RM): " + super.getprice() +
		            "\nInventory value (RM): " + getPrinterStockValue() +
		            "\nProduct status: " + super.getproductStatus();
			}
		}
		