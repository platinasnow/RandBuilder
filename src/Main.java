import java.io.File;
import java.io.FileWriter;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		char[] list = getTotalList();
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < 10000; i++) {
			str.append(createRandCoupon(list, 5));
			str.append("\r\n");
		}
		File file = new File("C:\\Users\\Sanghak\\Documents\\TODO\\test.txt");
		try {
			FileWriter fw = new FileWriter(file);
			fw.write(str.toString());
			fw.close();
		} catch (Exception e) {
			System.out.println("파일 쓰기 실패 : " + e.getMessage());
		}
		System.out.println("end");
	}

	private static char[] getTotalList() {
		char[] list = new char[36];
		for (int i = 0; i < 26; i++) {
			list[i] = (char) (i + 65);
		}
		for (int i = 0; i < 10; i++) {
			list[i + 26] = (char) (i + '0');
		}
		System.out.println(list);
		return list;
	}

	private static String createRandCoupon(char[] charList, int length) {
		String result = "";
		for (int i = 0; i < length; i++) {
			Random rand = new Random();
			result += charList[rand.nextInt(35)];
		}
		return result;
	}
}
