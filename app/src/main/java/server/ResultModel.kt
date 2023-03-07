package server

import com.google.gson.annotations.SerializedName

/**
 * 结果返回实体类
 * @param code 错误号
 * @param message 消息
 * @param result 结果实体对象
 */
open class ResultModel<T>(

    @field:SerializedName("code")
    val code: Int? = null,

    @field:SerializedName("msg")
    val message: String? = null,

    @field:SerializedName("result")
    val result: T? = null

)