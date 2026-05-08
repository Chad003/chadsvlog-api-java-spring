package com.cms.chadsvlog.utils;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;
import java.util.UUID;

@Component
public class RandomGenerator {
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    public String generateOtp(){
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000));
    }

    public String generateCustomerId(){ return generateRandomId("KTV",20); }

    public String generateRandomId(String prefix, int totalLength){
        if (prefix == null) prefix = "";
        if (totalLength <= prefix.length()) {
            throw new IllegalArgumentException("Total Length must be greater than prefix length");
        }
        int randomLength = totalLength - prefix.length() - 4;
        String randomPart = generateSecureRandomAlphanumeric(randomLength);
        long nano = System.nanoTime();
        String nanoSuffix = Long.toString(nano % 1_000_000, 36).toUpperCase();
        return (prefix + randomPart + nanoSuffix).toUpperCase();
    }

    private static String generateSecureRandomAlphanumeric(int length) {
        if (length <= 0) return "";

        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int r = SECURE_RANDOM.nextInt(36);
            char c = (r < 10) ? (char) ('0' + r) : (char) ('A' + r - 10);
            sb.append(c);
        }
        return sb.toString();
    }

    public String generateToken(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
