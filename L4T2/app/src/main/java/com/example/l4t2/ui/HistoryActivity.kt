package com.example.l4t2.ui

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.l4t2.R
import com.example.l4t2.database.GameRepository
import com.example.l4t2.model.Game
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_history.*
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HistoryActivity : AppCompatActivity() {

    private val gameList = arrayListOf<Game>()
    private val gameAdapter = GameAdapter(gameList)
    private lateinit var gameRepository: GameRepository
    private val mainScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        setSupportActionBar(toolbar)

        gameRepository = GameRepository(this)
        initViews()
    }

    private fun initViews() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        rvGames.layoutManager = LinearLayoutManager(
            this,
            RecyclerView.VERTICAL, false
        )
        rvGames.adapter = gameAdapter
        rvGames.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        retrieveGames()
    }

    private fun retrieveGames() {
        mainScope.launch {
            val gameList = withContext(Dispatchers.IO) {
                gameRepository.getAllGames()
            }
            this@HistoryActivity.gameList.clear()
            this@HistoryActivity.gameList.addAll(gameList)
            this@HistoryActivity.gameAdapter.notifyDataSetChanged()
        }
    }

    private fun deleteAllHistory() {
        mainScope.launch {
            withContext(Dispatchers.IO) {
                gameRepository.deleteAllGames()
            }
            retrieveGames()
        }
    }

    override fun onBackPressed() {
        setResult(if(gameList.isEmpty()) Activity.RESULT_OK  else Activity.RESULT_CANCELED)
        super.onBackPressed()
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_history, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.action_delete_history -> {
                deleteAllHistory()
                true
            }
            android.R.id.home -> {
                setResult(if (gameList.isEmpty()) Activity.RESULT_OK else Activity.RESULT_CANCELED)
                finish()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
