package com.maple.base;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by gl on 2014/7/24.
 */
@Data
public class UserAgent {

    public final static String UserAgentStr = "User-Agent";

    /**
     * app 类型
     */
    private String appType;

    /**
     * 客户端类型
     */
    private String clientAppId;

    /**
     * 设备类型
     */
    private String deviceType;

    /**
     * 设备信息
     */
    private String deviceInfo;

    /**
     * 版本号
     */
    private String versionStr;



	/*
	 * public static void main(String[]args) { String agent =
	 * "1.6.0.2017031602/android_Dalvik/2.1.0 (Linux; U; Android 5.0.2; vivo Y35A Build/LRX22G)"
	 * ; // parser(agent); // System.out.println("====="); // agent =
	 * "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.80 Safari/537.36"
	 * ; // parser(agent); // System.out.println("====="); agent =
	 * "DGroupBusiness/1.6.170316.01/iPhone; iOS 10.2.1"; agent =
	 * "DGroupShop/1.3030201.127/android_Dalvik/1.6.0 (Linux; U; Android 4.4.4; HM 2A MIUI/V8.1.2.0.KHLCNDI)"
	 * ; agent=
	 * "DGroupDoctor/1.9.021401.507/android_Dalvik/1.6.0 (Linux; U; Android 4.4.4; HM 2A MIUI/V8.2.1.0.KHLCNDL)"
	 * ; // parser(agent);
	 * 
	 * System.out.println(isVersion("0.6.0170316.01q")); }
	 */

	// user-agent:
	// MedicalCircle/1.8.1.04091727/031/android/Honor_Che1-CL20/EmotionUI_3.0/mobile

	public static UserAgent resolveAgentInfo(String userAgentInfo) {
		if (StringUtils.isEmpty(userAgentInfo)) {
			return null;
		}
		UserAgent agentInfo = new UserAgent();
		String[] itemArray = userAgentInfo.split("/");
		if (itemArray.length > 0) {
			agentInfo.setAppType(itemArray[0].trim().toLowerCase());
		}
		if (itemArray.length > 1) {
			String versionStr = itemArray[1].trim();
			agentInfo.setVersionStr(versionStr);
		}
		if (itemArray.length > 2) {
			agentInfo.setClientAppId(itemArray[2].trim().toLowerCase());
		}
		if (itemArray.length > 3) {
			agentInfo.setDeviceType(itemArray[3].trim().toLowerCase());
		}
		if (itemArray.length > 4) {
			agentInfo.setDeviceInfo(itemArray[4].trim());
		}
		return agentInfo;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
