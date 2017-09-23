package cn.itcast.customer.util;

import java.util.UUID;

public class IdUtils {
	
	public static String getUUId(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
