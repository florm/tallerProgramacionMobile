package ar.edu.unlam.florenciamartin.tallerprogramacion

import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ar.edu.unlam.florenciamartin.tallerprogramacion.api.API
import ar.edu.unlam.florenciamartin.tallerprogramacion.modelo.Articulo
import ar.edu.unlam.florenciamartin.tallerprogramacion.modelo.Usuario
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_item_lista.view.*
import kotlinx.android.synthetic.main.activity_producto.view.*
import kotlinx.android.synthetic.main.activity_producto.view.nombreProducto
import kotlinx.android.synthetic.main.activity_producto.view.precioConDescuento
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AdaptadorDeArticulos : RecyclerView.Adapter<AdaptadorDeArticulos.ViewHolder>(){

    var articulos = ArrayList<Articulo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.activity_item_lista, parent, false)
        return ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return articulos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val articulo = articulos[position]

        Picasso.get()
            .load(articulo.urlImagen)
            .into(holder.itemView.imagen)

        holder.itemView.nombreProducto.text = articulo.titulo
        holder.itemView.precioConDescuento.text = "$${articulo.precioDescuento}"
        holder.itemView.idProducto.text = articulo.id

        API().getVendedor(articulo.usuario.id.toString(), object: Callback<Usuario> {
            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                if(response.isSuccessful){
                    var usuario = response.body();
                    holder.itemView.nombreVendedorItem.text = usuario?.nickname
                }

            }
        })
        holder.itemView.setOnClickListener(){
            val intent = Intent(it.context, ProductoActivity::class.java)
            intent.putExtra("idProducto", holder.itemView.idProducto.text.toString())
            it.context.startActivity(intent)
        }


    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}