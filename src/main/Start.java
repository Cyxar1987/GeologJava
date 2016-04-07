package main;

import javax.swing.SwingUtilities;

import gui.MainWindow;


public class Start {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				new MainWindow();
			}
		});
		
		
		
		
		/*
		GruntSchet obj = new GruntSchet();
		
		obj.setGrunt("Suglinok");
		obj.set_kn(-0.741);
		
		if (obj.getGrunt() == obj.Supec) {
			obj.SchetSup(obj.get_kn());
			System.out.println(obj.get_kM()); }
		
		else if (obj.getGrunt() == obj.Suglinok) {
			obj.SchetSug(obj.get_kn());
			System.out.println(obj.get_kM()); }
		
		else if (obj.getGrunt() == obj.Suglinok) {
			obj.SchetSug(obj.get_kn());
			System.out.println(obj.get_kM()); }
			
		else
			System.out.println("Error name of grunt");	
		*/	

	}
}



