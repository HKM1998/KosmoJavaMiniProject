package consolegame;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SaveFileUtil {
	// 세이브 파일 관련 핸들링
	// 추후 저장 데이터 형식에 따라서 값을 읽고/쓰는 기능 추가
	private static String filePath = "C:\\windows\\SAVE.txt";
	// 파일 읽기
	public List<String> getSaveFile(){
		List<String> fileList = new ArrayList<String>();
		
		return fileList;
	}
	
	public static boolean isExistSaveFile() {
		File file = new File(filePath);
		
		return file.exists();
	}
}
