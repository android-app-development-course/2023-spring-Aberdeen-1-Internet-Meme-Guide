package com.example.forumapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forumapp.NewsUnit
import com.example.forumapp.R
import com.example.forumapp.models.Post

class PostFragment: Fragment() {
    private val postList = ArrayList<Post>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_post, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewForPost)
        initNews()  // 添加新闻
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        val adapter = PostUnitAdapter(postList)
        recyclerView.adapter= adapter

        return view

    }

    private fun initNews() {
        repeat(2) {
//            newsList.add(NewsUnit("Banana", R.drawable.test_2,"丹爷","2022-1-1"))
//            newsList.add(NewsUnit("Apple", R.drawable.test_1,"陈哥","2022-12-1"))


        }
    }
}

//适配器
class PostUnitAdapter(val postList: List<Post>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val postTitle:EditText = view.findViewById(R.id.postTitle)
        val postPicture:ImageView = view.findViewById(R.id.postPicture)
        val postContent:EditText = view.findViewById(R.id.postContent)
        val postTime:EditText = view.findViewById(R.id.postTime)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.post_short_layout,parent,false)
//        val viewHolder=ViewHolder(view)
//        viewHolder.itemView.setOnClickListener{
//            val position=viewHolder.adapterPosition
//            val operator=opList[position]
//            Toast.makeText(parent.context,"功能：${operator.text}", Toast.LENGTH_SHORT).show()
//        }

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val postShort = postList[position]

    }

    override fun getItemCount(): Int = postList.size

}