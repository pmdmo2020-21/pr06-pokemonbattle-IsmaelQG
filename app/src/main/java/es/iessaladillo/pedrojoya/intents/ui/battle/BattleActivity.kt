package es.iessaladillo.pedrojoya.intents.ui.battle

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import es.iessaladillo.pedrojoya.intents.data.local.Database
import es.iessaladillo.pedrojoya.intents.data.local.model.Pokemon
import es.iessaladillo.pedrojoya.intents.databinding.BattleActivityBinding
import es.iessaladillo.pedrojoya.intents.ui.selection.SelectionActivity

class BattleActivity : AppCompatActivity() {

    private lateinit var binding: BattleActivityBinding
    private lateinit var pokemon1 : Pokemon
    private lateinit var pokemon2 : Pokemon

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = BattleActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews() {
        binding.btnStart.setOnClickListener{}
        setPokemon1(Database.getRandomPokemon())
        setPokemon2(Database.getRandomPokemon())
        binding.lblPokemon1.setOnClickListener {navigateToSelectionActivityPokemon1(pokemon1.id)}
    }

    private fun setPokemon1(pokemon : Pokemon) {
        pokemon1 = pokemon
        binding.imgPokemon1.setImageResource(pokemon.image)
        binding.lblPokemon1.text = pokemon.name
    }

    private fun setPokemon2(pokemon : Pokemon) {
        pokemon2 = pokemon
        binding.imgPokemon2.setImageResource(pokemon.image)
        binding.lblPokemon2.text = pokemon.name
    }

    private fun navigateToSelectionActivityPokemon1(id : Long) {
        val intent = SelectionActivity.newIntent(this, id)
        startActivity(intent)
    }

}