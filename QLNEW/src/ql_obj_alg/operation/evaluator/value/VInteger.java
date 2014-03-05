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
	public int compareTo(Value v){
		if(v instanceof VInteger){
			return x.compareTo(v.getInteger());
		}
		assert false : "Compared two incompatible types after typechecking";
		return 0;
	}
	
	
	@Override
	public boolean isUndefined(){
		return false;
	}
}
