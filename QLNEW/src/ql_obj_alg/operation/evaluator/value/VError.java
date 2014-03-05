package ql_obj_alg.operation.evaluator.value;

public class VError extends VBase {

	@Override
	public int compareTo(Value v) {
		assert false : "Cannot compare Error values";
		return 0;
	}
	
	@Override
	public boolean isError(){
		return true;
	}
}
