
public class CarriageBolt extends Bolt {

	public CarriageBolt(double Length, String Thread, String material, String finish, double uPrice, int NpU)
			throws IllegalFastener {
		super(Length, Thread, material, finish, uPrice, NpU);
		// TODO Auto-generated constructor stub
		
		this.Length = Length;
		this.Thread = Thread; 
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
	    String item = "Carriage Bolt ";
		item = item + this.Length + '"' + " long, ";
		item = item + this.Thread + " thread, ";
		item = item + this.material + ", ";
		item = item + "with a " + this.finish + " finish. ";
		item = item + this.NpU + " in a unit, ";
		item = item + "$" + this.uPrice + " per unit.";
		return item;
		}
	
	
	
}