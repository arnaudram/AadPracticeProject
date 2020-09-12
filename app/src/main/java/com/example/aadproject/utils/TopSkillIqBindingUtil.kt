package com.example.aadproject.utils

import android.net.Uri
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.aadproject.R
import com.example.aadproject.data.EntityGads
import com.example.aadproject.data.EntityGadsSkill
import com.squareup.picasso.Picasso


@BindingAdapter("bind_skill_iq_badge")
fun ImageView.topSkillIqBadge(item: EntityGadsSkill) {
    val uri = Uri.parse(item.badgeUrl).buildUpon().scheme("https").build()
    Picasso.get().load(uri)
        .fit()
        .centerInside()

        .into(this)

}

@BindingAdapter("bind_skill_iq_name")
fun TextView.topSkillIqName(item: EntityGadsSkill) {
    this.text = item.name
}

@BindingAdapter("bind_skill_iq_description")
fun TextView.topSkilliqDescription(item: EntityGadsSkill) {
    this.text = resources.getString(R.string.skill_iq_description, item.score, item.country)
}