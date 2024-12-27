package consolegame.console;

import java.io.IOException;

public class ConsolePrint {
	// 화면 클리어
	@SuppressWarnings("deprecation")
	public static void clear() {
        for (int i = 0; i < 60; i++) {
            System.out.println("");
        }
        
        try {
        	Runtime.getRuntime().exec("cls");
        }catch(IOException e) {
        	
        }
    }
	
	// 일반 출력
	public static void printConsole(StringBuilder pSb) {
		System.out.println(pSb.toString());
	}

	public static void printScript(StringBuilder pSb) {
		System.out.println("=".repeat(30) + "\n");
		System.out.println(pSb.toString());
		System.out.println("=".repeat(30) + "\n");
	}
	
	// 선택지 출력
	public static void printSelection(StringBuilder pSb) {
		String[] selection= pSb.toString().split("\n");
		System.out.println();
		for(String str : selection) {
			System.out.println("-".repeat(30) + "\n");
			System.out.println(str);
			System.out.println("-".repeat(30) + "\n");
		}
	}
	
	// 선택지에 따른 결과 출력
	public static void printResult(StringBuilder pSb) {
		clear();
		
	}
}
