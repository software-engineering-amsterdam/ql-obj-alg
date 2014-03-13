package ql_obj_alg.user_interface.modules;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ql_obj_alg.operation.evaluator.value.Value;
import ql_obj_alg.user_interface.widgets.IWidget;

public class FormFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	JPanel mainPanel;
	JPanel labelPane;
	JPanel fieldPane;
	JPanel buttonPane;
	private IdAndWidgets idWidgets;

	public FormFrame(String id) {
		super(id);		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        labelPane = new JPanel(new InvisibleGridLayout(0,1));
        fieldPane = new JPanel(new InvisibleGridLayout(0,1));
        buttonPane = new JPanel(new InvisibleGridLayout(0,1));
        getContentPane().add(labelPane, BorderLayout.CENTER);
        getContentPane().add(fieldPane, BorderLayout.LINE_END);
        getContentPane().add(buttonPane, BorderLayout.PAGE_END);
        
		JButton Submit = new JButton("Submit");
		Submit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(idWidgets.toJsonString());
			}
		});
		buttonPane.add(Submit);

		idWidgets = new IdAndWidgets();
	}
	
	public void addWidget(String id, IWidget widget){
		idWidgets.addWidget(id, widget);
		addLabel(widget.getLabel());
		addField(widget.getComponent());	
	}
	
	private void addLabel(JLabel label){
		labelPane.add(label);
	}
	
	private void addField(JComponent field){
		fieldPane.add(field);
	}

	public void render() {
        pack();
        setVisible(true);		
	}
	
	public Value getValueOfField(String id){
		return idWidgets.getValue(id);
	}

	public void updateField(String id, Value value){
		idWidgets.setValue(id, value);
	}
}
