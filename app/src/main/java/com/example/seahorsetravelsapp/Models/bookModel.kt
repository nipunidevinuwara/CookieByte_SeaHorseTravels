package com.example.seahorsetravelsapp.Models

import java.sql.Time
import java.text.DateFormat
import java.util.Date

data class bookModel(
    var From:String? = null,
    var destination:String? = null,
    var travelType:String? = null,
    var travelDate:Date? = null,
    var travelTime:Time? = null,
    var paymentMethod:String? = null,
    var fee:Float? = null
)
