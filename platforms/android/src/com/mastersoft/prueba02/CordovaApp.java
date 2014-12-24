package com.mastersoft.prueba02;

import android.os.Bundle;
//import android.content.Context;
//import android.widget.TextView;
 
import android.app.AlertDialog;  

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.cordova.*;

public class CordovaApp extends CordovaActivity 
{

@Override
public void onCreate(Bundle savedInstanceState)
{
  //Try add the below try catch

//	 String dbPath = context.getFilesDir().getParentFile().getPath();
	 
	 
	 AlertDialog.Builder builder = new AlertDialog.Builder(this);
/*
	 AlertDialog alert1 = builder.create();  
     //Setting the title manually  
     alert1.setTitle("AlertDialogExample la cagada 222 - segundo va esta");
	// alert.setTitle(dbPath);  
     alert1.show();

	 AlertDialog alert2 = builder.create();  
     alert2.setTitle("AlertDialogExample la cagada 111 - primero va esta");
     alert2.show();
*/


    super.onCreate(savedInstanceState);    
    super.init();
    // Set by <content src="index.html" /> in config.xml

	String cLabase1 =  "/data/data/com.mastersoft.prueba02/app_webview/databases/";
	String cLabase2 =  "/data/data/com.mastersoft.prueba02/app_webview/databases/file__0/";
	File cfichero1 = new File(cLabase1);
	File cfichero2 = new File(cLabase2);
	if (cfichero1.exists() || cfichero2.exists() )
		{
			//AlertDialog alert3a = builder.create();  
    		//alert3a.setTitle("La base SIIII existe. No la copia.");
    		//alert3a.show();
		}
	else
		{
			//AlertDialog alert3b = builder.create();  
    		//alert3b.setTitle("La base NOOOOO existe y la va a copiar");
	   		//alert3b.show();
			try
			 {
			//	this.copy("Databases.db","/data/data/com.mastersoft.prueba02/app_webview/databases/");
			//	this.copy("1","/data/data/com.mastersoft.prueba02/app_webview/databases/file__0/");
				this.copy("Databases.db" , cLabase1);
				this.copy("1" , cLabase2);

				//AlertDialog alert3 = builder.create();  
				//alert3.setTitle("Siiiii, ya las copio");
				//alert3.show();
			 
			 }
			 catch (IOException e)
			 {
				 AlertDialog alert4 = builder.create();  
				 alert4.setTitle("ERRORRRRR NO copia las databases");
				 alert4.show();

				 e.printStackTrace();

			  }
		}

    loadUrl(launchUrl);
}

        //Prepopulate copy function
 void copy(String file, String folder) throws IOException 
 {

  File CheckDirectory;
  CheckDirectory = new File(folder);

	// AlertDialog.Builder builder = new AlertDialog.Builder(this);
	// AlertDialog alert5 = builder.create();  
    // alert5.setTitle(folder);
    // alert5.show();


   if (!CheckDirectory.exists())
  { 
   CheckDirectory.mkdir();
  }

     InputStream in = getApplicationContext().getAssets().open(file);
     OutputStream out = new FileOutputStream(folder+file);

     // Transfer bytes from in to out
     byte[] buf = new byte[1024];
     int len; while ((len = in.read(buf)) > 0) out.write(buf, 0, len);
     in.close(); out.close();

   }
     }