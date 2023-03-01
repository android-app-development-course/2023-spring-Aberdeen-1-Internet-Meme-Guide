package server

import android.content.ContentValues.TAG
import android.os.Build
import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import java.net.URLEncoder


class RetrofitClient {
    private val coroutineServiceApiDev: ServiceApi by lazy { //不清楚by lazy的自行去百度，这是委托模式，可以延迟加载，并且只在首次访问时计算值
        val retrofitClient = Retrofit.Builder()
            .baseUrl(HttpApi.baseIp)
            .client(
                OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger { message ->
                    Log.i(TAG, message)
                }).setLevel(HttpLoggingInterceptor.Level.BODY)
                ).addInterceptor(Interceptor { chain ->
                    //这里就可以添加一些通用请求头了
                    val request: Request = chain.request()
                        .newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .addHeader("version", MyApplication.getInstances().getVersion())
                        .addHeader("deviceId", MyApplication.getInstances().getDeviceid())
                        .addHeader("osType", MyApplication.osType)
                        .addHeader("token",  token)
                        .addHeader("channelCode",MyApplication.getInstances().getChannelNo()+MyApplication.getInstances().getHumeChannel())
                        .addHeader("androidId",MyApplication.getInstances().getAndroidid())
                        .addHeader("ua", URLEncoder.encode(MyApplication.mUa,"UTF-8"))
                        .addHeader("oaid",MyApplication.getInstances().getOaid())
                        .addHeader("imei",MyApplication.getInstances().getIMEI())
                        .addHeader("uuid",MyApplication.getInstances().getuniqueId())
                        .addHeader("vendor", Build.MANUFACTURER)
                        .build()
                    KLogger.e("xiaolitest","当前uuid:"+MyApplication.getInstances().getuniqueId())
                    Log.e("xiaolitest","当前渠道："+MyApplication.getInstances().getChannelNo())
                    chain.proceed(request)
                }).build())
            .addConverterFactory(DsGsonConverterFactory.create())//这里我是把接口返回的值序列化，就像上面说的，同一个项目，后台和客户端的数据返回应该有一些固定约束
            .build()
        retrofitClient.create(ServiceApi::class.java)
    }
    //coroutineServiceApiOnLine我就不贴了，写法完全一样，只是baseUrl不一样而已，一个测试环境的，一个线上环境的

}