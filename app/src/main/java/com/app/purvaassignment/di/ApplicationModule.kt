package com.app.purvaassignment.di

import com.app.purvaassignment.BuildConfig
import com.app.purvaassignment.responsebean.user.ResponseBean
import com.app.purvaassignment.ui.activity.dashboard.MainViewModel
import io.reactivex.Single
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.util.concurrent.TimeUnit


val uiModule = module {
    viewModel { MainViewModel(get()) }
    single<GetUserApi> { getRetrofitApi(createOkHttpClient()) }
}

val appModule = listOf(uiModule)


fun createOkHttpClient(timeout: Long = 120): OkHttpClient {
    val client = OkHttpClient.Builder()
    client.addInterceptor(HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    })
    client.callTimeout(timeout, TimeUnit.SECONDS)
    client.readTimeout(timeout, TimeUnit.SECONDS)
    client.writeTimeout(timeout, TimeUnit.SECONDS)
    return client.build()
}

inline fun <reified T> getRetrofitApi(okHttpClient: OkHttpClient): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())

        .build()
    return retrofit.create(T::class.java)
}


interface GetUserApi {
    @GET("?results=100")
    fun getUserDetails(): Single<ResponseBean>
}
