package com.example.myapplication.ui.itemmodel

import android.annotation.SuppressLint
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.example.myapplication.R
import com.example.myapplication.base.BaseEpoxyHolder
import com.example.myapplication.data.Product

@EpoxyModelClass
abstract class DataItemModel : EpoxyModelWithHolder<DataItemModel.Holder>() {

    @EpoxyAttribute
    lateinit var product: Product

    @EpoxyAttribute
    var totalAmount:Boolean  = false


    override fun getDefaultLayout(): Int = if (totalAmount) R.layout.item_total_amount else R.layout.item_data

    @SuppressLint("SetTextI18n")
    override fun bind(holder: Holder) {
        super.bind(holder)
        with(holder) {
            tvAmountLabel.text = product.name
            tvAmountValue.text = "$${product.price}"
        }
    }

    class Holder : BaseEpoxyHolder() {
        val tvAmountLabel by bind<TextView>(R.id.tv_amount_label)
        val tvAmountValue by bind<TextView>(R.id.tv_amount_value)
    }
}