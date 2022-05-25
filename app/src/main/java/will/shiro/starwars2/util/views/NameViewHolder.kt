package will.shiro.starwars2.util.views

import androidx.recyclerview.widget.RecyclerView
import will.shiro.starwars2.databinding.SimpleCardNameItemBinding
import will.shiro.starwars2.util.entity.Nameable

class NameViewHolder constructor(
    private val binding: SimpleCardNameItemBinding,
    private val callback: (Nameable) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun setUp(nameable: Nameable) {
        binding.nameText.text = nameable.getEntityName()
        binding.root.setOnClickListener {
            callback(nameable)
        }
    }
}