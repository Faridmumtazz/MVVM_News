package mumtaz.binar.mvvm_news.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import mumtaz.binar.mvvm_news.R
import mumtaz.binar.mvvm_news.adapter.NewsAdapter
import mumtaz.binar.mvvm_news.viewmodel.ViewModelNews

class MainActivity : AppCompatActivity() {

    lateinit var newsadapter : NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newsadapter = NewsAdapter()

        rv_news.layoutManager = LinearLayoutManager(this)
        rv_news.adapter = newsadapter
        initviewModel()
    }

    fun initviewModel(){
        val viewModel = ViewModelProvider(this).get(ViewModelNews::class.java)
        viewModel.getLDNews().observe(this, Observer {
            if(it != null){
                newsadapter.setNewsList(it)
                newsadapter.notifyDataSetChanged()
            }
        })
        viewModel.getDataNews()
    }
}