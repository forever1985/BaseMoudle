package com.company.base_library.http;

import com.company.base_library.BuildConfig;
import com.company.base_library.http.cookie.CookieJarImpl;
import com.company.base_library.http.cookie.store.PersistentCookieStore;
import com.company.base_library.utils.KLog;
import com.company.base_library.utils.Utils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @Package:        com.wewin.print.http
 * @ClassName:      RetrofitClient
 * @Description:    网络请求封装，实现网络请求
 * @Author:         Chenqiang
 * @CreateDate:     2019/11/25 17:13
 */
public class RetrofitClient {
   //超时时间
   private static final int DEFAULT_TIMEOUT = 20;
   //缓存时间
   private static final int CACHE_TIMEOUT = 10 * 1024 * 1024;
   private Cache cache = null;
   private File httpCacheDirectory;

   private static class SingletonHolder {
       private static RetrofitClient INSTANCE = new RetrofitClient();
   }

   public static RetrofitClient getInstance() {
       return SingletonHolder.INSTANCE;
   }

   private RetrofitClient() {
   }

    /**
     * 获取app网络请求client
     * @return
     */
   private  OkHttpClient createClient (Interceptor ... interceptors) {
       if (httpCacheDirectory == null) {
           httpCacheDirectory = new File(Utils.getContext().getCacheDir(), "app_print");
       }
       try {
           if (cache == null) {
               cache = new Cache(httpCacheDirectory, CACHE_TIMEOUT);
           }
       } catch (Exception e) {
           KLog.e("Could not create http cache", e);
       }
       OkHttpClient.Builder builder = new OkHttpClient.Builder()
               .cookieJar(new CookieJarImpl(new PersistentCookieStore(Utils.getContext())))
               .cache(cache);
       if (interceptors != null && interceptors.length > 0) {
           for (Interceptor interceptor : interceptors) {
               builder.addInterceptor(interceptor);
           }
       }

       return builder
               .addInterceptor(new HttpLoggingInterceptor().setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE))
//                .addInterceptor(new LoggingInterceptor.Builder()//构建者模式
//                        .loggable(BuildConfig.DEBUG) //是否开启日志打印
//                        .setLevel(Level.BASIC) //打印的等级
//                        .log(Platform.INFO) // 打印类型
//                        .request("Request") // request的Tag
//                        .response("Response")// Response的Tag
//                        .addHeader("log-header", "I am the log request header.") // 添加打印头, 注意 key 和 value 都不能是中文
//                        .build()
//                )
               .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
               .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
               .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
               //.connectionPool(new ConnectionPool(8, 15, TimeUnit.SECONDS))
               // 这里你可以根据自己的机型设置同时连接的个数和时间，我这里8个，和每个保持时间为10s
               .build();
   }

    /**
    * create you ApiService
    * Create an implementation of the API endpoints defined by the {@code service} interface.
    */
   public <T> T create(final Class<T> service, String url, Interceptor ... interceptors) {
       if (service == null) {
           throw new RuntimeException("Api service is null!");
       }
       return new Retrofit.Builder()
               .client(createClient(interceptors))
               .addConverterFactory(GsonConverterFactory.create())
               .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
               .baseUrl(url)
               .build().create(service);
   }

   /**
    * /**
    * execute your customer API
    * For example:
    * MyApiService service =
    * RetrofitClient.getInstance(MainActivity.this).create(MyApiService.class);
    * <p>
    * RetrofitClient.getInstance(MainActivity.this)
    * .execute(service.lgon("name", "password"), subscriber)
    * * @param subscriber
    */

   public static <T> T execute(Observable<T> observable, Observer<T> subscriber) {
       observable.subscribeOn(Schedulers.io())
               .unsubscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe(subscriber);

       return null;
   }
}
