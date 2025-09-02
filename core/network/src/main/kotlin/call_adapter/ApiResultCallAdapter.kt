
package call_adapter

import kotlinx.serialization.json.Json
import model.ApiResult
import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

internal class ApiResultCallAdapter(
    private val resultType: Type,
    private val json: Json,
) : CallAdapter<Type, Call<ApiResult<Type>>> {

    override fun responseType(): Type = resultType

    override fun adapt(call: Call<Type>): Call<ApiResult<Type>> =
        ApiResultCall(proxy = call, json = json, resultType = resultType)
}
