package com.example.retrofitdemousingrealapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ObjectDataClass> allDataList;
    RecyclerView recyclerView;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        Retrofit retrofit=new Retrofit
                                .Builder ()
                                .baseUrl ("https://cricket.sportmonks.com/api/v2.0/")
                                .addConverterFactory (GsonConverterFactory.create ())
                                .build ();


       OurRetrifitClient ourRetrifitClient=retrofit.create (OurRetrifitClient.class);
        Call<OurMainDataClass> call= ourRetrifitClient.getData ("ZmLDt1kAZj4e1KDbsJyon8jMO03QbyB9bPOjarbNr7qikBAhgCQYQ665XPTE");

        call.enqueue (new Callback<OurMainDataClass> () {
            @Override
            public void onResponse(Call<OurMainDataClass> call, Response<OurMainDataClass> response) {
                if (response.isSuccessful ()){
                    allDataList  = new ArrayList<> ();
                    allDataList.addAll(response.body().getData ());

                    if (allDataList.size ()>0){
                        adapter = new CustomAdapter (MainActivity.this,allDataList);
                        recyclerView.setLayoutManager(new LinearLayoutManager (MainActivity.this));
                        recyclerView.setAdapter(adapter);

                        Toast.makeText (MainActivity.this, String.valueOf (allDataList.size ()), Toast.LENGTH_SHORT).show ();
                    }

                    //Toast.makeText (MainActivity.this, String.valueOf (allDataList.size ()), Toast.LENGTH_SHORT).show ();
                }
            }

            @Override
            public void onFailure(Call<OurMainDataClass> call, Throwable t) {

            }
        });
    }
}
