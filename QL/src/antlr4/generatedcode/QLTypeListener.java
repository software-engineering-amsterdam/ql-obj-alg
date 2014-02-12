package antlr4.generatedcode;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;


public class QLTypeListener extends QLBaseListener {
	QLParser parser;
	 
	 
	 
	public QLTypeListener( QLParser parser){
		this.parser = parser;
	}
	public void enterDecl(@NotNull QLParser.DeclContext ctx) {
		String id="";
		if ( ctx.ID()!=null ) {
			id = ctx.ID().getSymbol().getText();
			System.out.println("ID is called : " + id);
			
		}
	}
	
	public void enterINT(@NotNull QLParser.INTContext ctx){
		int id =-1;
		if ( ctx.INT()!=null ) {
			id = Integer.parseInt(ctx.INT().getSymbol().getText());
			System.out.println("ID is called : " + id);			
		}
	}
}