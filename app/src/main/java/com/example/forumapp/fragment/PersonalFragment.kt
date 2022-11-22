package com.example.forumapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.forumapp.R

class PersonalFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_personal, container, false)
        val FavoritesButton = view.findViewById<Button>(R.id.FavoritesButton)
        val BrowsingHistoryButton = view.findViewById<Button>(R.id.BrowsingHistoryButton)
        FavoritesButton.setOnClickListener {
            replaceComponent(CollectFragment())
            true
        }
        BrowsingHistoryButton.setOnClickListener {
            replaceComponent(BrowsingHistoryFragment())
            true
        }
        return inflater.inflate(R.layout.fragment_personal, container, false)
    }
    private fun replaceComponent(fragment: Fragment) {
        val fragmentManager = childFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.mainArea,fragment)
        transaction.commit()
    }
}