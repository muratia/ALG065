import java.io.*;
import javax.swing.JOptionPane;

public class ALG065 {
	
	private JOptionPane JOP = new JOptionPane();
	private double a[][] = null;
	
	private double out[][] = null;
	private double d[] = null;
	private double v[] = null;
		
		
	public void input (int n)
	{
		
		a = new double[n][n];
	
		System.out.println ("\n\nTermat e matric‰s:\n");
		for(int i=0; i<n;i++){
			for(int j=0; j<n;j++) {
				String msg = "\ta["+(i+1)+"]["+(j+1)+"] =";
				System.out.print (msg);
				a[i][j] =  Double.parseDouble(readString());
			}
			System.out.println ();
		}
		
		out = new double [n][n];
		out = pastroje(out);			
		for(int i=0; i<n;i++) {
			for(int j=0; j<n;j++) {
				out[i][j]=a[i][j];
			}
		}
		System.out.println ("Matrica q‰ duhet t‰ faktorizohet\n");
		for(int i=0; i<n;i++) {
			for(int j=0; j<n;j++) {
				System.out.print (out[i][j]+"\t");
			}
			System.out.println ();
		}
		System.out.println ();
		

		process(true,a,n);
	}
	
	/**
     * metoda që bën faktorizimin e matricës sipas LDL^t
     */
	public void process(boolean OK, double a[][],int n) {
		

		d = new double [n];
		v = new double [n]; 
	 if (OK) {
      /* HAPI I */
      for (int i=1; i<=n; i++) { 
         /* HAPI II */
         for (int j=1; j<=i-1; j++) 
         {
         	
         v[j-1] = 
         a[i-1][j-1] * 
         d[j-1];
      	}
         /* HAPI III */
         d[i-1] = a[i-1][i-1];
         for (int j=1; j<=i-1; j++) d[i-1] = d[i-1] - a[i-1][j-1] * v[j-1];
         /* HAPI IV */
         for (int j=i+1; j<=n; j++) {
            for (int k=1; k<=i-1; k++)
               a[j-1][i-1] = a[j-1][i-1] - a[j-1][k-1] * v[k-1];
            a[j-1][i-1] = a[j-1][i-1] / d[i-1];
         }  
      }  
      /* HAPI V */
      output(n, d, a);
		
		 }	
	}
	

	public void output(int n, double d[], double [][] l) {
		out = new double[n][n];
		out = pastroje(out);

   		System.out.println( "Matrica L:\n");
   		for (int i=1; i<=n; i++) {
      		for (int j=1; j<=i-1; j++) 
	      		 out[i-1][j-1] = l[i-1][j-1];
 	  		}
   		
   		for (int i=1; i<=n; i++) {
   			out[i-1][i-1]=1;
		}
   		
   		for (int i=1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				System.out.print (out[i-1][j-1]+"\t");
			}
			System.out.println ();
		}
		
		double [][] outT = transponoje(out);
		out = pastroje(out);
   		
   		System.out.println ("\n\nDiagonalja D:\n");
 
   		for (int i=1; i<=n; i++) 
   			out[i-1][i-1]=d[i-1];
   		 
   		for (int i=1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				System.out.print (out[i-1][j-1]+"\t");
			}
			System.out.println ();
		}
		
		
		System.out.println ("\n\nMatrica L e transponuar\n");
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=n; j++) {
				System.out.print (outT[i-1][j-1]+"\t");
			}
			System.out.println ();
		}
		
		
		
		
			
	}
	
		
	public String readString() {
		String res = null;
		
		java.io.BufferedReader streami = new java.io.BufferedReader(
		    	new java.io.InputStreamReader(System.in));
		
		try {
			res = streami.readLine();
	    }
	    catch (java.io.IOException ex) {
	    	System.out.println (ex.getMessage());
	    }
	    return res;
	}
	
	
	public static void main(String [] args){
		
		System.out.println("LDL^t FAKTORIZIMI\n\n");
    	ALG065 ldlAlg = new ALG065();
    	System.out.print("T‰ caktohet n= ");
    	ldlAlg.input(Integer.parseInt(ldlAlg.readString()));
    	
    	
    	System.out.println ("it is done");
    }
    
    public double [][] transponoje(double x[][]) {
    	int n = x.length;
    	double res [] [] = new double[n][n];
    	
    	for (int i=1; i<=n; i++) 
			for (int j=1; j<=n; j++) {
				res[j-1][i-1] = x[i-1][j-1];
				
		}
		return res;
	}
	
	
	public double [][] pastroje(double x [][]){
		int n = x.length;
		for (int i=1; i<=n; i++) 
			for (int j=1; j<=n; j++) {
				x[i-1][j-1]=0;
			}
		return x;
	}
    
	
}