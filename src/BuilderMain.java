public class BuilderMain {

	public static void main(String[] args) {
		
		
		char[] excludechars = {'1', '2', '3'};
		char[] includechars = {'!', '#', '^', '*'};
		RandBuilder randString = new RandBuilder.Builder(10)
				.isLower(true)
				.isUpper(true)
				.isIncludeNumber(true)
				.excludeChar(excludechars)
				.includeChar(includechars)
				.build();
				
		System.out.println(randString.buildRandString());
	}

}
