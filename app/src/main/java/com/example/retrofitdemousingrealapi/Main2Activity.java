package com.example.retrofitdemousingrealapi;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    TextView id,name,resource,updated_at;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main2);
        id=findViewById (R.id.Id);
        name=findViewById (R.id.Name);
        resource=findViewById (R.id.resource);
        updated_at=findViewById (R.id.updated_at);

        Retrofit retrofit1=new Retrofit
                .Builder ()
                .baseUrl ("https://cricket.sportmonks.com/api/v2.0/")
                .addConverterFactory (GsonConverterFactory.create ())
                .build ();

        OurRetrofitClient2 ourRetrofitClient2=retrofit1.create (OurRetrofitClient2.class);
        Call<OurMainDataClass2> call= ourRetrofitClient2.getData (2,"ZmLDt1kAZj4e1KDbsJyon8jMO03QbyB9bPOjarbNr7qikBAhgCQYQ665XPTE");
    call.enqueue (new Callback<OurMainDataClass2> () {
        @Override
        public void onResponse(Call<OurMainDataClass2> call, Response<OurMainDataClass2> response) {
            if (response.isSuccessful ()){

                ObjectDataClass objectDataClass=response.body ().getData ();

                id.setText (String.valueOf (objectDataClass.getId ()));
                name.setText (objectDataClass.getName ());
                resource.setText (objectDataClass.getResource ());
                updated_at.setText (objectDataClass.getUpdated_at ());

                Toast.makeText (Main2Activity.this, String.valueOf (objectDataClass.getName ()), Toast.LENGTH_SHORT).show ();

            }
        }

        @Override
        public void onFailure(Call<OurMainDataClass2> call, Throwable t) {

        }
    });

    }
}
