import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class TestCompression {

	public static void main(String[] args) throws IOException, RLEException {
		//String original = "aaaaaaa##bbbbbbaaaaaaaabbbbbbbcccccccccc#a";
		RLECompression myCompression = new RLECompression('#');
		BufferedReader in = new BufferedReader(new FileReader("foo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("foo.out")));
		
		myCompression.compress(in, out);
		//myCompression.uncompress(out, in);
		
		in.close();
		out.close();
	}

}
