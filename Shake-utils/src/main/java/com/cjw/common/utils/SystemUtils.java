package com.cjw.common.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by 625389 on 2015/4/10.
 */
public class SystemUtils {
    /**
     * 返回唯一的机器标记
     *
     * 因为生产上有可能有一台虚拟机运行多个JBOSS实例,所以先取环境变量jboss.server.name,如果没有的话，返回
     * InetAddress.getLocalHost().getHostName()
     * @return JBOSS 实例名或者InetAddress.getLocalHost().getHostName()
     * @throws UnknownHostException
     */
    public static String getMachineName() throws UnknownHostException {
        final String jbossServerName = System.getProperty("jboss.server.name");
        if(jbossServerName!=null){
            return jbossServerName;
        }
        return InetAddress.getLocalHost().getHostName();
    }
}
