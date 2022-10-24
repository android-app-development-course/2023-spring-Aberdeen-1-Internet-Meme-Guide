//package com.example.forumapp
//
//import android.app.Activity
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ArrayAdapter
//import android.widget.ImageView
//import android.widget.TextView
//
//class NewsUnit(val title:String,val imageId:Int, val author:String, val time:String)
//
////适配器
//class NewsAdapter(activity: Activity, val resourceId: Int, data: List<NewsUnit>) :
//    ArrayAdapter<NewsUnit>(activity, resourceId, data) {
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//        val view = LayoutInflater.from(context).inflate(resourceId, parent, false)
//        val newsImage: ImageView = view.findViewById(R.id.newsPicture)
//        val newsTitle: TextView = view.findViewById(R.id.newsTitle)
//        val newsTime: TextView = view.findViewById(R.id.newsTime)
//        val newsAuthor: TextView = view.findViewById(R.id.newsAuthor)
//        val news = getItem(position) // 获取当前项的news实例
//        if (news != null) {
//            newsImage.setImageResource(news.imageId)
//            newsTitle.text = news.title
//            newsTime.text = news.time
//            newsAuthor.text = news.author
//
//        }
//        return view
//    }
//}
