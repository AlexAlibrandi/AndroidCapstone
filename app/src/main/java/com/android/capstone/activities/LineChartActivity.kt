package com.android.capstone.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.capstone.R
import com.android.capstone.databinding.LineChartActivityBinding
import com.android.capstone.models.ResultsModel
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.AxisBase
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query




val db = FirebaseFirestore.getInstance()
var query: Query = db.collection("Results").orderBy("date", Query.Direction.DESCENDING)

class LineChartActivity : AppCompatActivity() {

    private lateinit var lineChart: LineChart
    private var scoreList = ArrayList<ResultsModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.line_chart_activity)


        lineChart = findViewById(R.id.lineChart)


        initLineChart()


        setDataToLineChart()

    }

    private fun initLineChart() {

//        hide grid lines
        lineChart.axisLeft.setDrawGridLines(false)
        val xAxis: XAxis = lineChart.xAxis
        xAxis.setDrawGridLines(false)
        xAxis.setDrawAxisLine(false)

        //remove right y-axis
        lineChart.axisRight.isEnabled = false

        //remove legend
        lineChart.legend.isEnabled = false


        //remove description label
        lineChart.description.isEnabled = false


        //add animation
        lineChart.animateX(1000, Easing.EaseInSine)

        // to draw label on xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM_INSIDE
        xAxis.valueFormatter = MyAxisFormatter()
        xAxis.setDrawLabels(true)
        xAxis.granularity = 1f
        xAxis.labelRotationAngle = +90f

    }


    inner class MyAxisFormatter : IndexAxisValueFormatter() {

        override fun getAxisLabel(value: Float, axis: AxisBase?): String {
            val index = value.toInt()
            return if (index < scoreList.size) {
                scoreList[index].title
            } else {
                "error"
            }
        }
    }

    private fun setDataToLineChart() {

        query.get().addOnSuccessListener {
            for (document in it) {
                val resultsModel = ResultsModel(
                    document.data["title"].toString(),
                    document.data["confidence"].toString().toFloat(),
                    document.data["date"].toString()
                )
                scoreList.add(resultsModel)
            }

            val entries = ArrayList<Entry>()

            for (i in 0 until scoreList.size) {
                entries.add(Entry(i.toFloat(), scoreList[i].confidence))
            }

            val lineDataSet = LineDataSet(entries, "Score")
            lineDataSet.setDrawCircles(false)
            lineDataSet.setDrawValues(false)
            lineDataSet.setDrawFilled(true)
            lineDataSet.fillColor = resources.getColor(R.color.black)
            lineDataSet.fillAlpha = 100

            val lineData = LineData(lineDataSet)
            lineChart.data = lineData
        }

    }

    }



