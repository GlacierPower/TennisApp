import api.responce.player_events.PeriodsTimeRs
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonTransformingSerializer

open class SingleOrListSerializer<T>(
    dataSerializer: KSerializer<T>
) : JsonTransformingSerializer<List<T>>(ListSerializer(dataSerializer)) {

    override fun transformDeserialize(element: JsonElement): JsonElement {
        return when (element) {
            is JsonArray -> element
            is JsonObject -> JsonArray(listOf(element))
            JsonNull -> JsonArray(emptyList())
            else -> error("Unexpected JSON type for SingleOrListSerializer: $element")
        }
    }
}

@InternalSerializationApi
object PeriodsTimeListSerializer :
    SingleOrListSerializer<PeriodsTimeRs>(PeriodsTimeRs.serializer())
