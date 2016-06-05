package com.fisstion.sample.checkinguservalidationsusingsqlitedatabase;

        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.text.TextUtils;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;


public class FragmentLogin extends Fragment {


    private LoginController loginController;
    private Button mBtnLogin,mBtnRegister;
    private EditText mEdtLoginUserName,mEdtLoginPassword;

    public FragmentLogin() {

    }

    public static FragmentLogin newInstance() {
        FragmentLogin fragment = new FragmentLogin();
        return fragment;
    }

    public void setLoginController(LoginController loginController){
        this.loginController = loginController;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View loginView  = inflater.inflate(R.layout.fragment_login, container, false);

        mBtnLogin = (Button)loginView.findViewById(R.id.loginBtn);
        mEdtLoginUserName=(EditText)loginView.findViewById(R.id.edtUserName);
        mEdtLoginPassword=(EditText)loginView.findViewById(R.id.edtPassWord);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loginUserName=mEdtLoginUserName.getText().toString();
                String loginPassword=mEdtLoginPassword.getText().toString();
                if(TextUtils.isEmpty(loginUserName)){
                    printToastMessage("please enter the username");
                }
                else if(TextUtils.isEmpty(loginPassword)){
                    printToastMessage("please enter the password");
                }
                else {
                    StoringUserDetailes storingUserDetailes=new StoringUserDetailes(getContext());
                      int count=storingUserDetailes.checkUserIsThereOrNot(loginUserName,loginPassword);
                    if(count>0){
                        loginController.onLoginDone();
                    }
                    else{
                        printToastMessage("please register");
                    }
                }
            }
        });

        return loginView;


    }

    public interface LoginController{
        void onLoginDone();
    }
    public void printToastMessage(String message){
        Toast.makeText(this.getContext(),message, Toast.LENGTH_SHORT).show();

    }



}