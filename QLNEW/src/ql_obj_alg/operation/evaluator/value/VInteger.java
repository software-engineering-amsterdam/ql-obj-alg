package ql_obj_alg.operation.evaluator.value;

public class VInteger extends VBase {
	
	private Integer x;

	public VInteger(int x){
		this.x = new Integer(x);
	}
	
	@Override
	public Integer getInteger(){
		return x;
	}
	
	@Override
	public boolean equals(Value v){
		if(v instanceof VBoolean){
			return x == v.getInteger();
		}
		return false;
	}
}
