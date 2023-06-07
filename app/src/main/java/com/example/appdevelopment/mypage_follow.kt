package com.example.appdevelopment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.makeramen.roundedimageview.RoundedImageView

class mypage_follow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mypage_follow)
        val recyclerView: RecyclerView = findViewById(R.id.follow_recycler)
        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        val userName = intent.getStringExtra(AlarmClock.EXTRA_MESSAGE) ?: "陈哥"



//动态修改recyclerview的宽度
        val view = findViewById<View>(R.id.followers)
        val vto = recyclerView.viewTreeObserver
        vto.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                // 在布局完成后获取 View 和 RecyclerView 的宽度
                val viewWidth = view.width
                val recyclerViewWidth = recyclerView.width

                // 计算百分比
                val percentage = 1.0f - (viewWidth.toFloat() / recyclerViewWidth.toFloat())

                // 设置 RecyclerView 的宽度百分比
                val lp = recyclerView.layoutParams as ConstraintLayout.LayoutParams
                lp.matchConstraintPercentWidth = percentage
                recyclerView.layoutParams = lp

                // 移除监听器
                recyclerView.viewTreeObserver.removeOnGlobalLayoutListener(this)
            }
        })


        //在recyclerview里面添加数据
        val followItems = (0 until 5).flatMap {
            listOf(
                FollowItem("Dan", R.drawable.danye),
                FollowItem("陈子健", R.drawable.meme_youxi_1),
                FollowItem("Chen", R.drawable.meme_youxi_2),
                FollowItem("小马珍珠", R.drawable.dingzhen),
                FollowItem("小鬼", R.drawable.meme_taikula),
                FollowItem("猪猪侠", R.drawable.meme_xiaodaidai_2),
                FollowItem("陈子健", R.drawable.dingzhen),
                // ...
            )
        }
        val adapter = FollowListAdapter(followItems)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

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
data class FollowItem(val username: String, val profileResId: Int)

//recyclerview 适配器
class FollowListAdapter(private val items: List<FollowItem>) :
    RecyclerView.Adapter<FollowListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ImageView: RoundedImageView = itemView.findViewById(R.id.follow_profile)
        val usernameTextView: TextView = itemView.findViewById(R.id.follow_username)
        val followButton: ImageView = itemView.findViewById(R.id.follow_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.mypage_follow_unit, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.ImageView.setImageResource(item.profileResId)
        holder.usernameTextView.text = item.username
        holder.followButton.setOnClickListener {
            // 处理点击事件
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}