package File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MainTest {
	public static void main(String[] args) throws IOException, InterruptedException {
		
	boolean menue=true;
	do {
	Scanner sa=new Scanner(System.in);
	//while(menue) {
		System.out.println("=====Welcome to my project=========");
		System.out.println("=====choose one option=====");
		System.out.println("========================");
		System.out.println("1.writr/read file");
		System.out.println("2.search file");
		
		System.out.println("========================");
		System.out.println("========================");
		System.out.println("========================");
		{
		String bb = sa.next();
		int option = Integer.parseInt(bb);
		switch (option) {
	case 1:
		
	
		//Scanner sa=new Scanner(System.in);
		//System.out.println("Enter name:");
	//	String num =sa.next();
		
		String ur1="https://ipinfo.io/161.185.160.93/geo";
		HttpClient client = HttpClient.newHttpClient();
		System.out.println(ur1);
		HttpRequest request =HttpRequest.newBuilder()
				.uri(URI.create(ur1))
				.build();
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		String res = response.body();
		System.out.println("\n");
		try {
		FileWriter file = new FileWriter ("Filewriter.txt");
		file.write(res.toString());
		file.close();
	
        }catch (IOException e) {
    
             e.printStackTrace();
        }
           System.out.println(" file created");
		
            try {
				FileReader read =new FileReader("Filewriter.txt");
				BufferedReader bufferedReader=new BufferedReader(read);
				String line;
				while ((line= bufferedReader.readLine())!=null) {
					System.out.println(line);
				}read.close();
				} catch (IOException e) {
				      
				      e.printStackTrace();
				    }
            break;
	case 2:
		System.out.println("file created");
      //Reading the words to be found from the user
	      Scanner sc1 = new Scanner(System.in);
	      System.out.println("Enter the words to be found");
         String word = sc1.next();
	      boolean words = false;
	      int count = 0;
	      System.out.println("Contents of the line");
	      //Reading the contents of the file
      Scanner sc2 = new Scanner(new FileInputStream("Filewriter.txt"));
	      while(sc2.hasNextLine()) {
	         String line1 = sc2.nextLine();
	         System.out.println(line1);
         if(line1.indexOf(word)!=-1) {
	        	 words= true;
	            count = count+1;
	         }
	      }
	      if(words) {
	         System.out.println("File contains the specified words");
	         System.out.println("Number of occurrences is: "+count);
	      } else {
	         System.out.println("File does not contain the specified words");
		
	     }
		
		}

	   }

	
	}while (menue =true);
}
}	
		
		
		
		
		
		
		
		
