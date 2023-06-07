package com.example.appdevelopment

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.makeramen.roundedimageview.RoundedImageView


class mypage_work : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mypage_work)
        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        //RecyclerView 主体部分
        val recyclerView = findViewById<RecyclerView>(R.id.work_recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val userName = intent.getStringExtra(AlarmClock.EXTRA_MESSAGE) ?: "陈哥"

        //添加数据
        val items = listOf(
            WorkItem("持枪小呆呆是啥梗", 1145,14,
                R.drawable.meme_xiaodaidai_1,R.drawable.meme_xiaodaidai_2,R.drawable.meme_xiaodaidai_3),
            WorkItem("为什么都说B站虚拟主播「东雪莲」是“罕见”？",0,0,
                R.drawable.meme_dongxuelian_1,R.drawable.meme_dongxuelian_2,R.drawable.meme_dongxuelian_3),
            WorkItem("泰裤辣是什么意思", 19, 19,
                R.drawable.meme_taikula,R.drawable.meme_taikula,R.drawable.meme_taikula),
            WorkItem("关于陈哥是管人痴这件事情", 8, 16,
                R.drawable.meme_youxi_1,R.drawable.meme_youxi_2,R.drawable.meme_youxi_3)
        )

        val adapter = WorkAdapter(items)
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
                    val intent = Intent(this, mypage_main::class.java).apply {
                        putExtra(AlarmClock.EXTRA_MESSAGE, userName)}
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }


    }

}


//单元里包含的数据类
data class WorkItem(val title: String, val likes: Int, val comments: Int,val ResId_1: Int,val ResId_2: Int,val ResId_3: Int)

//recyclerview 适配器
class WorkAdapter(private val items: List<WorkItem>) : RecyclerView.Adapter<WorkAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.mypage_work_unit, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.titleView.text = item.title
        holder.likesView.text = item.likes.toString()
        holder.commentsView.text = item.comments.toString()
        holder.ImageView1.setImageResource(item.ResId_1)
        holder.ImageView2.setImageResource(item.ResId_2)
        holder.ImageView3.setImageResource(item.ResId_3)
    }

    override fun getItemCount(): Int {
        return items.size
    }
    //绑定单元里的元素
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleView: TextView = itemView.findViewById(R.id.title)
        val likesView: TextView = itemView.findViewById(R.id.likes)
        val commentsView: TextView = itemView.findViewById(R.id.comments)
        val ImageView1: ImageView = itemView.findViewById(R.id.work_image1)
        val ImageView2: ImageView = itemView.findViewById(R.id.work_image2)
        val ImageView3: ImageView = itemView.findViewById(R.id.work_image3)
    }
}