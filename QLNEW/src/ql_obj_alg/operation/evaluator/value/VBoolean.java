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
	public int compareTo(Value v){
		if(v instanceof VBoolean){
			return b.compareTo(v.getBoolean());
		}
		assert false : "Compared two incompatible types after typechecking";
		return 0;
	}
	
	@Override
	public boolean isUndefined(){
		return false;
	}
}
