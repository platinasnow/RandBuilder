import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandBuilder {
	
	private int length;
	private boolean isLower;
	private boolean isUpper;
	private boolean isIncludeNumber;
	private char[] excludeChar;
	private char[] includeChar;
	
	private RandBuilder(Builder builder) {
		this.isLower = builder.isLower;
		this.isUpper = builder.isUpper;
		this.isIncludeNumber = builder.isIncludeNumber;
		this.excludeChar = builder.excludeChar;
		this.includeChar = builder.includeChar;
		this.length = builder.length;
	}
	
	public String buildRandString() {
		List<Character> totalList = createTotalList();
		String result = "";
		for (int i = 0; i < this.length; i++) {
			Random rand = new Random();
			result += totalList.get(rand.nextInt(totalList.size()-1));
		}
		return result;
	}
	
	private List<Character> createTotalList() {
		List<Character> list = new ArrayList<Character>();
		if(isUpper) {
			for (int i = 0; i < 26; i++) {
				list.add((char) (i + 65));
			}//A~Z	
		}
		if(isLower) {
			for (int i = 0; i < 26; i++) {
				list.add((char) (i + 97));
			}//a-z	
		}
		if(isIncludeNumber) {
			for (int i = 0; i < 10; i++) {
				list.add((char) (i + '0'));
			}//0~9	
		}
		if(includeChar != null && includeChar.length > 0) {
			for(char item : includeChar) {
				list.add(item); 	//include
			}
		}
		if(excludeChar != null && excludeChar.length > 0) {
			for(char item : excludeChar) {
				list.remove(Character.valueOf(item)); //exclude
			}
		}
		System.out.println(list);
		return list;
	}
	
	public static class Builder {
		private int length = 1;
		private boolean isLower = true;
		private boolean isUpper = true;
		private boolean isIncludeNumber = true;
		private char[] excludeChar;
		private char[] includeChar;
		
		public Builder(int length){
			this.length = length; 
		}
		
		public Builder isLower(boolean val) {
			isLower = val;
			return this;
		}
		
		public Builder isUpper(boolean val) {
			isUpper = val;
			return this;
		}
		
		public Builder isIncludeNumber(boolean val) {
			isIncludeNumber = val;
			return this;
		}
		
		public Builder excludeChar(char[] val) {
			excludeChar = val;
			return this;
		}
		
		public Builder includeChar(char[] val) {
			includeChar = val;
			return this;
		}
		
		public RandBuilder build() {
			return new RandBuilder(this);
		}
	}
	
	

}
