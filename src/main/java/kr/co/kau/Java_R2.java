package kr.co.kau;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Java_R2 {
	public static void main(String[] args) throws IOException, InterruptedException {
		
		String dirPath = System.getProperty("user.dir"); //save current directory
		
		String x = "1:10"; //save R command to variable x
		String y = "3*x+1+e"; //save R command to variable y
		String z = "masang";
				
		StringBuffer cmd = new StringBuffer(); //StringBuffer for cmd command
		cmd.append("Rscript");
		cmd.append(" ");
		cmd.append(dirPath);
		cmd.append("\\");
		cmd.append("interaction.R");
		cmd.append(" ");
		cmd.append(dirPath);
/*		cmd.append(" ");
		cmd.append(x);
		cmd.append(" ");
		cmd.append(y);*/
		cmd.append(" ");
		cmd.append(z);
				
		System.out.println(cmd.toString()); 
		//Rscript C:\Users\Curycu\workspace\BoxR\interaction.R C:\Users\Curycu\workspace\BoxR 1:10 3*x+1+e

		Process proc = Runtime.getRuntime().exec(cmd.toString()); 
		//execute on cmd, save process into variable proc (interaction.R is running hear)

		int resultSign = proc.waitFor(); 
		//wait for R process is over, if success return 0, else 1 or 2 or etc
				
		if(resultSign==0){ //case success
			System.out.println("R operation success"); //show success message,
		        System.out.println();

			StringBuffer rOut = new StringBuffer(); //create variable rOut to get result from R
			String inputLine;
			BufferedReader inputBuf = new BufferedReader(new InputStreamReader(proc.getInputStream(), "UTF-8")); 
		        //open input stream with encoding UTF-8
			while (((inputLine = inputBuf.readLine()) != null)) { //get data until the end
				rOut.append(inputLine); //write on variable "rOut"
				rOut.append("\n"); //line seperator : "\n"
			}
			inputBuf.close(); //close input stream
			
			System.out.println(rOut.toString()); //show R response
			
		}else{ //case failure
			System.out.println("R error : "+resultSign);
		}
	}
}
