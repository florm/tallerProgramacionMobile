package ar.edu.unlam.florenciamartin.tallerprogramacion.modelo

import com.google.gson.annotations.SerializedName

data class SearchResult(
    @SerializedName("results") val articulos: List<Articulo>
)