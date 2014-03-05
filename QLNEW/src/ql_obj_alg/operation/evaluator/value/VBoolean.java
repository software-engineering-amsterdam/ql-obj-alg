package ql_obj_alg.operation.evaluator.value;

public class VBoolean extends VBase {

	private Boolean b;

	public VBoolean(boolean b){
		this.b = new Boolean(b);
	}
	@Override	
	public Boolean getBoolean(){
		return b;
	}
	
	@Override
	public boolean equals(Value v){
		if(v instanceof VBoolean){
			return b == v.getBoolean();
		}
		return false;
	}
}
