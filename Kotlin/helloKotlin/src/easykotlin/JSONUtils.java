package easykotlin;

import okhttp3.OkHttpClient;

public class JSONUtils {
    public static  String toJsonString(Object o){
        return o.toString();
    }

    public static void main(String[] args) {
        String url = "https://www.baidu.com";
//        String result = OkhttpUtils.INSTANCE.get(url);
//        System.out.println(result);

    }
}
