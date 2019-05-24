package com.example.hp.testingmvp.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hp.testingmvp.Presenter.PrezenterActivity;
import com.example.hp.testingmvp.R;



public class ViewActivity extends AppCompatActivity implements LoginActivityView {
    Button buttonLogin,buttonCreate;
    EditText editTextLogin,editTextPassword;
    LoginPresenter mPresenter = new LoginPresenter(ViewActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        editTextLogin.findViewById(R.id.LoginEdittext);
        editTextPassword.findViewById(R.id.PasswordEdittext);
        buttonLogin.findViewById(R.id.Login);

        mPresenter.onCreate(getIntent());

        Intent myIntent = new Intent(ViewActivity.this,PrezenterActivity.class);
        String context = editTextPassword.getText().toString();
        String context2 = editTextLogin.getText().toString();
        myIntent.putExtra("UserName",context);
        myIntent.putExtra("UserPassword",context2);
        startActivity(myIntent);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.login(editTextLogin.getText().toString(), editTextPassword.getText().toString());
            }
        });
    }
    PrezenterActivity getPresenter() {
        return mPresenter;
    }
}
