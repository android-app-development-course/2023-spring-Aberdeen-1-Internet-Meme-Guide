package com.example.appdevelopment

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class ExplainationMemesAdapter(private val dataSet: List<ExplainationMemes>,private val context: Context) :
    RecyclerView.Adapter<ExplainationMemesAdapter.ViewHolder>() {

    // 定义ViewHolder类
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val pi2ImageView: ImageView = view.findViewById(R.id.pi2)
        val text3TextView: TextView = view.findViewById(R.id.text3)
        val text4TextView: TextView = view.findViewById(R.id.text4)
        val pi3ImageView: ImageView = view.findViewById(R.id.pi3)
        val text5TextView: TextView = view.findViewById(R.id.text5)
        val text6TextView: TextView = view.findViewById(R.id.text6)
    }

    // 创建新的ViewHolder（由LayoutManager所调用）
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_explaination_meme, parent, false)

        return ViewHolder(view)
    }

    // 将数据绑定到ViewHolder上（由LayoutManager所调用）
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // 获取当前数据项
        val data = dataSet[position]

        // 运用解析后的数据将 view 中的组件设值
        holder.pi2ImageView.setImageResource(data.srcCompat1)
        holder.text3TextView.text = data.name1
        holder.text4TextView.text = data.view1
        holder.pi3ImageView.setImageResource(data.srcCompat2)
        holder.text5TextView.text = data.name2
        holder.text6TextView.text = data.view2
        holder.pi2ImageView.setOnClickListener {
            // 打开相应页面
            if (data.id == 1) {
                val intent = Intent(context, detail_meme3::class.java)
                context.startActivity(intent)
            } else if (data.id == 2) {
                val intent = Intent(context, detail_meme2::class.java)
                context.startActivity(intent)
            } else if (data.id == 3) {
                val intent = Intent(context, details_meme::class.java)
                context.startActivity(intent)
            }
        }
        holder.pi3ImageView.setOnClickListener {
            if (data.id == 1) {
                val intent = Intent(context, detail_meme3::class.java)
                context.startActivity(intent)
            } else if (data.id == 2) {
                val intent = Intent(context, detail_meme2::class.java)
                context.startActivity(intent)
            } else if (data.id == 3) {
                val intent = Intent(context, details_meme::class.java)
                context.startActivity(intent)
            }
        }

    }

    // 返回数据集大小（由LayoutManager所调用）
    override fun getItemCount(): Int {
        return dataSet.size
    }
}
