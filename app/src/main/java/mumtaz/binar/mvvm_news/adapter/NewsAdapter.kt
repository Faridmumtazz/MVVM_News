package mumtaz.binar.mvvm_news.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_news.view.*
import mumtaz.binar.mvvm_news.R
import mumtaz.binar.mvvm_news.model.GetAllNewsResponseItem

class NewsAdapter (): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    private var datanews : List<GetAllNewsResponseItem> ? = null

    fun setNewsList(newsList : List<GetAllNewsResponseItem>){
        this.datanews = newsList
    }

    class ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val tampilanUi = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)

        return ViewHolder(tampilanUi)
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {

        holder.itemView.tv_judulnews.text = datanews!![position].title
        holder.itemView.tv_tglnews.text = datanews!![position].createdAt
        holder.itemView.tv_sutradaranews.text = datanews!![position].author
        Glide.with(holder.itemView.context).load(datanews!![position].image).into(holder.itemView.img_news)
    }

    override fun getItemCount(): Int {
        if (datanews == null){
            return  0
        }else{
            return datanews!!.size
        }
    }
}