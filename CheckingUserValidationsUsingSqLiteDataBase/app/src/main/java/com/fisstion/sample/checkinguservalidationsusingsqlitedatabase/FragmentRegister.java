package com.fisstion.sample.checkinguservalidationsusingsqlitedatabase;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class FragmentRegister extends Fragment {

    private RegisterController registerController;

    private Button mBtnRegister;
    private EditText mRegUserName,mRegPassword,mConfirmPassword;
    public FragmentRegister() {
        // Required empty public constructor
    }

    public static FragmentRegister newInstance() {
        FragmentRegister fragment = new FragmentRegister();
        return fragment;
    }

    public void setRegisterController(RegisterController registerController) {
        this.registerController = registerController;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View registerView = inflater.inflate(R.layout.fragment_register, container, false);
        mBtnRegister = (Button) registerView.findViewById(R.id.signUpBtn);
        mRegUserName=(EditText)registerView.findViewById(R.id.edtRegUserName);
        mRegPassword=(EditText)registerView.findViewById(R.id.edtRegPassword);
        mConfirmPassword=(EditText)registerView.findViewById(R.id.edtRegConfirmPassword);


        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String saveUserName=mRegUserName.getText().toString();
                String savePassword=mRegPassword.getText().toString();
                if(TextUtils.isEmpty(mRegUserName.getText().toString())){
                    printToastMessage("please enter the username");
                }
                else if(TextUtils.isEmpty(mRegPassword.getText().toString())){
                    printToastMessage("please enter the password");
                }
                else if(TextUtils.isEmpty(mConfirmPassword.getText().toString())){
                    printToastMessage("please enter the confirm password");
                }
                else if(!(mRegPassword.getText().toString().equals(mConfirmPassword.getText().toString()))){
                    printToastMessage("password and confirm password should be equal");

                }
                else{

                    StoringUserDetailes storingUserDetailes=new StoringUserDetailes(getActivity());
                    User user=new User(saveUserName,savePassword);
                    storingUserDetailes.addUser(user);
                    mRegUserName.setText("");
                    mRegPassword.setText("");
                    printToastMessage("you are sucessfully inserted");
                    registerController.onRegisterDone();

                }




            }
        });



        return registerView;
    }

    public interface RegisterController {
        void onRegisterDone();

        void onLoginRegisterClick();
    }
    public void printToastMessage(String message){
        Toast.makeText(this.getActivity(),message, Toast.LENGTH_SHORT).show();

    }


}