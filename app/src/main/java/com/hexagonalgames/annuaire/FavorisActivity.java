package com.hexagonalgames.annuaire;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class FavorisActivity extends AppCompatActivity {

    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoris);

        // On exécute la requète sur la base
        Cursor c = DBHelper.getDBHelper(this).getAll();

        // On créer un adaptateur, chargé de convertir les lignes du résultats en vues
        String[] columnName = {"nom","prenom","mail"}; // les noms des champs utilisés
        int[] columnId = {R.id.textViewNom,R.id.textViewPrenom,R.id.textViewMail};
        // les id des vues à utiliser, dans le même ordre que les champs
        adapter = new SimpleCursorAdapter(this,
                R.layout.personne_fav, // La mise en page de chaque ligne
                c, // les données à afficher
                columnName, // champs à afficher
                columnId, // dans quelles vues
                0); // options

        // On récupère le listView à configurer
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter); // on définit le contenu
//        listView.setOnItemClickListener(this); // on écoute les clics sur les lignes
    }

    public  void onClickFav(View view){
        Intent intent = new Intent(this, FavorisActivity.class); // On indique l'activité à lancer
        startActivity(intent); // lancement de la nouvelle activité
    }

    public  void onClickMain(View view){
        Intent intent = new Intent(this, MainActivity.class); // On indique l'activité à lancer
        startActivity(intent); // lancement de la nouvelle activité
    }

    public  void onClickLi(View view){
        Intent intent = new Intent(this, LiensActivity.class); // On indique l'activité à lancer
        startActivity(intent); // lancement de la nouvelle activité
    }

    public  void onClickTag(View view){
        Intent intent = new Intent(this, TagActivity.class); // On indique l'activité à lancer
        startActivity(intent); // lancement de la nouvelle activité
    }
}
