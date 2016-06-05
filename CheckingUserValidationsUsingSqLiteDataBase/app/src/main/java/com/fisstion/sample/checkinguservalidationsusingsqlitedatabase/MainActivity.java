package com.fisstion.sample.checkinguservalidationsusingsqlitedatabase;

        import android.content.Intent;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentTransaction;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements FragmentRegister.RegisterController, FragmentLogin.LoginController {

    private FragmentLogin fragmentLogin;
    private FragmentRegister fragmentRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StoringUserDetailes userDetailes=new StoringUserDetailes(getApplicationContext());
        if(userDetailes.getCount()>0&&userDetailes!=null){
            showLoginFragment();
        }
        else {
            showRegisterFragment();
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
        navigateToHomeActivity();
    }

    private void navigateToHomeActivity() {
        startActivity(new Intent(MainActivity.this, HomeActivity.class));
    }


}