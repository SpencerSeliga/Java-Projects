import static org.junit.Assert.assertNull;

public class WoodScrew extends Screw {

	
	String Head;
	String Drive;
	String Point; 
	
	
	
	public WoodScrew(double Length, String Thread, String material, String finish, String Head, String Drive, String Point, double uPrice, int NpU)
			throws IllegalFastener {
		super(Length, Thread, material, finish, uPrice, NpU);
		// TODO Auto-generated constructor stub
		
		//Head Conditions
		if(Head != "Bugle" && Head != "Flat" && Head != "Oval" && Head != "Pan" && Head != "Round")
			throw new IllegalFastener("This is an Invalid head shape");
		//Drive Conditions
		if(Drive != "6-Lobe" && Drive != "Philips" && Drive != "Slotted" && Drive != "Square")
			throw new IllegalFastener("This is an Illegal Drive type");
		//Point Conditions
		if(Point != "Double Cut" && Point != "Sharp" && Point != "Type 17")
			throw new IllegalFastener("This is an Illegal type of Point");
		
		
		this.Length = Length;
		this.Thread = Thread;
		this.Head = Head;
		this.Drive = Drive;
		this.Point = Point; 
		this.material = material;
		this.finish = finish; 
		this.uPrice = uPrice; 
		this.NpU = NpU;
		
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	
	public String toString(){
	    String item = "Wood Screw, ";
	    item = item + this.Head + '"' + " head, ";
	    item = item + this.Drive + '"' + " drive, ";
	    item = item + this.Point + '"' + " point, ";
		item = item + this.Length + '"' + " long, ";
		item = item + this.Thread + " thread, ";
		item = item + this.material + ", ";
		item = item + "with a " + this.finish + " finish. ";
		item = item + this.NpU + " in a unit, ";
		item = item + "$" + this.uPrice + " per unit.";
		return item;
	}
	
	
	public static void main(String args[]) throws IllegalFastener
	{
		WoodScrew toAdd = new WoodScrew(25.0, "#8-15", "Steel", "Zinc", "Flat", "Square", "Sharp", 8.84, 100);
		
	}
	
} 




