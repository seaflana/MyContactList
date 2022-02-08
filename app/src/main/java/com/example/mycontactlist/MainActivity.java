//how to go from one activity to another


package com.example.mycontactlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.SaveDateListener {

    private Contact currentContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initListButton();
        initMapButton();
        initSettingsButton();
        initToggleButton();

        //onCreate code to Get and Use Passed ID
        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            initContact(extras.getInt("contactid"));
        }
        else {
            currentContact = new Contact();
        }

        setForEditing(false);
        initChangeDateButton();
        initTextChangedEvents();
        initSavebutton();
    }

    private void initListButton() {
        ImageButton ibList = findViewById(R.id.imageButtonList);
        ibList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ContactListActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void initMapButton() {
        ImageButton ibList = findViewById(R.id.imageButtonMap);
        ibList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ContactMapActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }


    //Change contact settings activity to go to MainActivity
    private void initSettingsButton() {
        ImageButton ibList = findViewById(R.id.imageButtonSettings);
        ibList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ContactSettingsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void initToggleButton() {
        final ToggleButton editToggle = (ToggleButton) findViewById(R.id.toggleButtonEdit);
        editToggle.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                setForEditing(editToggle.isChecked());
            }
        });
    }

    private void initChangeDateButton() {
        Button changeDate = findViewById(R.id.buttonBirthday);
        changeDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                FragmentManager fm = getSupportFragmentManager();
                DatePickerDialog datePickerDialog = new DatePickerDialog();
                datePickerDialog.show(fm, "DatePick");
            }
        });
    }

    //TextChanged Event method
    private void initTextChangedEvents() {
        final EditText etContactName = findViewById(R.id.editName);
        etContactName.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentContact.setContactName(etContactName.getText().toString());
            }
        });

        final EditText etStreetAddress = findViewById(R.id.editAddress);
        etStreetAddress.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentContact.setStreetAddress(etStreetAddress.getText().toString());
            }
        });

        final EditText etCity = findViewById(R.id.editCity);
        etCity.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentContact.setCity(etCity.getText().toString());
            }
        });

        final EditText etState = findViewById(R.id.editState);
        etState.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentContact.setState(etState.getText().toString());
            }
        });

        final EditText etZipcode = findViewById(R.id.editZipcode);
        etZipcode.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentContact.setZipCode(etZipcode.getText().toString());
            }
        });

        final EditText etHome = findViewById(R.id.editHome);
        etHome.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentContact.setPhoneNumber(etHome.getText().toString());
            }
        });

        final EditText etCell = findViewById(R.id.editCell);
        etCell.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentContact.setCellNumber(etCell.getText().toString());
            }
        });

        final EditText etEmail = findViewById(R.id.editEmail);
        etEmail.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                currentContact.setEMail(etEmail.getText().toString());
            }
        });

        etHome.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        etCell.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
    }

    //Save Button method
    private void initSavebutton() {
        Button saveButton = findViewById(R.id.buttonSave);
        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                hideKeyboard();
                boolean wasSuccessful;
                ContactDataSource ds = new ContactDataSource(MainActivity.this);
                try {
                    ds.open();

                    if (currentContact.getContactID() == -1) {
                        wasSuccessful = ds.insertContact(currentContact);

                        if (wasSuccessful) {
                            int newId = ds.getLastContactID();
                            currentContact.setContactID(newId);   /////
                        }

                    }
                    else {
                        wasSuccessful = ds.updateContact(currentContact);
                    }
                    ds.close();
                }
                catch (Exception e) {
                    wasSuccessful = false;
                }

                if (wasSuccessful) {
                    ToggleButton editToggle = findViewById(R.id.toggleButtonEdit);
                    editToggle.toggle();
                    setForEditing(false);
                }
            }
        });
    }

    //Method to Load a Contact
    private void initContact(int id) {

        ContactDataSource ds = new ContactDataSource(MainActivity.this);
        try {
            ds.open();
            currentContact = ds.getSpecificContact(id);
            ds.close();
        }
        catch (Exception e) {
            Toast.makeText(this, "Load Contact Failed", Toast.LENGTH_LONG).show();
        }

        EditText editName = findViewById(R.id.editName);
        EditText editAddress = findViewById(R.id.editAddress);
        EditText editCity = findViewById(R.id.editCity);
        EditText editState = findViewById(R.id.editState);
        EditText editZipCode = findViewById(R.id.editZipcode);
        EditText editPhone = findViewById(R.id.editHome);
        EditText editCell = findViewById(R.id.editCell);
        EditText editEmail = findViewById(R.id.editEmail);
        TextView birthDay = findViewById(R.id.textBirthday);

        editName.setText(currentContact.getContactName());
        editAddress.setText(currentContact.getStreetAddress());
        editCity.setText(currentContact.getCity());
        editState.setText(currentContact.getState());
        editZipCode.setText(currentContact.getZipCode());
        editPhone.setText(currentContact.getPhoneNumber());
        editCell.setText(currentContact.getCellNumber());
        editEmail.setText(currentContact.getEMail());
        birthDay.setText(DateFormat.format("MM/dd/yyyy",
                currentContact.getBirthday().getTimeInMillis()).toString());
    }

    //Partial hideKeyboard() Method
    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        EditText editName = findViewById(R.id.editName);
        imm.hideSoftInputFromWindow(editName.getWindowToken(), 0);
        EditText editAddress = findViewById(R.id.editAddress);
        imm.hideSoftInputFromWindow(editAddress.getWindowToken(), 0);
        EditText editCity = findViewById(R.id.editCity);
        imm.hideSoftInputFromWindow(editCity.getWindowToken(), 0);
        EditText editState = findViewById(R.id.editState);
        imm.hideSoftInputFromWindow(editState.getWindowToken(), 0);
        EditText editZipcode = findViewById(R.id.editZipcode);
        imm.hideSoftInputFromWindow(editZipcode.getWindowToken(), 0);
        EditText editHome = findViewById(R.id.editHome);
        imm.hideSoftInputFromWindow(editHome.getWindowToken(), 0);
        EditText editCell= findViewById(R.id.editCell);
        imm.hideSoftInputFromWindow(editCell.getWindowToken(), 0);
        EditText editEmail = findViewById(R.id.editEmail);
        imm.hideSoftInputFromWindow(editEmail.getWindowToken(), 0);
    }

    //Code to enable the Data Entry Form
    private void setForEditing(boolean enabled) {
        EditText editName = findViewById(R.id.editName);
        EditText editAddress = findViewById(R.id.editAddress);
        EditText editCity = findViewById(R.id.editCity);
        EditText editState = findViewById(R.id.editState);
        EditText editZipCode = findViewById(R.id.editZipcode);
        EditText editPhone = findViewById(R.id.editHome);
        EditText editCell = findViewById(R.id.editCell);
        EditText editEmail = findViewById(R.id.editEmail);
        Button buttonChange = findViewById(R.id.buttonBirthday);
        Button buttonSave = findViewById(R.id.buttonSave);

        editName.setEnabled(enabled);
        editAddress.setEnabled(enabled);
        editCity.setEnabled(enabled);
        editState.setEnabled(enabled);
        editZipCode.setEnabled(enabled);
        editPhone.setEnabled(enabled);
        editCell.setEnabled(enabled);
        editEmail.setEnabled(enabled);
        buttonChange.setEnabled(enabled);
        buttonSave.setEnabled(enabled);

        if (enabled) {
            editName.requestFocus();
        }
        else{
            ScrollView s = findViewById(R.id.scrollView);
            s.fullScroll(ScrollView.FOCUS_UP);
        }
    }

    @Override
    public void didFinishDatePickerDialog(Calendar selectedTime) {
        TextView birthDay = findViewById(R.id.textBirthday);
        birthDay.setText(DateFormat.format("MM/dd/yyyy", selectedTime));
        currentContact.setBirthday(selectedTime);
    }
}