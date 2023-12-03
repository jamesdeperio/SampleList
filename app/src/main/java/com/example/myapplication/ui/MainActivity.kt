package com.example.myapplication.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.data.Product
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.itemmodel.dataItem
import com.example.myapplication.util.viewBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private val binding by viewBinding<ActivityMainBinding>()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbar)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        binding.recyclerView.withModels {
            val data = createRandomItems()
            data.forEachIndexed { index, product ->
                dataItem {
                    id("${product.name}:$index")
                    product(product)
                }
            }

            dataItem {
                id("TOTAL_AMOUNT")
                product(Product("Total",String.format("%.2f",data.sumOf { it.price }).toDouble()))
                totalAmount(true)
            }
        }
    }

    private fun createRandomItems(): List<Product> {
        val lineItems = mutableListOf<Product>()
        lineItems.add(Product("Toothpaste", String.format("%.2f",Random.nextDouble(10.0, 100.0)).toDouble()))
        lineItems.add(Product("Toothbrush", String.format("%.2f",Random.nextDouble(10.0, 100.0)).toDouble()))
        lineItems.add(Product("Mouthwash", String.format("%.2f",Random.nextDouble(10.0, 100.0)).toDouble()))
        lineItems.add(Product("Hand Soap", String.format("%.2f",Random.nextDouble(10.0, 100.0)).toDouble()))
        lineItems.add(Product("Candles", String.format("%.2f",Random.nextDouble(10.0, 100.0)).toDouble()))
        lineItems.add(Product("Cotton", String.format("%.2f",Random.nextDouble(10.0, 100.0)).toDouble()))
        lineItems.add(Product("Body Wash", String.format("%.2f",Random.nextDouble(10.0, 100.0)).toDouble()))
        lineItems.add(Product("Floss",  String.format("%.2f",Random.nextDouble(10.0, 100.0)).toDouble()))
        lineItems.add(Product("Electric Toothbrush",  String.format("%.2f",Random.nextDouble(10.0, 100.0)).toDouble()))
        lineItems.add(Product("Cologne", String.format("%.2f",Random.nextDouble(10.0, 100.0)).toDouble()))
        return lineItems
    }
}