package com.example.aadproject.utils

import android.net.Uri
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.example.aadproject.R
import com.example.aadproject.data.EntityGads
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_learning_leader.view.*

@BindingAdapter("bind_learner_badge")
fun ImageView.topLearnerBadge(item: EntityGads) {
    val uri = Uri.parse(item.badgeUrl).buildUpon().scheme("https").build()
    Picasso.get().load(uri)
        .fit()
        .centerInside()
        .into(this)

}

@BindingAdapter("bind_learner_name")
fun TextView.topLearnerName(item: EntityGads) {
    this.text = item.name
}

@BindingAdapter("bind_learner_description")
fun TextView.topLearnerDescription(item: EntityGads) {
    this.text = resources.getString(R.string.learning_description, item.hours, item.country)
}