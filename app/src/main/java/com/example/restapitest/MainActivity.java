package com.example.restapitest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://3.36.136.219:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitAPI retrofitAPI = retrofit.create(RetrofitAPI.class);

        retrofitAPI.getList().enqueue(new Callback<List<Data>>(){
           @Override
           public void onResponse(@NonNull Call<List<Data>> call, @NonNull Response<List<Data>> response){
                if(response.isSuccessful()){
                    List<Data> data = response.body();
                    Log.d("TEST", "성공");
                    Log.d("TEST", data.get(0).getTitle());

                }
           }

           @Override
            public void onFailure(Call<List<Data>> call, Throwable t){
               t.printStackTrace();
           }
        });

        retrofitAPI.getTitles().enqueue(new Callback<List<String>>(){
            @Override
            public void onResponse(@NonNull Call<List<String>> call, @NonNull Response<List<String>> response){
                if(response.isSuccessful()){
                    List<String> data = response.body();
                    Log.d("TEST2", "성공");
                    Log.d("TEST2", data.get(0));
                    list = (ListView)findViewById(R.id.list);
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, data);
                    list.setAdapter(adapter);

                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t){
                t.printStackTrace();
            }
        });

    }
}