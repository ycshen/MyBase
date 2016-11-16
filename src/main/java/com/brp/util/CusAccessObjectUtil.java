package com.brp.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/5/17.
 */
public class CusAccessObjectUtil {
    /**
     * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址,
     *
     * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？
     * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。
     *
     * 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130,
     * 192.168.1.100
     *
     * 用户真实IP为： 192.168.1.110
     *
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }


    /**
     * 验证IP是否属于某个IP段
     * @param ip  所验证的IP号码
     * @param ipSection IP段（以'-'分隔）
     * @return
     */
        public static boolean ipExistsInRange(String ip,String ipSection) {
            ipSection = ipSection.trim();
            ip = ip.trim();
            int idx = ipSection.indexOf('-');
            String beginIP = ipSection.substring(0, idx);
            String endIP = ipSection.substring(idx + 1);
            return getIp2long(beginIP)<=getIp2long(ip) &&getIp2long(ip)<=getIp2long(endIP);

        }

        public static long getIp2long(String ip) {
            ip = ip.trim();
            String[] ips = ip.split("\\.");
            long ip2long = 0L;
            for (int i = 0; i < 4; ++i) {
                ip2long = ip2long << 8 | Integer.parseInt(ips[i]);
            }
            return ip2long;
        }

        public static long getIp2long2(String ip) {

            ip = ip.trim();

            String[] ips = ip.split("\\.");

            long ip1 = Integer.parseInt(ips[0]);

            long ip2 = Integer.parseInt(ips[1]);

            long ip3 = Integer.parseInt(ips[2]);

            long ip4 = Integer.parseInt(ips[3]);

            long ip2long =1L* ip1 * 256 * 256 * 256 + ip2 * 256 * 256 + ip3 * 256 + ip4;

            return ip2long;

        }

        public static void main(String[] args){

            //10.10.10.116 是否属于固定格式的IP段10.10.1.00-10.10.255.255
            String ip="10.10.10.116";

            String ipSection="10.10.1.00-10.10.255.255";

            boolean exists=ipExistsInRange(ip,ipSection);
            System.out.println(exists);
            System.out.println(getIp2long(ip));

        }



}
