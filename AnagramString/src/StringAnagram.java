import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringAnagram {
	private static int noOfCharDelReqired = 0;
	static int makeAnagram(String a, String b) {
		StringAnagram strAna = new StringAnagram();
		HashMap<Character, Integer> hmStr1 = strAna.getTotalCharCountMap(a);
		HashMap<Character, Integer> hmStr2 = strAna.getTotalCharCountMap(b);
		HashMap<Character, Integer> hmStrtoComapre =null;
		HashMap<Character, Integer> hmStrtoComapre2 =null;
		int noOfIteration = 0;
		if(hmStr1.size()==hmStr2.size() || hmStr1.size()>hmStr2.size()) {
			noOfIteration = hmStr1.size();
			hmStrtoComapre = hmStr1;
			hmStrtoComapre2 = hmStr2;
			noOfCharDelReqired = strAna.comapreChars(hmStrtoComapre2,hmStrtoComapre);
			
		} else {
			noOfIteration = hmStr2.size();
			hmStrtoComapre = hmStr2;
			hmStrtoComapre2 = hmStr1;
			noOfCharDelReqired = strAna.comapreChars(hmStrtoComapre2, hmStrtoComapre);
		}
		
		return noOfCharDelReqired;
		
    }
	
	
	
	public int comapreChars(HashMap<Character, Integer> hmStrtoComapre2, HashMap<Character, Integer> hmStrtoComapre) {
		for (Map.Entry<Character, Integer> entry : hmStrtoComapre.entrySet()) {
			int valCount = 0;
		    boolean isValPresent = hmStrtoComapre2.containsKey(entry.getKey());
		    if(isValPresent) {
		    	if(hmStrtoComapre2.get(entry.getKey())==entry.getValue()) {
		    		hmStrtoComapre2.remove(entry.getKey());
		    		continue;
		    		
		    	}
		    	valCount = entry.getValue();
		    	valCount = valCount - hmStrtoComapre2.get(entry.getKey());
		    	noOfCharDelReqired = noOfCharDelReqired + valCount;
	    		hmStrtoComapre2.remove(entry.getKey());
		    } else {
		    	noOfCharDelReqired =noOfCharDelReqired + 1;
		    }
		    // Do things with the list
		}
		noOfCharDelReqired = noOfCharDelReqired + hmStrtoComapre2.size();
		return noOfCharDelReqired;
	}
	
	public HashMap<Character, Integer> getTotalCharCountMap(String a) {
		char [] str1 = a.toCharArray();
		HashMap<Character, Integer> hm1 = null;
		
		for(int i=0; i<str1.length; i++) {
			if(hm1==null) {
				hm1 = new HashMap<>();
				hm1.put(str1[i], 1);
			} else {
				int count = hm1.containsKey(str1[i]) ? hm1.get(str1[i]) : 0;
				hm1.put(str1[i], count+1);
			}
		}
		return hm1;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int noOfCharDelReqiredFinal = StringAnagram.makeAnagram("cbecxJ", "bce");
		System.out.println(noOfCharDelReqiredFinal);
	}

}
