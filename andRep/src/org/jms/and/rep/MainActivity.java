package org.jms.and.rep;

import org.jms.and.rep.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.app.NavUtils;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void onClientes(View v) {

		Intent i = new Intent(this, ClientesActivity.class);
		// i.putExtra(TarefaDetailActivity.ACTIVITY_METHOD,
		// TarefaDetailActivity.METHOD_ADD);
		startActivity(i);
	}

	public void onMaquinas(View v) {
		Intent i = new Intent(this, MaquinasActivity.class);
		startActivity(i);
	}

	public void onReparacoes(View v) {
		Intent i = new Intent(this, ReparacoesActivity.class);
		startActivity(i);
	}

}
