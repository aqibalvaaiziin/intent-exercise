package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import model.EmailValidator;
import model.User;

public class RegisterActivity extends AppCompatActivity {
    private EditText name, email, password, confirm_password, homepage, about;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = findViewById(R.id.text_fullname);
        email = findViewById(R.id.text_email);
        password = findViewById(R.id.text_password);
        confirm_password = findViewById(R.id.text_confirm_password);
        homepage = findViewById(R.id.text_homepage);
        about = findViewById(R.id.text_about);
    }

   public void sendButton(View view){
        String nameText = name.getText().toString();
        String emailText = email.getText().toString();
        String passwordText = password.getText().toString();
        String cPasswordText = confirm_password.getText().toString();
        String homepageText = homepage.getText().toString();
        String aboutText = about.getText().toString();
        User user = new User(nameText,emailText,passwordText,cPasswordText,homepageText,aboutText);
        if(!(nameText).equals("") && !(emailText).equals("") && !(passwordText).equals("") &&
                !(cPasswordText).equals("") && !(homepageText).equals("") && !(aboutText).equals(""))
        {
            if (passwordText.equals(cPasswordText)){

                if(EmailValidator.validate(emailText)){
                    Toast.makeText(this,user.getEmail(),Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(this,ProfileActivity.class);
                    intent.putExtra("user",user);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(this, "Email Tidak Sesuai !",Toast.LENGTH_SHORT).show();
                }

            }
            else{
                Toast.makeText(this, "Password Tidak Sesuai !",Toast.LENGTH_SHORT).show();
            }

        }else{
            Toast.makeText(this, "Lengkapi data terlebih dahulu !",Toast.LENGTH_SHORT).show();
        }
   }
}
