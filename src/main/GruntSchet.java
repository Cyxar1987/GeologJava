package main;

public class GruntSchet {
	
	private double kM, natureE, warterE, kn, natureE_M, warterE_M;
	
	private String grunt;
	
	final String Suglinok = "Suglinok";
	final String Supec = "Supec";
	final String Glina = "Glina";
	
	final double sup [] = {4, 3.5, 3, 2};
	final double sug [] = {5, 4.5, 4, 3, 2.5, 2};
	final double glina [] = {6, 5.5, 5, 4.5};
	
	final double gran1 = 0.45;
	final double gran2 = 0.55;
	final double gran3 = 0.65;
	final double gran4 = 0.75;
	final double gran5 = 0.85;
	final double gran6 = 0.95;
	final double gran7 = 1.05;
	
	void set_kn(double i){
		if(i <= 0)
			System.out.println("Error!");
		else
		kn = i;
	}
	double get_kn(){
		return kn;
	}
	
	double get_kM(){
		return kM;
	}
	
	void setGrunt(String g){
		grunt = g;
	}
	String getGrunt(){
		return grunt;
	}
	
	void setNatureE(double nE){
	if (nE <= 0)
		System.out.println("Error!");
	else
		natureE = nE;
	}
	double getNatureE(){
		return natureE;
	}
	
	void setWarterE(double wE){
		if (wE <= 0)
			System.out.println("Error!");
		else
			warterE = wE;
	}
	double getWarterE(){
		return warterE;
	}

	double getNatE_M(){
		return natureE_M;
	}
	
	double getWatE_M(){
		return warterE_M;
	}
	
	
	double SchetSup(double kn){             // Расчет коэффициента М для супеси.
	
		if(kn>=gran1 & kn<=gran2){
			kM = sup[0];
			return (double)kM;
		}
		
		else if (kn>gran2 & kn<gran3){
			kM = sup[0]-((kn-gran2)*5);
			return (double)kM;
		}
		
		else if (kn == gran3){
			kM = sup[1];
			return (double)kM;
		}
		
		else if (kn>gran3 & kn<gran4){
		kM = sup[1]-((kn-gran3)*5);
		return	(double)kM;	
		}
		
		else if(kn == gran4){
			kM = sup[2];	
			return (double)kM;
		}
		
		else if (kn>gran4 & kn<gran5){
			kM = sup[2]-((kn-gran4)*10);
			return (double)kM;
		}
		
		else if(kn == gran5){
			kM = sup[3];
			return (double)kM;
		}
		
		else 
			kM = 0;
			return (double)kM;
	}		
	
	double SchetSug(double kn){             // Расчет коэффициента М для суглинка.
	
		if(kn >= gran1 & kn <= gran2){
			kM = sug[0];
			return (double)kM;
		}
		
		else if (kn > gran2 & kn < gran3){
			kM = sug[0]-((kn-gran2)*5);
			return (double)kM;	
		}
		
		else if (kn == gran3){
			kM = sug[1];
			return (double)kM;
		}
		
		else if (kn > gran3 & kn < gran4){
			kM = sug[1]-((kn-gran3)*5);
			return (double)kM; 
		}
		
		else if (kn == gran4){
			kM = sug[2];
			return (double)kM;
		}
		
		else if (kn > gran4 & kn < gran5){
			kM = sug[2]-((kn-gran4)*10);
			return (double)kM; 
		}
		
		else if (kn == gran5){
			kM = sug[3];
			return (double)kM;
		}
		
		else if (kn > gran5 & kn < gran6){
			kM = sug[3]-((kn-gran5)*5);
			return (double)kM; 	
		}
		
		else if (kn == gran6){
			kM = sug[4];
			return (double)kM;	
		}
		
		else if (kn > gran6 & kn < gran7){
			kM = sug[4]-((kn-gran6)*5);
			return (double)kM;	
		}
		
		else if (kn == gran7){
			kM = sug[5];
			return (double)kM;
		}
		
		else
			kM = 0;
			return (double)kM;
		
	} 
	
	double SchetGlina(double kn){           // Расчет коэффициента М для глины.
	
		if (kn >= gran3 & kn <= gran4){
			
			kM = glina[0];
			return (double)kM;
			}
			
		else if (kn > gran4 & kn < gran5){
			
			kM = glina[0] - ((kn - gran4)*5);
			return (double)kM;
			}
			
			else if (kn == gran5) {
				
				kM = glina[1];
				return (double)kM;
			}
			
			else if (kn > gran5 & kn < gran6) {
				
				kM = glina[1] - ((kn - gran5)*5);
				return (double)kM;
			}
			else if (kn == gran6) {
				
				kM = glina[2];
				return (double)kM;
			}
			
			else if(kn > gran6 & kn <gran7){
				
				kM = glina[2] - ((kn - gran6)*5);
				return (double)kM;
			}
			
			else if (kn == gran7){
				
				kM = glina[3];
				return (double)kM;
			}
			
			else
				kM = 0;
				return (double)kM;
	}
	
}

