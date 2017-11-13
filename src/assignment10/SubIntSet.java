package assignment10;

public class SubIntSet extends IntSet {
	
	private Integer el;
	
	@Override 
	public SubIntSet clone() {
		SubIntSet result = (SubIntSet) super.clone();
		result.el = this.el;	//Immutable, ok
		return result;
	}
	
	public SubIntSet () { 
		super();
		el=0;
	} 

}
