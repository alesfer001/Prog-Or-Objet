
public class RLECompression implements ICompression {
	private char flag;

	public RLECompression(char flag) {
		this.flag = flag;
	}
	
	public String compress(String data){
		String compressed = "";
		int count = 1;
		for(int i=0; i<(data.length()-1); i++){
			if(data.charAt(i) == flag){
				compressed = compressed.concat(flag + "0");
			}
			else if(data.charAt(i) == data.charAt(i+1)){
				count++;
				if(count == 9){
					compressed = compressed.concat("" + data.charAt(i) + flag + count);
					count = 1;
					i++;
				}
			}
			else{
				if(count >= 4){
					compressed = compressed.concat("" + data.charAt(i) + flag + count);
				}
				else{
					for(int j=0; j<count; j++){
						compressed = compressed.concat("" + data.charAt(i));					
					}
				}
				count = 1;
			}
		}
		if(data.charAt(data.length()-1) == data.charAt(data.length()-2)){
			if(count >= 4){
				compressed = compressed.concat("" + data.charAt(data.length()-1) + flag + count);
			}
			else{
				for(int j=0; j<count; j++){
					compressed = compressed.concat("" + data.charAt(data.length()-1));					
				}
			}
			
		}
		else{
			compressed = compressed.concat("" + data.charAt(data.length()-1));
		}
		return compressed;
	}
	
    public String uncompress(String data) throws RLEException{
    	String uncompressed = "";
    	for(int i=0; i<data.length(); i++){
    		if(data.charAt(i) == flag){
    			int occurence = Character.getNumericValue(data.charAt(i+1));
    			if(occurence > 0){
    				for(int j=0; j<occurence-1; j++){
    					uncompressed = uncompressed.concat("" + data.charAt(i-1));    					
    				}
    			}
    			else if(occurence == 0){
    				uncompressed = uncompressed.concat("" + flag);
    			}
    			else{
    				throw new RLEException("Erreur de décompression : Caractère # incorrect après le flag #\n"
    						+ "décodé à ce stade : " + uncompressed + "\n"
    						+ "non décodé : " + data.substring(i) + "\n");
    			}
    			i++;
    		}
    		else{
    			uncompressed = uncompressed.concat("" + data.charAt(i));
    		}
    	}
    	return uncompressed;
    }
	
}
