package ql_obj_alg.pgen.util;


public interface IAlt extends Comparable<IAlt> {
	int getLevel();
	String getNT();
	
	default int compareTo(IAlt o) {
		return new Integer(o.getLevel()).compareTo(getLevel());
	}
}
