package model.common.country_flag

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.decodeStructure
import kotlinx.serialization.encoding.encodeStructure

@Serializable(with = CountryInfoModelSerializer::class)
data class CountryInfoModel(
    val error: Boolean,
    val msg: String,
    val data: List<CountryModel>
)

object CountryInfoModelSerializer : KSerializer<CountryInfoModel> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("CountryInfoModel") {
        element<Boolean>("error")
        element<String>("msg")
        element<List<CountryModel>>("data")
    }

    override fun serialize(encoder: Encoder, value: CountryInfoModel) {
        encoder.encodeStructure(descriptor) {
            encodeBooleanElement(descriptor, 0, value.error)
            encodeStringElement(descriptor, 1, value.msg)
            encodeSerializableElement(descriptor, 2, ListSerializer(CountryModel.serializer()), value.data)
        }
    }

    override fun deserialize(decoder: Decoder): CountryInfoModel {
        return decoder.decodeStructure(descriptor) {
            var error = false
            var msg = ""
            var data = emptyList<CountryModel>()

            while (true) {
                when (decodeElementIndex(descriptor)) {
                    0 -> error = decodeBooleanElement(descriptor, 0)
                    1 -> msg = decodeStringElement(descriptor, 1)
                    2 -> data = decodeSerializableElement(descriptor, 2, ListSerializer(CountryModel.serializer()))
                    else -> break
                }
            }

            CountryInfoModel(error, msg, data)
        }
    }
}
