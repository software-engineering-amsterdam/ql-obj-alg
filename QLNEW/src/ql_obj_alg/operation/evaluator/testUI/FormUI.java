package ql_obj_alg.operation.evaluator.testUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Stack;

import javax.swing.JButton;

import ql_obj_alg.object_algebra_interfaces.IFormAlg;
import ql_obj_alg.operation.evaluator.IDepsAndEvalE;
import ql_obj_alg.operation.evaluator.ValueEnvironment;
import ql_obj_alg.user_interface.modules.FormFrame;

public class FormUI implements IFormAlg<IDepsAndEvalE,ICreate,ICreateF>{

	@Override
	public ICreateF form(final String id, final List<ICreate> s) {
		return new ICreateF(){

			@Override
			public void create(final ValueEnvironment valEnv) {
				final FormFrame frame = new FormFrame(id);
				for(ICreate stmt : s){
					stmt.create(frame, valEnv, new Stack<IDepsAndEvalE>());
				}
				JButton Submit = new JButton("Submit");
				Submit.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0) {
						System.out.println(valEnv.toJsonString());
					}
				});
				frame.addButton(Submit);
				
				frame.render();
				
			}
			
		};
	}

}

