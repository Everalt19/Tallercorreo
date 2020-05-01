package com.tallercorreo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    Button button;
    EditText correo, asunto, mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        correo = findViewById(R.id.caja_correo);
        asunto = findViewById(R.id.caja_asunto);
        mensaje = findViewById(R.id.caja_mensaje);
        button = findViewById(R.id.btn_enviar);


        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view)
            {
                String enviarcorreo = correo.getText().toString();
                String enviarasunto = asunto.getText().toString();
                String enviarmensaje = mensaje.getText().toString();


                Intent intent = new Intent(Intent.ACTION_SEND);


                intent.putExtra(Intent.EXTRA_EMAIL,
                        new String[] { enviarcorreo });
                intent.putExtra(Intent.EXTRA_SUBJECT, enviarasunto);
                intent.putExtra(Intent.EXTRA_TEXT, enviarmensaje);


                intent.setType("message/rfc822");


                startActivity(
                        Intent
                                .createChooser(intent,
                                        "Seleccione un Cliente de Correo:"));


                correo.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        correo.setText(" ");
                        asunto.setText(" ");
                        mensaje.setText(" ");
                        correo.requestFocus();
                    }
                }, 5000);



            }
        });



    }

}
