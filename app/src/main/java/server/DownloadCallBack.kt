package server

interface DownloadCallBack {
    fun onProgress(totalLength: Long, currentLength: Long, progress: Int)
    fun onCompleted()
    fun onError(msg: String?)
}
