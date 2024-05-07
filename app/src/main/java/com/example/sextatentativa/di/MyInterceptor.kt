package com.example.sextatentativa.di

import android.util.Base64
import android.util.Log
import com.example.sextatentativa.di.Constants.Companion.AUTH_URL
import okhttp3.Interceptor
import okhttp3.Response
import saschpe.kase64.base64Decoded
import saschpe.kase64.base64DecodedBytes
import java.security.KeyFactory
import java.security.spec.X509EncodedKeySpec
import javax.crypto.Cipher

class MyInterceptor: Interceptor {

    val publicKey =
        "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAszE+xAKVB9HRarr6/uHYYAX/RdD6KGVIGlHv98QKDIH26ldYJQ7zOuo9qEscO0M1psSPe/67AWYLEXh13fbtcSKGP6WFjT9OY6uV5ykw9508x1sW8UQ4ZhTRNrlNsKizE/glkBfcF2lwDXJGQennwgickWz7VN+AP/1c4DnMDfcl8iVIDlsbudFoXQh5aLCYl+XOMt/vls5a479PLMkPcZPOgMTCYTCE6ReX3KD2aGQ62uiu2T4mK+7Z6yvKvhPRF2fTKI+zOFWly//IYlyB+sde42cIU/588msUmgr3G9FYyN2vKPVy/MhIZpiFyVc3vuAAJ/mzue5p/G329wzgcz0ztyluMNAGUL9A4ZiFcKOebT6y6IgIMBeEkTwyhsxRHMFXlQRgTAufaO5hiR/usBMkoazJ6XrGJB8UadjH2m2+kdJIieI4FbjzCiDWKmuM58rllNWdBZK0XVHNsxmBy7yhYw3aAIhFS0fNEuSmKTfFpJFMBzIQYbdTgI28rZPAxVEDdRaypUqBMCq4OstCxgGvR3Dy1eJDjlkuiWK9Y9RGKF8HOI5a4ruHyLheddZxsUihziPF9jKTknsTZtF99eKTIjhV7qfTzxXq+8GGoCEABIyu26LZuL8X12bFqtwLAcjfjoB7HlRHtPszv6PJ0482ofWmeH0BE8om7VrSGxsCAwEAAQ=="
    val apiKey = "aaaab09uz9f3asdcjyk7els777ihmwv8"
    private val RSA_MODE = "RSA/ECB/OAEPPadding"
    //val bar = getBearerToken(apiKey, publicKey)

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("Content-type", "application/json")
            .addHeader("Authorization", "Bearer ")
            .addHeader("Origin", AUTH_URL)
            .build()

        return chain.proceed(request)
    }






}