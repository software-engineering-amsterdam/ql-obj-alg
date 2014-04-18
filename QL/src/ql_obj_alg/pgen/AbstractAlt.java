package ql_obj_alg.pgen;

public abstract class AbstractAlt implements IAlt, Conventions {
	
	private String nt;
	private int prec;
	
	public AbstractAlt(String nt, int prec) {
		this.nt = nt;
		this.prec = prec;
	}
	
	@Override
	public int getLevel() {
		return prec;
	}
	
	@Override
	public String getNT() {
		return nt;
	}

}
