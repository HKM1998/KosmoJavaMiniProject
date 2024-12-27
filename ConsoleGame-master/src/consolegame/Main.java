package consolegame;

import java.io.IOException;
import java.util.Scanner;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.event.Event;
import consolegame.event.Event000_Start;
import consolegame.thread.EventThread;
import consolegame.thread.LoadingThread;
import consolegame.thread.TitleThread;

public class Main {
	static boolean hasSaveFile = false;
	public static Character character;
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String in = null;
        ConsolePrint.clear();
        
        // 세이브 파일 확인 
        if(SaveFileUtil.isExistSaveFile()) {
        	hasSaveFile = true;
        }
        
        // 메인화면 출력 
        // 입력 키에 따라 시작 종료
        title:
        while(true) {
        	switch (scan.next().toUpperCase()) {
			case "S": 
				TitleThread thread = new TitleThread();
				thread.run();
				break title;
			case "E":
				ConsolePrint.finishGame(scan);
				break;
        	}
        }
        
        if(!hasSaveFile) {
        	// 세이브 파일 없을때
        	character = new Character();
        }
        else {
        	
        }
        
        EventThread eThread = new EventThread(new Event000_Start());
        eThread.scan = scan;
        
	}

}
