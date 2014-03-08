package com.malv.arduinobluetooth;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;

public class Main extends Activity implements  OnItemClickListener{

	private ListView dispostivios;
	private BluetoothUtils bluetooth;
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		//Creamos un objeto BluetoothUtils 
		//para simplificar us uso
		bluetooth = new BluetoothUtils();
		
		//Obtenemos la lista de elementos
		dispostivios = (ListView) findViewById(R.id.dispositivos);
		
		//Obtenemos los nombres de los dispositivos
		//bluetooth vinculados
		String[] nombres = bluetooth.getNames();
		
		//Asignamos los nombres a la lista
		dispostivios.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombres));

		//Leemos los "clicks" sobre los elementos de 
		//la lista
		dispostivios.setOnItemClickListener(this);
		
		
	}

	
	/**
	 * Cuando cerramos la app desconectamos
	 */
	protected void onPause() {
		super.onPause();
		bluetooth.disconnect();
	}
	
	
	
	/**
	 * Método que se ejecutará cuando se pulse sobre un elemento de la 
	 * lista. Index indicará el número del elemento pulsado.
	 */
	public void onItemClick(AdapterView<?> ag, View v, int index, long id) {
		//Conectamos con el elemento pulsado
		if (bluetooth.connect(index))
			Toast.makeText(this, R.string.conectado, Toast.LENGTH_SHORT).show();
	}

	
	
	
	
	
	/**
	 * Método que se ejecutará cuando pulsemos sobre uno de los botones
	 * de LED. El parámetro v indica que botón hemos pulsado
	 */
	public void enviar(View v) {
		
		//Si no estamos conectados, terminamos
		if (bluetooth.isConnected() == false) {
			Toast.makeText(this, R.string.primero_conectar, Toast.LENGTH_SHORT).show();
			return;
		}
			
		
		switch (v.getId()) {
			case R.id.led_1:
				bluetooth.send(1);
				break;
			case R.id.led_2:
				bluetooth.send(2);
				break;
			}
		
	}

}
