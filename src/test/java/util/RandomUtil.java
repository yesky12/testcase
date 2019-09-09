package util;

import org.apache.commons.lang3.StringUtils;

import java.rmi.server.ExportException;
import java.util.Random;

public class RandomUtil {

    private RandomUtil() {}

    private static Random rand = new Random(47);

    public static String getRandomServer(String servers) throws ExportException {
        if (StringUtils.isBlank(servers)) {

            throw new ExportException("No server configurated.");
        } else {
            System.out.println("servers = " + servers);
            int a =1;
        }
        String[] urlArr = servers.split(",");
        int idx = rand.nextInt(2);

        return urlArr[idx].trim();
    }
    private String pickUrl() throws ExportException {
        return RandomUtil.getRandomServer("fileServer");
    }
}

