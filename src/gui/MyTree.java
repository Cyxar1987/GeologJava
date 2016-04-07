package gui;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.Timer;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

public class MyTree extends JPanel {
	
	JTree myTree;
	JScrollPane scrollTree;
	TreePath treePath;
	JButton jbtAdd, jbtDel;
	
	PassportDialog passDial;
	LitologyDialog litologyDial;
	
	public MyTree() {
		
		super();
		
		GridBagLayout gb = new GridBagLayout();
		setLayout(gb);
		setBackground(Color.BLUE);
		setPreferredSize(new Dimension(300,400));
		
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("База данных");
		myTree = new JTree(top);
		myTree.setEditable(true);
		
		myTree.addMouseListener(new TreeMouseListener(myTree));
		
		
		scrollTree = new JScrollPane(myTree);
		scrollTree.setPreferredSize(new Dimension(250,300));
		
		jbtAdd = new JButton("Добавить");
	    jbtDel = new JButton("Удалить");
	    
	    jbtAdd.addActionListener(new TreeActionListener());
	    jbtDel.addActionListener(new TreeActionListener());
	    
	    jbtAdd.setActionCommand("Add");
	    jbtDel.setActionCommand("Remove");
	    
	    
	    add(scrollTree, new GridBagConstraints(0,0,2,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,
	            new Insets(5, 5, 5, 5), 0, 0));
	    add(jbtAdd, new GridBagConstraints(0,1,1,1,0,0,GridBagConstraints.CENTER,GridBagConstraints.NONE,
	            new Insets(5, 5, 5, 5), 0, 0));
	    add(jbtDel, new GridBagConstraints(1,1,1,1,0,0,GridBagConstraints.EAST,GridBagConstraints.NONE,
	            new Insets(5, 5, 5, 5), 0, 0));
		
		
	}
	
	public void addNewItem()
    {
		// ВАЖНО - работа с уже готовым деревом может производится только через модель дерева.
		// Только в этом случае гарантируется правильная работа и вызов событий
		// В противном случае новые узлы могут быть не прорисованы
		
        DefaultTreeModel model = (DefaultTreeModel)myTree.getModel();
        Object obj = myTree.getLastSelectedPathComponent();
        
        if(obj!=null)
        {
            DefaultMutableTreeNode sel = (DefaultMutableTreeNode)obj;
            // ������� ������� ����������� � �������� � ������������ � ���
            
            if(sel.getLevel()==1) {
                DefaultMutableTreeNode tmp = new DefaultMutableTreeNode("Название объекта");
                model.insertNodeInto(tmp, sel, sel.getChildCount());
            }
            
            if(sel.getLevel()==2) {
                DefaultMutableTreeNode tmp = new DefaultMutableTreeNode("Выработка");
                model.insertNodeInto(tmp, sel, sel.getChildCount());
                
                DefaultMutableTreeNode tmp2 = new DefaultMutableTreeNode("Паспорт скважины");
                model.insertNodeInto(tmp2, tmp, tmp.getChildCount());
                
                DefaultMutableTreeNode tmp3 = new DefaultMutableTreeNode("Литология");
                model.insertNodeInto(tmp3, tmp, tmp.getChildCount());
                
                DefaultMutableTreeNode tmp4 = new DefaultMutableTreeNode("Опробование");
                model.insertNodeInto(tmp4, tmp, tmp.getChildCount());
            }
            
            if(sel.isRoot()) {
                DefaultMutableTreeNode tmp = new DefaultMutableTreeNode("�������������� �������");
                model.insertNodeInto(tmp, sel, sel.getChildCount());
            }
            
            myTree.expandPath(new TreePath(sel.getPath()));
        }
    }
	
	public void removeItem()
    {
        // ������ ��������� � addNewItem()
        DefaultTreeModel model = (DefaultTreeModel)myTree.getModel();
        Object obj = myTree.getLastSelectedPathComponent();
        
        if(obj!=null)
        {
            DefaultMutableTreeNode sel = (DefaultMutableTreeNode)obj;
            
            // ������ ������� ������
            if(!sel.isRoot() && sel.getLevel() <= 3)
            {
                    model.removeNodeFromParent(sel);
            }
        }
    }
	
	public class TreeActionListener implements ActionListener{
		
	@Override
	public void actionPerformed(ActionEvent e){
		
		if (e.getActionCommand().equals("Add"))
		{
        addNewItem();
        }
		
		else
		{
		removeItem();
		}
    }
  }
	
	public class TreeMouseListener extends MouseAdapter {
		 
	    // ���������� ��������� JTable, � �������� ���� �������� � �����������
		
	    private static final String PASSPORT = "������� ��������";
	    private static final String LITOLOGY = "���������";
	    private static final String PROB = "�����������";
		
	    private boolean singleClick  = true;
	    private int doubleClickDelay = 300;
	    private Timer timer;
		private JTree myTree2;
	 
	 
	    public TreeMouseListener(JTree myTree2) {
	 
	        this.myTree2 = myTree2;
	 
	        ActionListener actionListener = new ActionListener() {
	 
	            public void actionPerformed(ActionEvent e) {
	                timer.stop();
	                if (singleClick) {
	                    singleClickHandler(e);
	                } else {
	                    doubleClickHandler(e);
	                }
	            }
	        };
	 
	        timer = new Timer(doubleClickDelay, actionListener);
	        timer.setRepeats(false);
	    }
	 
	 
	    public void mouseClicked(MouseEvent e) {
	 
	        if (e.getClickCount() == 1) {
	            singleClick = true;
	            timer.start();
	        } else {
	            singleClick = false;
	        }
	    }
	 
	 
	    private void singleClickHandler(ActionEvent e) {
	    	
		        System.out.println("-- single click --");	
	    }
	 
	 
	    private void doubleClickHandler(ActionEvent e) {
	    	
	    	DefaultTreeModel model = (DefaultTreeModel)myTree.getModel();
	        
	        Object obj = myTree.getLastSelectedPathComponent();
	        
	    	if (obj != null){
	    		DefaultMutableTreeNode sel = (DefaultMutableTreeNode)obj;
	    		String str = sel.toString();
	    		
	    		if(sel.getLevel() == 4){
	    			
	    			switch (str){
	    			
	    			case PASSPORT:
	    				passDial = new PassportDialog();
	    				break;
	    				
	    			case LITOLOGY:
	    				litologyDial = new LitologyDialog();
	    				break;
	    			
	    			case PROB:
	    				//���� ���
	    				break;
	    			}		
	    		}
	    		
	    	}
	    }
	}
}
