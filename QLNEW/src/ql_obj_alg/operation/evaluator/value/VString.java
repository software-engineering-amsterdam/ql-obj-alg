package ql_obj_alg.operation.evaluator.value;

public class VString extends VBase {

	private String s;

	public VString(String s){
		this.s = s;
	}
	
	public String getString(){
		return s;
	}
	
	@Override
	public int compareTo(Value v){
		if(v instanceof VString){
			return s.compareTo(v.getString());
		}
		assert false : "Compared two incompatible types after typechecking";
		return 0;
	}
	
	
	@Override
	public boolean isUndefined(){
		return false;
	}
}
