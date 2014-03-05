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
	public boolean equals(Value v){
		if(v instanceof VBoolean){
			return s.equals(v.getString());
		}
		return false;
	}
}
