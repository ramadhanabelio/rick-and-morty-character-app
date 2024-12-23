package com.project.therickandmortyapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.project.therickandmortyapp.R
import com.project.therickandmortyapp.model.Character
import com.squareup.picasso.Picasso

class CharacterAdapter(private val characters: List<Character>) :
    RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.character_image)
        val name: TextView = itemView.findViewById(R.id.character_name)
        val statusSpecies: TextView = itemView.findViewById(R.id.character_status_species)
        val gender: TextView = itemView.findViewById(R.id.character_gender)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        Picasso.get().load(character.image).into(holder.image)
        holder.name.text = character.name
        holder.statusSpecies.text = "${character.status} - ${character.species}"
        holder.gender.text = character.gender
    }

    override fun getItemCount(): Int = characters.size
}