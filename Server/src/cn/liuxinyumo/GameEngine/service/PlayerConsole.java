package cn.liuxinyumo.GameEngine.service;

import cn.liuxinyumo.GameEngine.vo.Player;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/*
 * 玩家管理类
 * 
 * */

public class PlayerConsole {
	private List<Player> players ;
	private RoomConsole roomConsole;
	public PlayerConsole(RoomConsole roomcon){
		players = new ArrayList<>();
		roomConsole = roomcon;
	}
	public void AddClient(Socket s){
		//需要验证是否身份合法
		if(!CheckID(s))
			return;
		Player p = new Player(s,roomConsole,this);
		players.add(p);
	}
	private boolean CheckID(Socket s){
		return true;
	}
	public void Del(Player p){
		players.remove(p);
	}
	public int GetOnlinePlayerTotal(){
		return players.size();
	}
}
