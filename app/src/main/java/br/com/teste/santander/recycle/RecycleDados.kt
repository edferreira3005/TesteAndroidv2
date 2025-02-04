package br.com.teste.santander.recycle

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.teste.santander.R
import br.com.teste.santander.model.Dados
import br.com.teste.santander.util.FormataData
import java.lang.Exception
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class RecycleDados(private val lista: ArrayList<Dados>) :
    RecyclerView.Adapter<RecycleDados.ViewHolder>() {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        internal var title: TextView = v.findViewById(R.id.title) as TextView
        internal var desc: TextView = v.findViewById(R.id.desc) as TextView
        internal var date: TextView = v.findViewById(R.id.date) as TextView
        internal var value: TextView = v.findViewById(R.id.value) as TextView

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.recycle_dados, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, p1: Int) {

        try {
            val statement = this.lista[p1]

            holder.title.text = statement.title
            holder.desc.text = statement.desc

            val format = SimpleDateFormat("yyyy-MM-dd")
            val date = format.parse(statement.date) as Date
            val formatada =
                FormataData.get(FormataData.getCalendar(format.format(date), FormataData.SQLData), FormataData.DiaMesAno)

            holder.date.text = formatada

            val meuLocal = Locale("pt", "BR")
            val valor = NumberFormat.getCurrencyInstance(meuLocal).format(statement.value)

            holder.value.text = valor
        } catch (err : Exception) {
            err.printStackTrace()
        }

    }
}