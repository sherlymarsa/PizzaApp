package com.example.pizzaapp

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzaapp.model.MenuModel


class MakananAdapter(private val list: ArrayList<MenuModel>) :
    RecyclerView.Adapter<MakananAdapter.MakananViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            MakananAdapter.MakananViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.cardview_makanan,
            parent, false)

        return MakananViewHolder(cellForRow)
    }


    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MakananViewHolder, position: Int) {
        val data = list[position]
        holder.bind(data)
    }

    inner class MakananViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textId: TextView = itemView.findViewById(R.id.textIdMakanan)
        val textName: TextView = itemView.findViewById(R.id.textNamaMakanan)
        val textHarga: TextView = itemView.findViewById(R.id.textHargaMakanan)
        val imageMenu: ImageView = itemView.findViewById(R.id.imageMakanan)

        fun bind(data: MenuModel) {
            val id: Int = data.id
            val nama: String = data.name
            val harga: Int = data.price
            val gambar: Bitmap = data.image

            textId.text = id.toString()
            textName.text = nama
            textHarga.text = harga.toString()
            imageMenu.setImageBitmap(gambar)
        }
    }
}