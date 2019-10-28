package common.util;

public class CommonUtils {
    public static boolean isEmptyString(String str){
        if (!"null".equals(str)){
            return true;
        }
        else return false;

    }
}
