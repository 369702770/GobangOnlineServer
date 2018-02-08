package cn.liuxinyumo.GameEngine.util;

/*
 * Server 类 游戏服务器启动入口
 * 作者 刘昕禹
 * 
 * */

import cn.liuxinyumo.GameEngine.service.PlayerConsole;
import cn.liuxinyumo.GameEngine.service.RoomConsole;

public class Server {
	private int port; //端口号
	private PlayerConsole playerConsole;
	private RoomConsole roomConsole;
	private SocketServer socketServer;
	public Server(){
		//游戏服务器创建类
		port = 8888;
		roomConsole = new RoomConsole();
		playerConsole = new PlayerConsole(roomConsole);
	}
	public void SetPort(int p){
		port = p;
	}
	
	public int GetOnlinePlayerTotal(){
		return playerConsole.GetOnlinePlayerTotal();
	}
	
	public int GetRoomTotal(){
		return roomConsole.GetRoomTotal();
	}
	
	public void Start() throws Exception{
		//启动游戏服务器
		//如若启动失败 则抛出异常
		socketServer = new SocketServer(playerConsole,port);
	}
}
