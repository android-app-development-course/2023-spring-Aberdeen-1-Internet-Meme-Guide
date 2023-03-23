package server

import androidx.lifecycle.Observer
import io.reactivex.disposables.Disposable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import java.io.File
import java.io.InputStream
import java.io.RandomAccessFile

object HttpHelper {
    @JvmStatic
    fun login(account: String, pwd: String) =
        RetrofitManager.instance.createService(ApiService::class.java)
            .login(account,pwd)
            .compose(RxJavaScheduler.compose())
    @JvmStatic
    fun updateFile(url:String, address: RequestBody, partList: List<MultipartBody.Part>)=
        RetrofitManager.instance.createService(ApiService::class.java)
            .updateFile(url,address, partList)
            .compose(RxJavaScheduler.compose())
    @JvmStatic
    fun downFile(url: String, range:Long, file: File, downloadCallback: DownloadCallBack) {
        //断点续传时请求的总长度
        var totalLength = "-"
        if (file.exists()) {
            totalLength += file.length()
        }
        RetrofitManager.instance.createService(ApiService::class.java)
            .download("bytes=" + java.lang.Long.toString(range) + totalLength,url)
            .compose(RxJavaScheduler.compose())
            .subscribe(object : Observer<ResponseBody> {
                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(responseBody: ResponseBody) {
                    var randomAccessFile: RandomAccessFile? = null
                    var inputStream: InputStream? = null
                    var total = range
                    var responseLength: Long = 0
                    try {
                        val buf = ByteArray(2048)
                        var len = 0
                        responseLength = responseBody.contentLength()
                        inputStream = responseBody.byteStream()
                        randomAccessFile = RandomAccessFile(file, "rwd")
                        if (range == 0L) {
                            randomAccessFile.setLength(responseLength)
                        }
                        randomAccessFile.seek(range)
                        var progress = 0
                        var lastProgress = 0
                        while (inputStream.read(buf).also { len = it } != -1) {
                            randomAccessFile.write(buf, 0, len)
                            total += len.toLong()
                            lastProgress = progress
                            progress = (total * 100 / randomAccessFile.length()).toInt()
                            if (progress > 0 && progress != lastProgress) {
                                downloadCallback.onProgress(
                                    randomAccessFile.length(),
                                    total,
                                    progress
                                )
                            }
                        }
                        downloadCallback.onCompleted()
                    } catch (e: Exception) {
                        downloadCallback.onError(e.message)
                        e.printStackTrace()
                    } finally {
                        try {
                            randomAccessFile?.close()
                            inputStream?.close()
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                }

                override fun onError(e: Throwable) {
                    downloadCallback.onError(e.toString())
                }

                override fun onComplete() {
                }

            })
    }
}
