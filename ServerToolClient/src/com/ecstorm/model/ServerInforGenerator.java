package com.ecstorm.model;

public class ServerInforGenerator {
	public static ServerInfor getServerInfor(int inforType) {
		ServerInfor si = null;
		switch (inforType) {
			case 0:
				si = new ServerInforCpu();
				break;
			case 1:
				si = new ServerInforMemory();
				break;
			case 2:
				si = new ServerInforDisk();
				break;
			case 3:
				si = new ServerInforNginx();
				break;
			case 4:
				si = new ServerInforMysql();
				break;
			case 5:
				si = new ServerInforPhpfpm();
				break;
			case 6:
				si = new ServerInforUwsgi();
				break;
			case 7:
				si = new ServerInforGunicorn();
				break;
		}
		return si;
	}
}
