package com.example.l2t2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

import kotlinx.android.synthetic.main.activity_main.*





class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }


    private val questionsContent = arrayListOf<Questions>()
    private val questionAdapter = QuestionAdapter(questionsContent)

    private fun initViews() {
        // Initialize the recycler view with a linear layout manager, adapter
        rvQuestions.layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        rvQuestions.adapter = questionAdapter
        rvQuestions.addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))
        createItemTouchHelper().attachToRecyclerView(rvQuestions)

        // Populate the places list and notify the data set has changed.
        for (i in Questions.questionText.indices) {
            questionsContent.add(Questions(Questions.questionText[i], Questions.QuestionTruth[i]))
        }
    }

    /**
     * Create a touch helper to recognize when a user swipes an item from a recycler view.
     * An ItemTouchHelper enables touch behavior (like swipe and move) on each ViewHolder,
     * and uses callbacks to signal when a user is performing these actions.
     */
    private fun createItemTouchHelper(): ItemTouchHelper {

        // Callback which is used to create the ItemTouch helper. Only enables left swipe.
        // Use ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) to also enable right swipe.
        val callback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or  ItemTouchHelper.RIGHT) {


            // Enables or Disables the ability to move items up and down.
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            // Callback triggered when a user swiped an item.
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                if(direction == 4){ // left


                    if(!questionsContent[position].QuestionTruth){
                        questionsContent.removeAt(position)
                        questionAdapter.notifyDataSetChanged()
                    }
                    else{
                        // if true
                        questionAdapter.notifyDataSetChanged()
                        val snackbar = Snackbar.make(
                            constaintLT,
                            "answer is incorrect",
                            Snackbar.LENGTH_SHORT
                        )
                        snackbar.show()
                    }
                }

                if(direction == 8){ // right

                    if(questionsContent[position].QuestionTruth){
                        questionsContent.removeAt(position)
                        questionAdapter.notifyDataSetChanged()
                    }
                    else{
                        // if false
                        questionAdapter.notifyDataSetChanged()
                        val snackbar = Snackbar.make(
                            constaintLT,
                            "answer is incorrect",
                            Snackbar.LENGTH_SHORT
                        )
                        snackbar.show()
                    }
                }

            }
        }
        return ItemTouchHelper(callback)
    }


    }

