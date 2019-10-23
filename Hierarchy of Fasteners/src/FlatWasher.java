
public class FlatWasher extends Washer {

	public FlatWasher(double outerD, double innerD, double Thickness, String material, String finish, double uPrice,
			int NpU) throws IllegalFastener {
		super(outerD, innerD, Thickness, material, finish, uPrice, NpU);
		this.outerD = outerD;
		this.innerD = innerD; 
		this.Thickness = Thickness;
		this.material = material;
		this.finish = finish; 
		this.uPrice = uPrice; 
		this.NpU = NpU;
		// TODO Auto-generated constructor stub
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	public String toString(){
	    String item = "Flat Washer, ";
		item = item + this.outerD + '"' + " OD, ";
		item = item + this.innerD + " ID, ";
		item = item + this.Thickness + " thick, ";
		item = item + this.material + ", ";
		item = item + "with a " + this.finish + " finish. ";
		item = item + this.NpU + " in a unit, ";
		item = item + "$" + this.uPrice + " per unit.";
		return item;
		}
	
	
	public static void main(String args[]) throws IllegalFastener
	{
		FlatWasher toAdd = new FlatWasher(1.375, 0.562, 0.109, "Steel", "Yellow Zinc", 10.7375, 25);
		
		
		
	}
	
	

}
