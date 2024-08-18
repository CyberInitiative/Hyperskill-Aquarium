package org.hyperskill.aquarium

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class AnimalAdapter(
    val imageAnimals: List<String>,
    val nameAnimals: List<String>,
    val descriptionAnimals: List<String>
) : RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder>() {

    class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_view)
        val tvName: TextView = itemView.findViewById(R.id.tv_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.animal_item_view, parent, false)
        return AnimalViewHolder(view)
    }

    override fun getItemCount(): Int {
        return nameAnimals.size
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        Picasso.get()
            .load(imageAnimals[position])
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error)
            .fit()
            .centerCrop()
            .into(holder.imageView)


        holder.tvName.text = nameAnimals[position]
        holder.tvDescription.text = descriptionAnimals[position]
    }
}