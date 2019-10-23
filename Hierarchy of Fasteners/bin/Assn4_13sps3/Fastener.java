import java.io.Serializable;

public class Fastener implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int NpU;
	double uPrice;
	String finish;
    String material; 
	
	public Fastener(String material, String finish, double uPrice, int NpU) throws IllegalFastener{
		
		// Number per Unit Conditions 
		if (NpU < 1 || (NpU > 1 && (NpU > 1000 || NpU % 5 != 0)))
			throw new IllegalFastener("You must order between 1 and 100 fasteners");
			this.NpU = NpU; 
			
		// Material Conditions 
		if(material != "Brass" && material != "Stainless Steel" && material != "Steel" && material != "Aluminium" && material != "Copper" && material != "Nylon")
			throw new IllegalFastener("We do not offer this kind of material, try Brass, Steel, Stainless Steel, Aluminium, Copper, or Nylon");
			this.material = material; 
		
		//Unit Price Conditions
		if( uPrice < 0)
			throw new IllegalFastener("The price per unit must be greater then 0.");
			this.uPrice = uPrice; 
		//Finish Conditions
		if(material != "Steel"){
			if(finish != "Plain")
				throw new IllegalFastener("This is an Illegal finish for your material");
				this.finish = finish;
		}

	}
	
	
	//Get Cost Method
		public double getOrderCost(int ordersize){
			return this.uPrice * ordersize; 
		}	
}
