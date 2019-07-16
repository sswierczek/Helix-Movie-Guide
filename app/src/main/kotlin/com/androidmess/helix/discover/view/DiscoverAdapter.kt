package com.androidmess.helix.discover.view

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.androidmess.helix.R
import com.androidmess.helix.common.ui.view.inflate
import com.androidmess.helix.databinding.DiscoverListItemBinding
import com.androidmess.helix.discover.model.data.DiscoverMovieViewModel

class DiscoverAdapter : RecyclerView.Adapter<DiscoverAdapter.ViewHolder>() {

    val data: MutableList<DiscoverMovieViewModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.discover_list_item, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(data[position])

    override fun getItemCount(): Int = data.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var binding: DiscoverListItemBinding = DiscoverListItemBinding.bind(view)

        fun bind(movieModel: DiscoverMovieViewModel) {
            binding.movie = movieModel
        }
    }
}
