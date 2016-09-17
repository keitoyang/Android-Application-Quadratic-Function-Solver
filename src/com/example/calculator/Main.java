package com.example.calculator;

import java.text.DecimalFormat;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class Main extends Activity 
{
	double qa,qb,qc;

    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText a =(EditText) findViewById(R.id.editA);
        final EditText b =(EditText) findViewById(R.id.editB);
        final EditText c =(EditText) findViewById(R.id.editC);
        Button result = (Button) findViewById(R.id.button1);
        final TextView answer = ((TextView) findViewById(R.id.textView2));
        result.setOnClickListener(new OnClickListener() 
        {		
			public void onClick(View v) 
			{
				DecimalFormat dec = new DecimalFormat ("#.###");
				qa = Double.parseDouble(a.getText().toString());
				qb = Double.parseDouble(b.getText().toString());
				qc = Double.parseDouble(c.getText().toString());
				if (qa==0)
					answer.setText("This is not a Quadratic function, 'a' can not be 0");
				else
					if ((qb*qb-4*qa*qc)==0)
						answer.setText("There are two equal roots: "+dec.format(-qb/(2*qa)));
					else if ((qb*qb-4*qa*qc)>0)
						answer.setText("There are distince real roots: "+dec.format((-qb+Math.sqrt(qb*qb-4*qa*qc))/(2*qa))+" and "+dec.format((-qb-Math.sqrt(qb*qb-4*qa*qc))/(2*qa)));
					else
						answer.setText("There are imaginary roots (i): "+dec.format(-qb/(2*qa))+"+"+dec.format(Math.sqrt(-qb*qb+4*qa*qc)/(2*qa))+"i    and "+dec.format(-qb/(2*qa))+"-"+dec.format(Math.sqrt(-qb*qb+4*qa*qc)/(2*qa))+"i");
			}
		});
    }

    public boolean onCreateOptionsMenu(Menu menu) 
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
