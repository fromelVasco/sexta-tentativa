package com.example.sextatentativa.di

data class Request(
    val input_TransactionReference: String? = "client_credentials" ,
    val input_CustomerMSISDN: String?,
    val input_Amount: String?,
    val input_ThirdPartyReference: String?,
    val input_ServiceProviderCode: String?,

)
