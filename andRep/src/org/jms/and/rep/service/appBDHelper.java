package org.jms.and.rep.service;

import android.content.Context;
import android.database.sqlite.*;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class appBDHelper extends SQLiteOpenHelper {
	
	
	private static final String DATABASE_NAME = "RepBD_01";
	private static final int DATABASE_VERSION = 1;
	
	// Database creation sql statement
		private static final String TABLE_CREATE_CLIENTES = "create table Clientes( _id integer primary key autoincrement , "
				+ "Nome text, Morada text, Cp text, Cp_Local text , Tlm text , Email text   ) ; ";
	
		
	public appBDHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	public appBDHelper(Context context, String name,CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//criar tabela de tarefas
		db.execSQL(TABLE_CREATE_CLIENTES);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
