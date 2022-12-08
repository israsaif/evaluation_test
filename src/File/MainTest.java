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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class MainTest {

	private static final String Scanner = null;

	public static void main(String[] args) throws IOException, InterruptedException {
		// Scanner sa = new Scanner(System.in);
		boolean menue = true;
		do {
			Scanner sa1 = new Scanner(System.in);
			// while(menue) {
			System.out.println("=====Welcome to my project=========");
			System.out.println("=====choose one option=====");
			System.out.println("========================");

			System.out.println("1.write/ read file");
			System.out.println("2.search file");
			System.out.println("3.pdf file/move pdf file");
			
			System.out.println("========================");
			System.out.println("========================");

			{
				String bb = sa1.next();
				int option = Integer.parseInt(bb);
				switch (option) {
				case 1:

					// System.out.println(" choose pdf or txt ");
					// int oneOption = sa.nextInt();
//					System.out.println("do you want to txt file press 1//");
//					int txtFile = sa.nextInt();
//					if (txtFile == 1) {

					String ur1 = "https://ipinfo.io/161.185.160.93/geo";
					HttpClient client = HttpClient.newHttpClient();
					System.out.println(ur1);
					HttpRequest request = HttpRequest.newBuilder().uri(URI.create(ur1)).build();
					HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
					String res = response.body();
					System.out.println("\n");
					try {
						FileWriter file = new FileWriter("Filewriter.txt");
						file.write(res.toString());
						file.close();

					} catch (IOException e) {

						e.printStackTrace();
					}
					System.out.println(" file created");

					try {
						FileReader read = new FileReader("Filewriter.txt");
						BufferedReader bufferedReader = new BufferedReader(read);
						String line;
						while ((line = bufferedReader.readLine()) != null) {
							System.out.println(line);
						}
						read.close();
					} catch (IOException e) {

						e.printStackTrace();

					}

					// if (pdfFile == 2) {

					break;

				case 2:

					System.out.println("file created");
					// Reading the words to be found from the user
					Scanner sa = new Scanner(System.in);
					ArrayList<String> theDuplicateString = new ArrayList<>();
					Set<String> uniqueStringHS = new HashSet();

					System.out.println("How many word string do you want to enter");
					int amtOfWord = sa.nextInt();
					for (int i = 0; i < amtOfWord; i++) {
						System.out.println("Enter the words to be found");
						String word = sa.next();
						String theDuplicteString;
						if (!theDuplicateString.contains(word)) {
							theDuplicateString.add(word);
						}

						boolean words = false;
						int count = 0;
						System.out.println("Contents of the line");
						// Reading the contents of the file
						Scanner sc2 = new Scanner(new FileInputStream("Filewriter.txt"));
						while (sc2.hasNextLine()) {
							String line1 = sc2.nextLine();
							System.out.println(line1);
							if (line1.indexOf(word) != -1) {
								words = true;
								count = count + 1;
							}
						}
						if (words) {
							System.out.println("File contains the specified words");
							System.out.println("Number of occurrences is: " + count);

						} else {
							System.out.println("File does not contain the specified words");

						}
					}

					break;

				case 3:
					boolean isExit = true;

					while (isExit) {

						Scanner sc = new Scanner(System.in);

						System.out.println("**********************************");
						// Reading the word to be found from the user
						System.out.println("Enter the word you want to search pdf ");
						String input = sc.next();

						// consuming the <enter> from input above
						sc.nextLine();
						boolean word2 = false;
						int wordCount = 0;

						// Reading the String of the file
						Scanner sc11 = new Scanner(new FileInputStream("sample.pdf"));
						while (sc11.hasNextLine()) {
							String word1 = sc11.nextLine();
							// System.out.println(line);
							if (word1.indexOf(input) != -1) {
								word2 = true;
								wordCount = wordCount + 1;
							}
						}
						if (word2) {
							System.out.println("PDF File contains the  word");
							System.out.println("Number of word is: " + wordCount);
							System.out.println("__________________________________");
							Path temp=Files.copy(Paths.get("C:\\Users\\User006\\Desktop\\sample.pdf"),Paths.get("C:\\Users\\User006\\Desktop\\pdf\\sample2.pdf"));
							if (temp!=null) {
								System.out.println("The file was moves successfuly");
							}

						} else {
							System.out.println("PDF File does not contain the word");
							System.out.println("__________________________________");

						}
						System.out.println("if you want to search another word press 1 and 2 to exit ");
						Integer s = sc.nextInt();
						if (s == 1) {
							isExit = true;
						} else if (s == 2) {
							isExit = false;
							System.out.println("Exit");
						}

					}
					break;
				
				}
			}
		} while (menue = true);
	}
}
