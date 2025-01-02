package consolegame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class SaveFileUtil {
	// 세이브 파일 관련 핸들링
	// 시간 문제로 미구현
	private static String filePath = "C:\\windows\\SAVE.txt";
	// 파일 읽기
	public HashMap<String, String> getSaveFile(){
		HashMap<String, String> fileData = new HashMap<String, String>();
		try (BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))) {
			String str;
			while((str = br.readLine()) != null) {
				fileData.put(str.split(":")[0], str.split(":")[1]);
			}
		}catch (Exception e){
			return null;
		}
		
		return fileData;
	}
	
	public static boolean isExistSaveFile() {
		File file = new File(filePath);
		
		return file.exists();
	}
}
