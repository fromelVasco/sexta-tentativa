package com.example.sextatentativa.di

import android.util.Base64
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sextatentativa.di.Constants.Companion.AUTH_URL
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import saschpe.kase64.base64Decoded
import saschpe.kase64.base64DecodedBytes
import java.security.KeyFactory
import java.security.spec.X509EncodedKeySpec
import javax.crypto.Cipher
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    private val apiRepository: Repository
) : ViewModel() {

    /*    val apiKey: String = "lozh7u0056nuwxhz7oo61ss2506err9k"
        val publicKey: String =
            "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAmptSWqV7cGUUJJhUBxsMLonux24u+FoTlrb+4Kgc6092JIszmI1QUoMohaDDXSVueXx6IXwYGsjjWY32HGXj1iQhkALXfObJ4DqXn5h6E8y5/xQYNAyd5bpN5Z8r892B6toGzZQVB7qtebH4apDjmvTi5FGZVjVYxalyyQkj4uQbbRQjgCkubSi45Xl4CGtLqZztsKssWz3mcKncgTnq3DHGYYEYiKq0xIj100LGbnvNz20Sgqmw/cH+Bua4GJsWYLEqf/h/yiMgiBbxFxsnwZl0im5vXDlwKPw+QnO2fscDhxZFAwV06bgG0oEoWm9FnjMsfvwm0rUNYFlZ+TOtCEhmhtFp+Tsx9jPCuOd5h2emGdSKD8A6jtwhNa7oQ8RtLEEqwAn44orENa1ibOkxMiiiFpmmJkwgZPOG/zMCjXIrrhDWTDUOZaPx/lEQoInJoE2i43VN/HTGCCw8dKQAwg0jsEXau5ixD0GUothqvuX3B9taoeoFAIvUPEq35YulprMM7ThdKodSHvhnwKG82dCsodRwY428kg2xM/UjiTENog4B6zzZfPhMxFlOSFX4MnrqkAS+8Jamhy1GgoHkEMrsT5+/ofjCx0HjKbT5NuA2V/lmzgJLl3jIERadLzuTYnKGWxVJcGLkWXlEPYLbiaKzbJb2sYxt+Kt5OxQqC1MCAwEAAQ==\n"


        val _precoNovoProduto: MutableState<ResponseThis> =
            mutableStateOf(ResponseThis(access_token = "", expires_in = 0, token_type = ""))

        fun login(credenciais: Request) {
            viewModelScope.launch {
                val response = apiRepository.post(credenciais)
                if (response.isSuccessful) {
                    _precoNovoProduto.value = response.body()!!.value
                    Log.e("TOKEN:", response.body()!!.value.access_token!!)
                } else {
                    Log.e("TOKEN:", "erro")
                }

            }



        fun mostrarChavePublicaDecodificada() {
            val chavePublicaDecodificada = publicKey.base64Decoded
            Log.e("ChavePublica Decodificada", chavePublicaDecodificada)
            val cipher = Cipher.getInstance(chavePublicaDecodificada)


        }    }*/

    var key: MutableState<String?> = mutableStateOf(null)
    public fun tentar() {


        val publicKey =
            "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAszE+xAKVB9HRarr6/uHYYAX/RdD6KGVIGlHv98QKDIH26ldYJQ7zOuo9qEscO0M1psSPe/67AWYLEXh13fbtcSKGP6WFjT9OY6uV5ykw9508x1sW8UQ4ZhTRNrlNsKizE/glkBfcF2lwDXJGQennwgickWz7VN+AP/1c4DnMDfcl8iVIDlsbudFoXQh5aLCYl+XOMt/vls5a479PLMkPcZPOgMTCYTCE6ReX3KD2aGQ62uiu2T4mK+7Z6yvKvhPRF2fTKI+zOFWly//IYlyB+sde42cIU/588msUmgr3G9FYyN2vKPVy/MhIZpiFyVc3vuAAJ/mzue5p/G329wzgcz0ztyluMNAGUL9A4ZiFcKOebT6y6IgIMBeEkTwyhsxRHMFXlQRgTAufaO5hiR/usBMkoazJ6XrGJB8UadjH2m2+kdJIieI4FbjzCiDWKmuM58rllNWdBZK0XVHNsxmBy7yhYw3aAIhFS0fNEuSmKTfFpJFMBzIQYbdTgI28rZPAxVEDdRaypUqBMCq4OstCxgGvR3Dy1eJDjlkuiWK9Y9RGKF8HOI5a4ruHyLheddZxsUihziPF9jKTknsTZtF99eKTIjhV7qfTzxXq+8GGoCEABIyu26LZuL8X12bFqtwLAcjfjoB7HlRHtPszv6PJ0482ofWmeH0BE8om7VrSGxsCAwEAAQ==";
        val apiKey = "aaaab09uz9f3asdcjyk7els777ihmwv8";

        System.out.println(getBearerToken(apiKey, publicKey));
    }



    fun getBearerToken(apiKey: String, publicKey: String): String {

        var encryptedApiKey: ByteArray? = null

        try {
            val keyFactory = KeyFactory.getInstance("RSA")
            val cipher = Cipher.getInstance("RSA")
            val encodedPublicKey = publicKey.base64DecodedBytes
            val publicKeySpec = X509EncodedKeySpec(encodedPublicKey)
            val pk = keyFactory.generatePublic(publicKeySpec)

            cipher.init(Cipher.ENCRYPT_MODE, pk);
            encryptedApiKey = cipher.doFinal(apiKey.toByteArray())
            //val encryptedApiKeyBase64 = Base64.getEncoder().encodeToString(encryptedApiKey)
            Log.e("TOKEN:", encryptedApiKey.base64Decoded)


        } catch (e: Exception) {
            e.printStackTrace()
        }
        return encryptedApiKey!!.base64Decoded

    }


    private val RSA_MODE = "RSA/ECB/OAEPPadding"
    private val CHARSET = "UTF-8"

    fun encrypt(apiKey: String, publicKey: String) {


        viewModelScope.launch(Dispatchers.IO) {
            try {
                val decodedPublicKey = Base64.decode(publicKey, Base64.DEFAULT)
                val keyFactory = KeyFactory.getInstance("RSA")
                val publicKeySpec = X509EncodedKeySpec(decodedPublicKey)
                val pk = keyFactory.generatePublic(publicKeySpec)

                val cipher = Cipher.getInstance(RSA_MODE)
                cipher.init(
                    Cipher.ENCRYPT_MODE,
                    pk
                )
                 key.value = Base64.encodeToString(
                    cipher.doFinal(apiKey.toByteArray(Charsets.UTF_8)), Base64.DEFAULT
                )

                Log.e("TOKEN:", key.value!!)


            } catch (e: Exception) {
                e.printStackTrace()

            }

        }
    }


    private val _produtoSeleccionado: MutableStateFlow<ResponseThis?> = MutableStateFlow(null)
    val produtoSeleccionado: StateFlow<ResponseThis?> = _produtoSeleccionado

    fun c2bTrans() {

        val publicKey = "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAszE+xAKVB9HRarr6/uHYYAX/RdD6KGVIGlHv98QKDIH26ldYJQ7zOuo9qEscO0M1psSPe/67AWYLEXh13fbtcSKGP6WFjT9OY6uV5ykw9508x1sW8UQ4ZhTRNrlNsKizE/glkBfcF2lwDXJGQennwgickWz7VN+AP/1c4DnMDfcl8iVIDlsbudFoXQh5aLCYl+XOMt/vls5a479PLMkPcZPOgMTCYTCE6ReX3KD2aGQ62uiu2T4mK+7Z6yvKvhPRF2fTKI+zOFWly//IYlyB+sde42cIU/588msUmgr3G9FYyN2vKPVy/MhIZpiFyVc3vuAAJ/mzue5p/G329wzgcz0ztyluMNAGUL9A4ZiFcKOebT6y6IgIMBeEkTwyhsxRHMFXlQRgTAufaO5hiR/usBMkoazJ6XrGJB8UadjH2m2+kdJIieI4FbjzCiDWKmuM58rllNWdBZK0XVHNsxmBy7yhYw3aAIhFS0fNEuSmKTfFpJFMBzIQYbdTgI28rZPAxVEDdRaypUqBMCq4OstCxgGvR3Dy1eJDjlkuiWK9Y9RGKF8HOI5a4ruHyLheddZxsUihziPF9jKTknsTZtF99eKTIjhV7qfTzxXq+8GGoCEABIyu26LZuL8X12bFqtwLAcjfjoB7HlRHtPszv6PJ0482ofWmeH0BE8om7VrSGxsCAwEAAQ=="
        val apiKey = "aaaab09uz9f3asdcjyk7els777ihmwv8"


        val request = Request(
            input_TransactionReference = "T12344C",
            input_CustomerMSISDN = "258844847146",
            input_Amount = "10",
            input_ThirdPartyReference = "7NVT2Q",
            input_ServiceProviderCode = "171717"

        )

        viewModelScope.launch (Dispatchers.IO ){

            try {
                val algo = apiRepository.post(request = request, app = "application/json", orig = AUTH_URL, auth = "Bearer ${key.value!!}")
                algo.body()!!.collect{
                    Log.e("RESPOSTA", it.output_ResponseCode!!)
                    _produtoSeleccionado.value=it

                }



            }catch (e: Exception){
                e.printStackTrace()
            }


        }



    }




}