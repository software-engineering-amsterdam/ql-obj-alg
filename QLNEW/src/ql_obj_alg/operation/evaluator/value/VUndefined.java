package ql_obj_alg.operation.evaluator.value;

public class VUndefined extends VBase {

	@Override
	public int compareTo(Value v) {
		assert false : "cannot compare undefined values";
		return 0;
	}

}
