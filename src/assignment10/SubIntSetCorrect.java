package assignment10;

public class SubIntSetCorrect extends IntSetCorrect {
	
	private Integer el;
	
	@Override 
	public SubIntSetCorrect clone() throws CloneNotSupportedException {
		SubIntSetCorrect result = (SubIntSetCorrect) super.clone();
		result.el = this.el;	//Immutable, ok
		return result;
	}
	
	public SubIntSetCorrect () { 
		super();
		el=0;
	} 

}
