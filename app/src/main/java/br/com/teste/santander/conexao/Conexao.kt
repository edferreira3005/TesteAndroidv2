package br.com.spotpromo.tigre_promotor.util.webclient.retrofit

import android.content.Context
import br.com.spotpromo.tigre_promotor.util.webclient.retrofit.interface_client.MobileInferface
import br.com.teste.santander.R
import br.com.teste.santander.model.Json
import retrofit2.Call

class Conexao : RetrofitClient() {

    fun get(url: String, context: Context): Call<Json> {
        val dados = getClient(context.resources.getString(R.string.url_principal), MobileInferface::class.java) as MobileInferface
        return dados.get(url)
    }

    fun post(url: String, data: HashMap<String, String>, context: Context): Call<Json> {
        val dados = getClient(context.resources.getString(R.string.url_principal), MobileInferface::class.java) as MobileInferface
        return dados.post(url, data)
    }

}