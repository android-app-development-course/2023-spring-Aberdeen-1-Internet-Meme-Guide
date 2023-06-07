
package com.example.appdevelopment
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView


class mypage_draft : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mypage_draft)
        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)

//RecyclerView 主体部分
        val recyclerView = findViewById<RecyclerView>(R.id.draft_recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)

        //添加数据
        val items = listOf(
            DraftItem("陈哥与管人痴的解析与构思",
                R.drawable.meme_youxi_3,R.drawable.meme_youxi_1,R.drawable.meme_youxi_2),
            DraftItem("小呆呆是真没意思",
                R.drawable.meme_xiaodaidai_2,R.drawable.meme_xiaodaidai_1,R.drawable.meme_xiaodaidai_3),
            DraftItem("火爆全网的“happy猫”，到底是只什么猫？ ",
                R.drawable.meme_happycat_1,R.drawable.meme_happycat_2,R.drawable.avator),
            DraftItem("泰裤辣是什么意思",
                R.drawable.meme_taikula,R.drawable.meme_taikula,R.drawable.meme_taikula),
            DraftItem("陈哥与管人痴的解析与构思",
                R.drawable.meme_youxi_3,R.drawable.meme_youxi_1,R.drawable.meme_youxi_2)
        )

        val adapter = DraftAdapter(items)
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
data class DraftItem(val title: String,val ResId_1: Int,val ResId_2: Int,val ResId_3: Int)

//recyclerview 适配器
class DraftAdapter(private val items: List<DraftItem>) : RecyclerView.Adapter<DraftAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.mypage_draft_unit, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.titleView.text = item.title
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
        val ImageView1: ImageView = itemView.findViewById(R.id.draft_image1)
        val ImageView2: ImageView = itemView.findViewById(R.id.draft_image2)
        val ImageView3: ImageView = itemView.findViewById(R.id.draft_image3)
    }
}