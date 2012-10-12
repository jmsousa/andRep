package org.jms.and.rep.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class ClientesBDAdapter {
	
	// Database Fields
		public static final String COLUMN_ROWID = "_id";
		public static final String COLUMN_NOME = "Nome";
		public static final String COLUMN_MORADA = "Morada";
		public static final String COLUMN_CP = "Cp";
		public static final String COLUMN_CPLOCAL = "Cp_Local";
		public static final String COLUMN_TLM = "Tlm";
		public static final String COLUMN_EMAIL = "Email";
		
		public static final String[] COLUMNS = new String[] { COLUMN_ROWID ,COLUMN_NOME,COLUMN_MORADA,COLUMN_CP,COLUMN_CPLOCAL,COLUMN_TLM,COLUMN_EMAIL  };
	
		public static final String DATABASE_TABELA = "Clientes";

		private Context context;
		private SQLiteDatabase database;
		private appBDHelper dbHelper;
		
		public ClientesBDAdapter(Context context) {
			this.context = context;
		}

		public ClientesBDAdapter open() throws SQLException {

			dbHelper = new appBDHelper(context);
			database = dbHelper.getWritableDatabase();

			return this;
		}
		
		public void close(){
			dbHelper.close();
		}
		
		//CRUD
		/**
		 * Cria uma nova Valor 
		 * Devolve id da Valor se tiver sucesso ou -1 caso contrario
		 */
		public long createValor( String nome, String morada,String  cp,String  cpLocal ,String  tlm,String  email ){
			
			ContentValues initialValues = createContentValues( nome,  morada ,  cp, cpLocal,  tlm  , email );
			
			return database.insert(DATABASE_TABELA, null, initialValues);
		}
		
		
		/**
		 * Actualiza Valor
		 */
		public boolean updateValor(long rowID , String nome, String morada,String  cp,String  cpLocal ,String  tlm,String  email ){
			
			
			ContentValues updateValues = createContentValues( nome,  morada ,  cp, cpLocal,  tlm  , email );
			
			return database.update(DATABASE_TABELA, updateValues, COLUMN_ROWID + "=" + rowID , null) > 0;
		}
		
		/**
		 * Delete Valor
		 */
		public boolean deleteValor(long rowID ){
			
			return database.delete(DATABASE_TABELA,COLUMN_ROWID + "=" + rowID , null) > 0 ;
		
		}
		
		/**
		 * Retorna um cursor que permite percorrer todos os valores
		 */
		public Cursor fetchAllValores(){
			
			return database.query(DATABASE_TABELA, COLUMNS, null, null, null, null, null);
		}
		
		/**
		 * Retorna um cursor posicionado num Valor especifica
		 */
		public Cursor fetchValor(long rowID) throws SQLException {
			
			Cursor mCursor = database.query( true, DATABASE_TABELA, COLUMNS, COLUMN_ROWID + "=" + rowID , null, null, null, null,null);
		
			if(mCursor !=null) mCursor.moveToFirst();
			
			
			return mCursor;
		}
		
		
		
		
		
		
		//valores da VIEW
		private ContentValues createContentValues( String nome, String morada,String  cp,String  cpLocal ,String  tlm,String  email ) {
			
			ContentValues values = new ContentValues();
			values.put(COLUMN_NOME, nome);
			values.put(COLUMN_MORADA, morada);
			values.put(COLUMN_CP, cp);
			values.put(COLUMN_CPLOCAL, cpLocal);
			values.put(COLUMN_TLM, tlm);
			values.put(COLUMN_EMAIL, email);			
			
			return values;
		}
		
}
