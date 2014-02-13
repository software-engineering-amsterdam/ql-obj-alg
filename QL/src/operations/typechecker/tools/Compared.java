package operations.typechecker.tools;

public class Compared {
	String var1;
	String var2;
	
	public Compared(String var1, String var2){
		this.var1 = var1;
		this.var2 = var2;
	}
	
	@Override
	public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj == this)
            return true;
        if (!(obj instanceof Compared))
            return false;

        Compared c = (Compared) obj;
        if((this.var1 == c.var1 && this.var2 == c.var2) || (this.var1 == c.var2 && this.var2 == c.var1))
        	return true;
		return false;
    }
}
