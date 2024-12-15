package project;

abstract class PairMap{
	protected String keyArray [];
	protected String valueArray [];
	abstract public String get(String key);
	abstract public void put(String key, String value);
	abstract public String delete(String key);
	abstract public int length();
}

class Dictionary extends PairMap{
	public Dictionary(int size){
		keyArray = new String[10];
		valueArray = new String[10];
	}
	
	public String get(String key) {
		int i = -1;
		for (i = 0; i < keyArray.length-1; i++) {
			if (keyArray[i] != null && keyArray[i].equals(key)) {
                return valueArray[i];
            }
		}
		return (i == -1)?null:valueArray[i];
	}
	
	
	
	public void put(String key, String value) {
		for (int i = 0; i < keyArray.length; i++) {
			if(keyArray[i] != null && keyArray[i].equals(key)) {
				valueArray[i] = value;
				return;
			}
		}
		
		for (int i = 0; i < keyArray.length; i++) {
			if(keyArray[i] == null) {
				keyArray[i] = key;
				valueArray[i] = value;
				return;
			}
		}
	}
	
	public String delete(String key) {
        for (int i = 0; i < keyArray.length; i++) {
            if (keyArray[i] != null && keyArray[i].equals(key)) {
                String oldValue = valueArray[i];
                keyArray[i] = null;
                valueArray[i] = null;
                return oldValue;
            }
        }
        return null;
    }
	
	public int length() {
		int count = 0;
		for (int i = 0; i < keyArray.length; i++) {
			if(keyArray[i] != null)
				count++;
		}
		return count;
	}
}

public class p12 {
	public static void main(String[] args) {
		Dictionary dic = new Dictionary(10);
		dic.put("황기태", "자바");
		dic.put("이재문", "파이썬");
		dic.put("이재문", "C++");
		System.out.println("이재문의 값은 " + dic.get("이재문"));
		System.out.println("황기태의 값은 " + dic.get("황기태"));
		dic.delete("황기태");
		System.out.println("황기태의 값은 " + dic.get("황기태"));
	}
}
