package consolegame;

import java.util.Scanner;

import consolegame.thread.LoadingThread;

public class Main {
	public static void printSpace() {
        for (int i = 0; i < 60; i++) {
            System.out.println("");
        }
    }
    public static void printWrongInputMessage() {
        printSpace();
        System.out.println("<잘못 입력하셨습니다. 다시 입력해주세요.>");
        System.out.println("");
    }
    public static void finishGame(Scanner scan) {

        while (true) {
            for (int i = 0; i < 60; i++) {
                System.out.println("");
            }
            System.out.println("게임을 종료하시겠습니까?");
            System.out.println("1. 네        2. 아니오");
            System.out.println("");
            System.out.print("입력:");
            String real_ending = scan.next();
            if (real_ending.equals("1")) {
                printSpace();

                Thread finishGame = new Thread(new LoadingThread("finishGame"));
                finishGame.start();
                try {
                    finishGame.join();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                scan.close();
                System.exit(0);
            } else if (real_ending.equals("2")) {
                break;
            } else {
                printWrongInputMessage();
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        
	}

}
