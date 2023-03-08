package server

import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.http.*
import java.util.*

interface ApiService {
    @POST("/test/login")
    fun login(@Query("phone") mobile:String, @Query("pwd")pwd: String): Observable<ResultModel<String>>

    /**
     * 文件上传
     * address 上传路径
     */
    @Multipart
    @POST
    fun updateFile(@Url url: String, @Part address: RequestBody, @Part partList: List<MultipartBody.Part>):Observable<ResultModel<String>>

    /**
     * 文件下载服务
     * @param url 下载链接
     */
    @Streaming
    @GET
    fun download(@Header("Range")range:String,@Url url: String ):Observable<ResponseBody>
}
