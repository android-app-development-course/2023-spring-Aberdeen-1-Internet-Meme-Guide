package com.example.appdevelopment

import android.content.Intent
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CollapsePanelAdapter(private val panels: List<CollapsePanel>) :
    RecyclerView.Adapter<CollapsePanelAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_collapse_panel, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val panel = panels[position]
        holder.bind(panel)
    }

    override fun getItemCount(): Int {
        return panels.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvPanelContent: TextView = itemView.findViewById(R.id.tv_panel_content)
        private val imgExpand: ImageView = itemView.findViewById(R.id.img_expand)
        private val panelContainer: LinearLayout = itemView.findViewById(R.id.panel_container)
        private val tittle: TextView = itemView.findViewById(R.id.tittle)
        private val likes: TextView = itemView.findViewById(R.id.textView19)
        private val time: TextView = itemView.findViewById(R.id.textView20)

        fun bind(panel: CollapsePanel) {
            tvPanelContent.text = panel.content
            tvPanelContent.ellipsize = TextUtils.TruncateAt.END
            tittle.text = panel.tittle
            likes.text = panel.likes
            time.text = panel.time

            val Expandbtn = imgExpand
            Expandbtn.setOnClickListener {
                panel.isExpanded = !panel.isExpanded
                notifyItemChanged(adapterPosition)
                if (panel.isExpanded) {
                    tvPanelContent.maxLines = 10
                    imgExpand.setImageResource(R.drawable.ic_arrow_up)
                } else {
                    tvPanelContent.maxLines = 1
                    imgExpand.setImageResource(R.drawable.ic_arrow_down)
                }
                // 用 post() 方法更新元素，确保在布局重新计算大小后再进行更新
                tvPanelContent.post { notifyItemChanged(adapterPosition) }
            }
            if (panel.isExpanded) {
                tvPanelContent.maxLines = 10
                Expandbtn.setImageResource(R.drawable.ic_arrow_up)
            } else {
                tvPanelContent.maxLines = 1
                Expandbtn.setImageResource(R.drawable.ic_arrow_down)
            }
            // 设置折叠栏点击事件处理
            panelContainer.setOnClickListener {
                // 根据 panel.id 跳转到不同的 activity 或 fragment
                when (panel.id) {
                    1 -> {
                        val intent = Intent(itemView.context, detail_meme2::class.java)
                        itemView.context.startActivity(intent)
                    }
                    2 -> {
                        val intent = Intent(itemView.context, detail_meme3::class.java)
                        itemView.context.startActivity(intent)
                    }
                    // 可以继续添加其他 id 对应的跳转逻辑
                    else -> {
                        // 默认跳转到其他页面
                        val intent = Intent(itemView.context, explaination_memes::class.java)
                        itemView.context.startActivity(intent)
                    }
                }
            }
        }
    }
}
