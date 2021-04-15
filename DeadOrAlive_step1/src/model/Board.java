package model;

import java.util.ArrayList;
import java.util.List;

public class Board {
	// 보드 크기
	public static final int WIDTH = 1000, HEIGHT = 1000;
	// 캐릭터 기본 위치
	public static final int XPOSOFCHARACTER = WIDTH / 2;
	// 폭탄, 사과의 기본 속도 설정
	private static final int TIME = 4;
	public static final int BASICSPEED = HEIGHT / TIME;

	private List<Thing> things = new ArrayList<>();

	public void load(Thing thing) { // player, bomb, apple을 통칭시켜서 기억
		things.add(thing);
	}
}
