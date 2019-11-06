package ar.edu.unlam.florenciamartin.tallerprogramacion.modelo

import com.google.gson.annotations.SerializedName

data class Item(
    val id: String,
    @SerializedName("title") val titulo: String

)