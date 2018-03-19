package pl.oskarpolak.logsys.models;

import java.util.Date;
import java.util.Random;

public class Utils {
    public static String generateRandomString(int length){
        long date = new Date().getTime();
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        while (stringBuilder.length() <= length - String.valueOf(date).length()){
            char randomChar = (char)(random.nextInt(122 - 48) + 48);
            if((randomChar >= 92 && randomChar <= 96) || (randomChar >= 58 && randomChar <= 63)){
                continue;
            }
            stringBuilder.append(randomChar);
        }

        stringBuilder.append(date);
        return stringBuilder.toString();
    }
}
