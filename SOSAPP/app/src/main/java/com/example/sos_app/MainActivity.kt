package com.example.sos_app

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sos_app.database.QuickTIpsRepository
import com.example.sos_app.model.QuickTips
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var quickTipsRepository: QuickTIpsRepository
    private val mainScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        quickTipsRepository = QuickTIpsRepository(this)
        insertQuickTip()
        getRandomQuickTip()

    }

    private fun initViews() {

        btn_map.setOnClickListener { onMapClick() }
        btn_SOS.setOnClickListener { onSOSClick() }
        btn_Tips.setOnClickListener { onTipsClick() }
    }

    private fun onTipsClick() {
        startActivity( Intent(this@MainActivity, TipsActivity::class.java))
    }

    private fun onSOSClick() {
        startActivity( Intent(this@MainActivity, SosActivity::class.java))

    }

    private fun onMapClick() {
        startActivity( Intent(this@MainActivity, MapActivity::class.java))
    }

    private fun getRandomQuickTip(){
        mainScope.launch{
            withContext(Dispatchers.IO){
               txt_QuickTip.text = quickTipsRepository.getRandomTip().elementAt(0).content
            }
        }
    }
    private fun deleteRandomQuickTips(){
        mainScope.launch{
            withContext(Dispatchers.IO){
                quickTipsRepository.deleteAllRandomTip()
            }
        }
    }
    private fun insertQuickTip(){
        mainScope.launch{
            withContext(Dispatchers.IO){
                quickTipsRepository.insertQuickTip(QuickTips("Think before you act"))
                quickTipsRepository.insertQuickTip(QuickTips("Prioritize your own safety"))
                quickTipsRepository.insertQuickTip(QuickTips("Only provide first aid if you know what to do. Otherwise you might make it worse"))
            }
        }
    }

}
