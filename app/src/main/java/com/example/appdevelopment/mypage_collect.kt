package com.example.appdevelopment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView


class mypage_collect : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mypage_collect)
        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)

//RecyclerView 主体部分
        val recyclerView = findViewById<RecyclerView>(R.id.collect_recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)

        //添加数据
        val items = listOf(
            CollectItem("一杯茶之间无数meme浮现在脑海", 999,99),

        )

        val adapter = CollectAdapter(items)
        recyclerView.adapter = adapter


        //底部导航栏

        navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeNaviBtn -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.findNaviBtn -> {
                    val intent = Intent(this, explaination_memes::class.java)
                    startActivity(intent)
                    true
                }
                R.id.messageNaviBtn -> {
                    val intent = Intent(this, explaination_memes::class.java)
                    startActivity(intent)
                    true
                }
                R.id.myNaviBtn -> {
                    val intent = Intent(this, mypage_main::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }


    }

}


//单元里包含的数据类
data class CollectItem(val title: String, val likes: Int, val comments: Int)

//recyclerview 适配器
class CollectAdapter(private val items: List<CollectItem>) : RecyclerView.Adapter<CollectAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.mypage_collect_unit, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.titleView.text = item.title
        holder.likesView.text = item.likes.toString()
        holder.commentsView.text = item.comments.toString()
    }

    override fun getItemCount(): Int {
        return items.size
    }
    //绑定单元里的元素
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleView: TextView = itemView.findViewById(R.id.title)
        val likesView: TextView = itemView.findViewById(R.id.likes)
        val commentsView: TextView = itemView.findViewById(R.id.comments)
    }
}