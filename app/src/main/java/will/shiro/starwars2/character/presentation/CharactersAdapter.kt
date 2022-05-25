package will.shiro.starwars2.character.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import will.shiro.starwars2.databinding.SimpleCardNameItemBinding
import will.shiro.starwars2.util.entity.Nameable
import will.shiro.starwars2.util.views.NameViewHolder

class CharactersAdapter constructor(
    private val callback: (Nameable) -> Unit
) : ListAdapter<Nameable, NameViewHolder>(CharactersDiffUtil()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        return NameViewHolder(
            SimpleCardNameItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            callback
        )
    }

    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        holder.setUp(getItem(position))
    }

}

class CharactersDiffUtil : DiffUtil.ItemCallback<Nameable>() {
    override fun areItemsTheSame(oldItem: Nameable, newItem: Nameable): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Nameable, newItem: Nameable): Boolean {
        return oldItem.getEntityName() == newItem.getEntityName()
    }
}