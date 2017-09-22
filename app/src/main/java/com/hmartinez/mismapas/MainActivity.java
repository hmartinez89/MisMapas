package com.hmartinez.mismapas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        Lugar lugar;
        switch(item.getItemId()){
            case R.id.item1_mainActivity:
                lugar = definirLugar(Double.parseDouble(getString(R.string.latitud_item1_mainActivity)), Double.parseDouble(getString(R.string.longitud_item1_mainActivity)),getString(R.string.item1_mainActivity));
                irMapas(lugar);
                break;
            case R.id.item2_mainActivity:
                lugar = definirLugar(Double.parseDouble(getString(R.string.latitud_item2_mainActivity)), Double.parseDouble(getString(R.string.longitud_item2_mainActivity)), getString(R.string.item2_mainActivity));
                irMapas(lugar);
                break;
            case R.id.item3_mainActivity:
                lugar = definirLugar(Double.parseDouble(getString(R.string.latitud_item3_mainActivity)), Double.parseDouble(getString(R.string.longitud_item3_mainActivity)), getString(R.string.item3_mainActivity));
                irMapas(lugar);
                break;
            case R.id.item4_mainActivity:
                lugar = definirLugar(Double.parseDouble(getString(R.string.latitud_item4_mainActivity)), Double.parseDouble(getString(R.string.longitud_item4_mainActivity)), getString(R.string.item4_mainActivity));
                irMapas(lugar);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public Lugar definirLugar(double latitud, double longitud, String nombre){
        Lugar lugar = new Lugar(latitud, longitud, nombre);
        return lugar;
    }
    public void irMapas(Lugar obj){
        Intent i = new Intent(this, MapsActivity.class);

        i.putExtra(getString(R.string.extra_intent_mainActivity), (Serializable) obj);
        startActivity(i);
    }
}