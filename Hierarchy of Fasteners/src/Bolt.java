
public class Bolt extends Fastener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		String Thread; 
		double Length;
		
		public Bolt (double Length, String Thread, String material, String finish, double uPrice, int NpU) throws IllegalFastener {
			super(material, finish, uPrice, NpU);
			
			// Flat Washer Materials
			if(material == "Aluminium" || material == "Copper" || material == "Nylon")
				throw new IllegalFastener("This material is only for Flat Washers");
			
			// Steel Screw Finishes 
			if(finish == "Lubricated" || finish == "ACQ 1000" || finish == "Black Phosphate")
				throw new IllegalFastener("This finish is for Steel Screws only");
			
			// Length Conditions
			if(Length < 0.5 || Length > 6){
				if((Length%0.25) != 0)
					throw new IllegalFastener("This is an Illegal Length");
				
			// Thread Conditions
				if(Thread!= "#8-13" && Thread != "#8-15"&& Thread != "#8-32" && Thread != "#10-13" && Thread != "#10-24" && Thread != "#10-32" && Thread != "1/4-20"&& Thread!= "5/16-18" && Thread!= "3/8-16" && Thread!= "7/16-14" && Thread!= "1/2-13" && Thread!= "5/8-11" && Thread!="3/4-10" )
					throw new IllegalFastener("This is an illegal size");
			}	
		}
		

		
}
