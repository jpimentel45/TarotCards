package com.example.tarotcards

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.tarotcards.databinding.ActivityMainBinding
import com.example.tarotcards.tarot.TarotCardAdapter
import com.example.tarotcards.tarot.TarotViewModel
import com.example.tarotcards.ui.TarotCardFragment
import com.example.tarotcards.util.BaseActivity


class MainActivity : BaseActivity() {
    private lateinit var viewModel: TarotViewModel
    private lateinit var binding: ActivityMainBinding
    private var adapter: TarotCardAdapter = TarotCardAdapter{
        Toast.makeText(this, it.meaningUp, Toast.LENGTH_SHORT).show()
    }
    private lateinit var toolbar: Toolbar

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        toolbar = binding.toolBar.myToolbar
        setSupportActionBar(toolbar)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<TarotCardFragment>(R.id.fragment_container_view)
                disallowAddToBackStack()

            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home -> {
                supportFragmentManager.popBackStack()
                return true
            }
            else ->{
                super.onOptionsItemSelected(item)
            }
        }
    }

//    override fun onBackPressed() {
//        if (supportFragmentManager.backStackEntryCount > 0) supportFragmentManager.popBackStack()
//        else super.onBackPressed()
//    }
}