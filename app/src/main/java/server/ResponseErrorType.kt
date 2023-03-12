package server

enum class ResponseErrorType(val code:Int, val msg:String) {
    INTERNAL_SERVER_ERROR(500,"服务器出错，请重试"),
    BAD_GATWAY(502,"服务器出错，请重试"),
    NOT_FOUND(404,"服务器找不到资源，请检查路径"),
    CONNECTION_TIMEOUT(408,"连接超时，请重试"),
    CONNECTION_NOT_NETWORK(499,"当前网络不可用，请检查网络"),
    UNEXPECTED_ERROR(700,"未知错误");
}