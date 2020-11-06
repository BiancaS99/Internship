package com.example.sdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.List;

import static android.widget.Toast.LENGTH_LONG;

public class LoginActivity extends AppCompatActivity {
private TextView mTitle,mRegister,mFogPass;
private EditText mEmail,mPass;
private Button mLog;
private FirebaseAuth fauth;
private FirebaseAuth.AuthStateListener fAuthListener;
private FirebaseDatabase database;
    private DatabaseReference ref;
    private static  final   String TAG="Login";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mTitle=findViewById(R.id.l_Title);
        mRegister=findViewById(R.id.l_register);
        mFogPass=findViewById(R.id.l_forget_pass);
        mEmail=findViewById(R.id.l_email);
        mPass=findViewById(R.id.l_pass);
        mLog=findViewById(R.id.l_login);
        fauth=FirebaseAuth.getInstance();
//        fAuthListener= new FirebaseAuth.AuthStateListener(){
//
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser user1 = fauth.getCurrentUser();
//                if(user1!=null){
//                    Log.d(TAG, "signInWithEmail:success"+user1.getUid());
//                }else{
//                    Log.d(TAG, "signInWithEmail:denied");
//                }
//
//
//            }
//        };

        mLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= mEmail.getText().toString().trim();
                String pass=mPass.getText().toString().trim();
                if(validate()){
                    //Toast.makeText(LoginActivity.this,"Totul este ok",Toast.LENGTH_LONG).show();
                     fauth.signInWithEmailAndPassword(email,pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(LoginActivity.this, "Autentificarea s-a efectuat cu succes", Toast.LENGTH_SHORT).show();
                                    Intent intent10=new Intent(LoginActivity.this,Collection.class);
                                    startActivity(intent10);


                                }else{
                                    Toast.makeText(LoginActivity.this,"Autentificarea nu s-a efectuat cu succes",LENGTH_LONG).show();

                                }
                            }
                        });



                }


            }
        });
        SpannableString ss= new SpannableString(getString(R.string.inreg));
        ss.setSpan(new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent11=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent11);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
                ds.setTypeface(Typeface.DEFAULT_BOLD);
            }
        },36,41, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        mRegister.setText(ss);
        mRegister.setMovementMethod(LinkMovementMethod.getInstance());
        SpannableString sfp= new SpannableString(getString(R.string.forgot_pass));
        sfp.setSpan(new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent intent10=new Intent(LoginActivity.this,ResetPass.class);
                startActivity(intent10);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
                ds.setTypeface(Typeface.DEFAULT_BOLD);
            }
        },0,17, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        mFogPass.setText(sfp);
        mFogPass.setMovementMethod(LinkMovementMethod.getInstance());

    }

    public boolean validate(){
        boolean valid=true;
        String email= mEmail.getText().toString();
        String pass=mPass.getText().toString();

        if(email.isEmpty()|| !Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            mEmail.setError("Email-ul nu are formatul corect!");
            valid=false;
        }
        if(pass.isEmpty()||pass.length()<6){
            mPass.setError("Parola trebuie sa aiba mai mult de 6 carectere");

            valid=false;
        }
        return valid;
    }
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = fauth.getCurrentUser();
//        updateUI(currentUser);
//    }

}
