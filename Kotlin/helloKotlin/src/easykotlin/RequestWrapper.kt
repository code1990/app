package easykotlin

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import java.util.concurrent.TimeUnit

class RequestWrapper {
    var url: String? = null
    var method: String? = null
    var body: RequestBody? = null
    var timeout: Long = 0L
    internal var _success: (String) -> Unit = {}
    internal var _fail: (Throwable) -> Unit = {}

    fun onSuccess(onSuccess: (String) -> Unit) {
        _success = onSuccess
    }

    fun onFail(onError: (Throwable) -> Unit) {
        _fail = onError
    }

}

private fun executeForResult(wrapper: RequestWrapper) {
//    Flowable.create<Response>({
//        e
//    })
}

private fun onExecute(wrapper: RequestWrapper): Response? {
    var req: Request? = null
    when (wrapper.method) {
        "get", "Get", "GET" -> req = Request.Builder().url(wrapper.url).build()
        "post", "Post", "POST" -> req = Request.Builder().url(wrapper.url).post(wrapper.body).build()
        "put", "Put", "PUT" -> req = Request.Builder().url(wrapper.url).put(wrapper.body).build()
        "delete", "Delete", "DELETE" -> req = Request.Builder().url(wrapper.url).delete(wrapper.body).build()
    }
    val http = OkHttpClient.Builder().connectTimeout(wrapper.timeout, TimeUnit.SECONDS).build()
    var resp = http.newCall(req).execute()
    return resp
}

fun http(init: RequestWrapper.() -> Unit) {
    val wrap = RequestWrapper()
    wrap.init()
    executeForResult(wrap)
}