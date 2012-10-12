package org.jms.and.rep;


import org.jms.and.rep.R;
import org.jms.and.rep.service.ClientesBDAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class ClientesActivity extends ListActivity {
	
	private  ClientesBDAdapter clienteAdapter;
    private  Cursor cl_cursor;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);
        
        // Lista
        this.getListView().setDividerHeight(2);
        
        clienteAdapter = new ClientesBDAdapter(this);
        clienteAdapter.open();
        
        fillData();
        
    }
   
    
    private void fillData(){
    	
    	cl_cursor = clienteAdapter.fetchAllValores();
    	
    	startManagingCursor(cl_cursor);
    	//campo da BD
    	String[] from = new String[] { clienteAdapter.COLUMN_NOME   }; 
    	//campo na lista
    	int[] to = new int[] {android.R.id.text1  };
    	//array adapter 
    	SimpleCursorAdapter clientes = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1, cl_cursor , from, to);
    	setListAdapter(clientes);
    	
    	TextView tv = (TextView) this.findViewById(R.id.txt_task_list_empty);
    	
    	if(cl_cursor.getCount() > 0){
    		
    		tv.setVisibility(View.GONE);
    		
    	}else{
    		
    		tv.setVisibility(View.VISIBLE);
    		
    	}
    	
    }
    
    
    public void onNovo(View v) {
		Intent i = new Intent(this, ClienteDetailActivity.class);
		startActivity(i);
	}
    
    
    
   @Override //menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_clientes, menu);
        return true;
    }
    
   

    
}
