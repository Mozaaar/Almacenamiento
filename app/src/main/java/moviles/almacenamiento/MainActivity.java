package moviles.almacenamiento;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Context;
import android.util.Log;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button botonMostrarTexto;
    TextView textView;
    Button guardarArchivo;
    String textoIngresado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.output_text);
        botonMostrarTexto = findViewById(R.id.btn_upload);
        textView = findViewById(R.id.txt_textview);


        botonMostrarTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                textoIngresado = editText.getText().toString();
                textView.setText(textoIngresado);
            }
        });


        guardarArchivo = findViewById(R.id.btn_save);

        guardarArchivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    OutputStreamWriter fout =
                            new OutputStreamWriter(openFileOutput(textoIngresado, Context.MODE_PRIVATE));

                    fout.write(textoIngresado);
                    fout.close();
                } catch (Exception ex) {
                    Log.e("Ficheros", "Error al escribir fichero a memoria interna");
                }
            }
        });

    }

    }
