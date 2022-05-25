package will.shiro.starwars2.character.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import will.shiro.starwars2.databinding.FragmentCharactersBinding
import will.shiro.starwars2.util.entity.Nameable

@AndroidEntryPoint
class CharactersFragment : Fragment() {

    companion object {
        fun newInstance() = CharactersFragment()
    }

    private val viewModel: CharactersViewModel by activityViewModels()
    private val adapter by lazy {
        CharactersAdapter(::onRecyclerItemClick)
    }
    private var _binding: FragmentCharactersBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharactersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpObservers()
        setUpViews()
        viewModel.getCharacters()
    }

    private fun setUpObservers() = with(viewModel) {
        characters.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun setUpViews() = with(binding) {
        charactersList.layoutManager = GridLayoutManager(
            requireContext(), 2, GridLayoutManager.VERTICAL, false
        )
        charactersList.adapter = adapter
    }

    private fun onRecyclerItemClick(nameable: Nameable) {

    }
}