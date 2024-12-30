package consolegame;

import java.io.IOException;
import java.util.Scanner;

import consolegame.character.Character;
import consolegame.console.ConsolePrint;
import consolegame.event.Event;
import consolegame.event.Event000_Start;
import consolegame.event.EventMap;
import consolegame.thread.EventThread;
import consolegame.thread.LoadingThread;
import consolegame.thread.TitleThread;

public class Main {
	static boolean hasSaveFile = false;
	static int eventCount = 0;
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

		TitleThread titleThread = new TitleThread();
		Thread title = new Thread(titleThread);
		title.run();
        // 입력 키에 따라 시작 종료
		if(!hasSaveFile) {
			System.out.println("[S] : 게임시작\t [E] : 게임종료\n");
		}
        title:
        while(true) {
        	switch (scan.next().toUpperCase()) {
			case "S": 
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
        
        EventThread eThread = new EventThread(new Event000_Start(), scan);
        Thread eventThread = new Thread(eThread);
    	
        try {
        	eventThread.start();
        	eventThread.join();
        }catch(InterruptedException e) {
        }

        while(true){
        	// 이벤트 (턴진행)
            try {
            	EventMap eMap = new EventMap(character);
            	eThread = new EventThread(eMap.getEvent(), scan);
                eventThread = new Thread(eThread);
                try {
                	eventThread.start();
                	eventThread.join();
                }catch(InterruptedException e) {
                }
                
                
            }catch(Exception e) {
            	
            }
            
            // 게임 오버
            if(!isAlive()) {
            	
            }
        	eventCount++;
        	if(eventCount > 10) {
        		//엔딩으로 넘어감
        		break;
        	}
        }
        
        
	}
	static boolean isAlive() {
		if(character.getHealth() <= 0)
			return false;
		if(character.getMental() <= 0)
			return false;
		
		return true;
	}

}
