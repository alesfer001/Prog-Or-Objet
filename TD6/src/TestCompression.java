
public class TestCompression {

	public static void main(String[] args) throws RLEException {
		String original = "aaaaaaa##bbbbbbaaaaaaaabbbbbbbcccccccccc#a";
		RLECompression myCompression = new RLECompression('#');
		String compressed = myCompression.compress(original);
		String uncompressed = myCompression.uncompress("aa#04ba##4bb#0d");
		System.out.println(compressed);
		System.out.println(uncompressed);
	}

}
