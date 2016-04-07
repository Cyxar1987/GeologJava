package gui; 

import java.awt.*;
import javax.swing.event.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.*;


public class MainWindow{
	
	JFrame jfrm;
	JPanel panel1;
	MyTree tree1;
	
	public MainWindow(){
		
		jfrm = new JFrame("GeoModule");
		jfrm.setLocationRelativeTo(null);
		jfrm.setSize(650, 450);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridBagLayout gb = new GridBagLayout();
		jfrm.setLayout(gb);
		
		panel1 = new JPanel();
		panel1.setBackground(Color.GREEN);
		panel1.setPreferredSize(new Dimension(300,400));
		
	    tree1 = new MyTree();
		
	    jfrm.add(tree1, new GridBagConstraints(0,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
	            new Insets(1, 1, 1, 1), 0, 0));
	    jfrm.add(panel1, new GridBagConstraints(1,0,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
	            new Insets(5, 5, 5, 5), 0, 0));

	    jfrm.setVisible(true);
					
	}
	
}
