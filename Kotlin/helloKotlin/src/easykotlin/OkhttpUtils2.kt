package easykotlin

import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.io.IOException
import java.util.concurrent.TimeUnit

class OkhttpUtils2 {
    fun get(url: String): String? {
        var result: String? = ""
        val okhttp = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .writeTimeout(1, TimeUnit.SECONDS)
            .build()

        val request = Request.Builder()
            .url(url)
            .build()

        val call = okhttp.newCall(request)
        try {
            val response = call.execute()
            result = response.body()?.toString()
            val f = File("run.log")
            f.appendText(result!!)
            f.appendText("\n")
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return result
    }
}