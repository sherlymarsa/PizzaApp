package com.example.pizzaapp

import android.content.Intent
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.toBitmap
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
        val textId: TextView
        val textName: TextView
        val textHarga: TextView
        val imageMenu: ImageView
        val buttonEdit: Button
        val context = itemView.context
        init {
            textId = itemView.findViewById(R.id.textIdMakanan)
            textName = itemView.findViewById(R.id.textNamaMakanan)
            textHarga = itemView.findViewById(R.id.textHargaMakanan)
            imageMenu = itemView.findViewById(R.id.imageMakanan)
            buttonEdit = itemView.findViewById(R.id.buttonEditMakanan)

            //event saat btn edit di-klik
            buttonEdit.setOnClickListener{
                EditMenuActivity.idMakanan = textId.text.toString().toInt()
                EditMenuActivity.namaMakanan = textName.text.toString()
                EditMenuActivity.hargaMakanan = textHarga.text.toString().toInt()
                EditMenuActivity.gambarMakanan = imageMenu.drawable.toBitmap(150,150,null)

                val edit = Intent(context,EditMenuActivity::class.java)
                context.startActivity(edit)
            }
        }


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