package com.fisstion.sample.checkinguservalidationsusingsqlitedatabase;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements FragmentRegister.RegisterController, FragmentLogin.LoginController {

    private FragmentLogin fragmentLogin;
    private FragmentRegister fragmentRegister;
    private FragmentHomeMessage fragmentHomeMessage;
    private FragmentGallery fragmentGallery;

    private Menu menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StoringUserDetailes userDetailes=new StoringUserDetailes(getApplicationContext());
      /*  if(userDetailes.getCount()>0&&userDetailes!=null){
            showLoginFragment();
        }
        else {
            showRegisterFragment();
        }
*/
        showLoginFragment();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        this.menu=menu;
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_item1:
                showGallery();
                return true;
            case R.id.menu_item2:
                showDialog();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void showLoginFragment() {
        if (fragmentLogin == null)
            fragmentLogin = new FragmentLogin().newInstance();
        fragmentLogin.setLoginController(this);
        pushFragment(fragmentLogin);
    }


    private void showRegisterFragment() {
        if (fragmentRegister == null)
            fragmentRegister = new FragmentRegister().newInstance();
        fragmentRegister.setRegisterController(this);
        pushFragment(fragmentRegister);
    }
    private void showHomeMessage() {
        if (fragmentHomeMessage== null)
            fragmentHomeMessage = new FragmentHomeMessage().newInstance();
        pushFragment(fragmentHomeMessage);
    }
    private void showGallery() {
        if (fragmentGallery== null)
            fragmentGallery = new FragmentGallery().newInstance();
        pushFragment(fragmentGallery);
    }
    private void showDialog(){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);
        alertDialogBuilder.setTitle("Alert Dialog");
        alertDialogBuilder
                .setMessage("you clicked on item1")
                .setCancelable(false)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }



    private void pushFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        manager.executePendingTransactions();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.container, fragment);
        ft.commit();
    }

    @Override
    public void onRegisterDone() {
        showLoginFragment();

    }

    @Override
    public void onLoginDone() {
       /* navigateToHomeActivity();*/
        showHomeMessage();
        menu.findItem(R.id.menu_item1).setVisible(true);
        menu.findItem(R.id.menu_item2).setVisible(true);
    }

    @Override
    public void onRegistrationDone() {
        showRegisterFragment();
    }

    @Override
    public void onLoginRegisterClick() {
        showRegisterFragment();

    }

    private void navigateToHomeActivity() {
        startActivity(new Intent(MainActivity.this, HomeActivity.class));
    }


}