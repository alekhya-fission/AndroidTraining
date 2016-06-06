package com.fisstion.sample.checkinguservalidationsusingsqlitedatabase;

        import android.app.AlertDialog;
        import android.app.Dialog;
        import android.content.DialogInterface;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentTransaction;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.Button;

public class HomeActivity extends AppCompatActivity {
    private FragmentHomeMessage fragmentHomeMessage;
    private FragmentGallery fragmentGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        showHomeMessage();

    }

    // Initiating Menu XML file (menu.xml)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_item1:
                showGallery();
                return true;


            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void showHomeMessage() {
        if (fragmentHomeMessage == null)
            fragmentHomeMessage = new FragmentHomeMessage().newInstance();
        pushFragment(fragmentHomeMessage);
    }

    private void pushFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        manager.executePendingTransactions();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.galleryContainer, fragment);
        ft.commit();
    }

    private void showGallery() {
        if (fragmentGallery == null)
            fragmentGallery = new FragmentGallery().newInstance();
        pushFragment(fragmentGallery);


    }
}