package co.tecniprint.tecniprintcliente;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;

public class Recepcion extends AppCompatActivity {

    private TextView txtId, txtTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recepcion);

        getWidgets();
        obtenerIntent();
    }

    private void getWidgets() {

        txtId = findViewById(R.id.txt_id);
        txtTipo = findViewById(R.id.txt_tipo);
    }

    private void obtenerIntent() {


        Intent intentLlega = getIntent();
        Uri dataLink = intentLlega.getData();
        // Toast.makeText(context, String.valueOf(dataLink.getQueryParameter("tipo")), Toast.LENGTH_LONG).show();

        final String cliente = dataLink.getQueryParameter("cliente");
        final String id = dataLink.getQueryParameter("id");

      //  Log.e("cliente",cliente);
      //  Log.e("id",id);






        assert dataLink != null;
        String document = dataLink.getEncodedQuery();
        if (document != null) {

            // asignarAtividad(tipo, id);
            txtTipo.setText(cliente);
            txtId.setText(id);


        } else {


            FirebaseDynamicLinks.getInstance()
                    .getDynamicLink(getIntent())
                    .addOnSuccessListener(this, new OnSuccessListener<PendingDynamicLinkData>() {

                        @Override

                        public void onSuccess(PendingDynamicLinkData pendingDynamicLinkData) {
                            // Get deep link from result (may be null if no link is found)
                            Uri deepLink = null;
                            if (pendingDynamicLinkData != null) {
                                deepLink = pendingDynamicLinkData.getLink();


                                assert deepLink != null;
                                if (deepLink.getEncodedQuery() != null) {
                                    String document = deepLink.getEncodedQuery();

                                    if (document != null) {
                                        // asignarAtividad(tipo, id);
                                        txtTipo.setText(cliente);
                                        txtId.setText(id);
                                    }

                                }
                            }


                        }
                    })
                    .addOnFailureListener(this, new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                        }
                    });
        }


    }
}
