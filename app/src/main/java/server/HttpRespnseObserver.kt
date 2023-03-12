package server

import androidx.lifecycle.Observer
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import io.reactivex.rxjava3.disposables.Disposable
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * 回调处理
 */
abstract class HttpResponseObserver<T>: Observer<T> {
    abstract val ResponseErrorType: Any

    override fun onComplete() {
    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(t: T) {
        success(t)
        finish()
    }

    override fun onError(e: Throwable) {
        if(e is HttpException){
            var msg=""
            when(e.code()){
                server.ResponseErrorType.INTERNAL_SERVER_ERROR.code->msg=
                    server.ResponseErrorType.INTERNAL_SERVER_ERROR.msg
                server.ResponseErrorType.BAD_GATWAY.code->msg= server.ResponseErrorType.BAD_GATWAY.msg
                server.ResponseErrorType.NOT_FOUND.code->msg= server.ResponseErrorType.NOT_FOUND.msg
                server.ResponseErrorType.CONNECTION_TIMEOUT.code->msg= server.ResponseErrorType.CONNECTION_TIMEOUT.msg
                server.ResponseErrorType.CONNECTION_NOT_NETWORK.code->msg= server.ResponseErrorType.CONNECTION_NOT_NETWORK.msg
            }
            failure(e.code(),msg)
            finish()
            return
        }

        val responseErrorType: ResponseErrorType = when (e) {
            is UnknownHostException -> server.ResponseErrorType.CONNECTION_NOT_NETWORK
            is ConnectException -> server.ResponseErrorType.CONNECTION_NOT_NETWORK
            is SocketTimeoutException -> server.ResponseErrorType.CONNECTION_TIMEOUT
            else -> server.ResponseErrorType.UNEXPECTED_ERROR
        }
        failure(responseErrorType.code,responseErrorType.msg)
        finish()
    }

    /**
     * 成功的回调
     */
    abstract fun success(data: T)

    /**
     * 失败的回调
     */
    abstract fun failure(code: Int, error: String)

    /**
     * 执行结束
     */
    abstract fun finish()
}