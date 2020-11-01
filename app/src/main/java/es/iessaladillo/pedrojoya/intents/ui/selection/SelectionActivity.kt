package es.iessaladillo.pedrojoya.intents.ui.selection

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import es.iessaladillo.pedrojoya.intents.data.local.Database
import es.iessaladillo.pedrojoya.intents.data.local.model.Pokemon
import es.iessaladillo.pedrojoya.intents.databinding.SelectionActivityBinding

class SelectionActivity : AppCompatActivity() {

    companion object {

        const val EXTRA_POKEMON = "EXTRA_POKEMON"

        fun newIntent(context: Context, id : Long) =
            Intent(context, SelectionActivity::class.java)
                .putExtras(bundleOf(EXTRA_POKEMON to id))

    }

    private var id : Long = 0
    private var pokemon : Pokemon? = null
    private lateinit var binding: SelectionActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SelectionActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews() {
        getIntentData()
    }

    private fun getIntentData() {
        if (intent == null || !intent.hasExtra(EXTRA_POKEMON)) {
            throw RuntimeException(
                "DetailActivity needs to receive name and age as extras")
        }
        id = intent.getLongExtra(EXTRA_POKEMON, 0)
        pokemon = Database.getPokemonById(id)
    }

    override fun onBackPressed() {
        // TODO: AQUÍ ES DONDE DEBES ESTABLECER EL RESULTADO CON setResult()

        super.onBackPressed()
    }

}