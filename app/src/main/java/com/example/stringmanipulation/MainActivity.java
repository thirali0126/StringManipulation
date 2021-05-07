package com.example.stringmanipulation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edinput,edoutput,edskip;
    ImageButton btngo;
    String out="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWidgets();

        btngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input=edinput.getText().toString();
                int n=Integer.parseInt(edskip.getText().toString());
                String result="";
                out="";

                ArrayList<String> splittedList=new ArrayList<>();
                String str[];

                ArrayList<Integer> al=new ArrayList<Integer>();
                ArrayList<String> splitResult=new ArrayList<String>();
                for(int i=0;i<input.length();i++) {
                    if(input.charAt(i)=='.'|| input.charAt(i)=='?' || input.charAt(i)=='!')
                    {
                        al.add(i);
                        splitResult.add(""+input.charAt(i));
                    }
                }
                str=new String[al.size()];
                //System.out.println(al);
                //System.out.println(splitResult);
                int start=0;
                for(int i=0;i<al.size();i++){
                    String sub = input.substring(start,al.get(i));
                    start=al.get(i)+1;
                    // System.out.println(s);
                    String temp=sub+splitResult.get(i);
                    // System.out.println(temp);
                    splittedList.add(temp);

                }
                str = splittedList.toArray(str);


                for (int i = 0; i < str.length; i++) {
                    str[i]=str[i].trim();
                    String[] w = str[i].split(" ");
                    result = "";
                    if(w.length>n) {
                        for (int rev = w.length - (n + 1); rev >= 0; rev--) {
                            result += (w[rev] + " ");
                        }
                        for (int x = (w.length - n); x < w.length; x++) {
                            if (x == (w.length - 1)) {
                                result += (w[x] + "");
                            } else {
                                result += (w[x] + " ");
                            }
                        }
                        out += (result + " ");
                    }
                    else{
                        for (int y = 0; y < w.length; y++) {
                            if(y == (w.length-1)){
                                result += (w[y] + "") ;
                            }else{
                                result += (w[y] + " ") ;
                            }
                        }
                        out+=(result +" ");
                    }
                }
                    //edoutput.setText(output);
                loadFragment(new output());

                }


        });
    }

    private void getWidgets() {
        edinput= findViewById(R.id.edinput);
        edskip= findViewById(R.id.edskip);
        //edoutput=findViewById(R.id.edoutput);
        btngo= findViewById(R.id.btngo);
    }
    public void loadFragment(Fragment f){

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("string",out);
        f.setArguments(bundle);
        ft.replace(R.id.frame,f);

        ft.commit();
    }
}