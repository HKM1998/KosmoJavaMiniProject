package consolegame.thread;

public class LoadingThread implements Runnable{
	private String type;//로딩스레드 실행시 어떤 로딩 메소드를 쓸지 지정하기 위해 존재하는 변수

	public void setType(String type) {
		this.type = type;
	}
	public LoadingThread(){
	}
	public LoadingThread(String type){//객체를 생성할 때 입력하는 타입에 따라 실행되는 로딩 메소드가 달라지게끔 설정
		this.type=type;
	}
	
	public void executeLoading() {
		for(int i=0; i<60; i++) {
			System.out.println("");
		}
		System.out.print("로딩중");
		for(int i=0; i<20; i++ ) {
			System.out.print('.');
		
			try {
				Thread.sleep(140);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int i=0; i<60; i++) {
			System.out.println("");
		}
	}
	
	public void executeFinishGame() {

		for(int i=0; i<60; i++) {
			System.out.println("");
		}
		System.out.print("게임을 종료합니다");
		for(int i=0; i<10; i++ ) {
			System.out.print('.');

			try {
				Thread.sleep(140);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int i=0; i<60; i++) {
			System.out.println("");
		}
	}
	
	public void executeMovoToNextEvent() {
		System.out.print("이동중");
		for(int i=0; i<15; i++ ) {
			System.out.print('.');

			try {
				Thread.sleep(140);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int i=0; i<60; i++) {
			System.out.println("");
		}
	}
	
	public void executeInitCharacter() {
		for(int i=0; i<60; i++) {
			System.out.println("");
		}
		System.out.print("케릭터 정보 생성중");
		for(int i=0; i<20; i++ ) {
			System.out.print('.');

			try {
				Thread.sleep(140);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for(int i=0; i<60; i++) {
			System.out.println("");
		}
	}
	
	
	
	@Override
	public void run() {
		switch(type) {
			case "loading"://로딩중 실행
				executeLoading();
				break;
			case "finishGame"://게임종료시 실행
				executeFinishGame();
				break;
			case "moveToNextEvent"://다음 이벤트로 이동할 때 실행
				executeMovoToNextEvent();
				break;
			case "initCharacter"://케릭터 정보 생성시 실행
				executeInitCharacter();
				break;
		}
	}
}