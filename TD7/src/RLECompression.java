import java.io.IOException;
import java.io.Reader;
import java.io.Writer;


public class RLECompression implements ICompression {
	private char flag;

	public RLECompression(char flag) {
		this.flag = flag;
	}
	
	public void compress(Reader data, Writer out) throws IOException {
		String compressed = "";
		int count = 0;
		int charValue = data.read();
		int newCharValue = 0;
		
		while(charValue != -1){
			count = 1;
			newCharValue = data.read();
			
			while(charValue == newCharValue){
				count++;
				newCharValue = data.read();
			}
			
			if((char) charValue == flag){
				for(int i=0; i<count; i++){
					compressed += flag + "0";
				}
			}
			else{
				while(count > 0){
					if(count <= 3){
						for(int i=0; i<count; i++){
							compressed += (char) charValue;
						}
					}
					else{
						if(count >=9){
							compressed += "" + (char) charValue + flag + "9";
						}
						else{
							compressed += "" + (char) charValue + flag + count;
						}
					}
					count -= 9;
				}
			}
			
			charValue = newCharValue;
		}
		
		out.write(compressed);
		out.flush();
	}
	
	public void uncompress(Reader data, Writer out) throws IOException, RLEException {
    	String uncompressed = "";
    	int charValue = 0;
    	while((charValue = data.read()) != -1){
    		if(charValue == flag){
    			int occurence = Character.getNumericValue(data.read());
    			if(occurence > 0){
    				for(int j=0; j<occurence-1; j++){
    					uncompressed = uncompressed.concat("" + charValue);    					
    				}
    			}
    			else if(occurence == 0){
    				uncompressed = uncompressed.concat("" + flag);
    			}
    			else{
    				String substring = "";
    				substring += (char) charValue;
    				while((charValue = data.read()) != -1){
    					substring += (char) charValue;
    				}
    				throw new RLEException("Erreur de décompression : Caractère # incorrect après le flag #\n"
    						+ "décodé à ce stade : " + uncompressed + "\n"
    						+ "non décodé : " + substring + "\n");
    			}
    		}
    		else{
    			uncompressed = uncompressed.concat("" + charValue);
    		}
    	}
    	out.write(uncompressed);
    	out.flush();
	}
	
}
