
public class Washer extends Fastener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	double outerD;
	double innerD;
	double Thickness;
	
	public Washer (double outerD, double innerD, double Thickness, String material, String finish, double uPrice, int NpU) throws IllegalFastener {
		super(material, finish, uPrice, NpU);
		
		// Steel Screw Finishes 
		if(finish == "Lubricated" || finish == "ACQ 1000" || finish == "Black Phosphate")
			throw new IllegalFastener("This finish is for Steel Screws only");
		
		// Diameter Conditions 
		if(innerD >= outerD)
			throw new IllegalFastener("Outer Diameter cannot exceed the Inner Diameter.");
		if(outerD < 0.187 || outerD > 2.010)
			throw new IllegalFastener("This is an Illegal Outer Diameter");
		if(innerD < 0.068 || innerD > 0.817)
			throw new IllegalFastener("This is an Illegal Inner Diameter");
		if(innerD + 0.1 >= outerD)
			throw new IllegalFastener("This Inner Diameter is larger then the Outer Diameter");
		
		//Thickness Conditions
		if(Thickness < 0.015 || Thickness > 0.109)
			throw new IllegalFastener("This is an invalid thickness");
	}
	
	

	
}
