package consolegame.Ending;

public class Ending002_BadEnding extends Ending {

	@Override
	public void printScript() {
		StringBuilder script = new StringBuilder(); // 이벤트 060 Item.007차트 엔딩 선결조건
		script.append("여행을 하던 도중 뭔가 적을 곳이 필요하던 당신은 가방속을 뒤지다");
		script.append("예전에 폐병원에서 가지고 달아났던 차트를 발견합니다.");
		script.append("차트의 빈공간에 글을 적으려는 순간 여기 저기 보이는 핏자국을 발견합니다.");
		script.append("뭔가 호기심이 발동한 당신은 차트를 넘겨보게 됩니다. ");
		script.append("싸이코 닥터의 악필로 써져 있는 그 차트는 분명 그의 끔찍한 실험내용일 것입니다.");
		script.append("그런데 넘기던 중 익숙한 얼굴을 보게 됩니다. 실종된 당신의 친구입니다.");
		script.append("갑자기 당신은 후회가 물밀듯이 밀려옵니다. 그가 무서워서 지나쳤던 폐병원은");
		script.append("바로 실종된 당신의 친구가 죽었던 곳인겁니다.");
		script.append("용기를 조금 냈었다면 친구의 복수를 할 수 있었을텐데..");
		script.append("하는 후회가 당신을 덮쳐오지만 선택을 되돌릴 수는 없습니다.");
		script.append("결국 그는 자신의 비겁함에 대한 원망, 죄책감에 짖눌리다.");
		script.append("결국은 길거리의 부랑자로 살아가게 됩니다.");

	}

}
