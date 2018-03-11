package com.convergence.support.util;

import java.util.UUID;

public class UuidUtil {

    public static String get32UUID() {
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        return uuid;
    }

    /**
     * 
     * @Title: getNUUID @Description: 获得N*8长度的随机串 @param @param N @param @return @return
     *         String @throws
     *
     */
    public static String getNUUID(int N) {
        String temple = "";
        if (N > 1) {
            for (int i = 0; i < N; i++) {
                String radomid =
                        UUID.randomUUID().toString().trim().replaceAll("-", "").substring(0, 8);
                temple += radomid;
            }
        } else {
            temple = UUID.randomUUID().toString().trim().replaceAll("-", "").substring(0, 8);
        }
        return temple.trim();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            String nuuid = UuidUtil.getNUUID(2);
            System.out.println(nuuid.length());
            System.out.println(nuuid);
        }
    }
}
