package com.vrajaninfotech.vampy.contactsyncdemoexample;

import android.accounts.Account;
import android.accounts.AccountAuthenticatorActivity;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;


/**
 * The Authenticator activity.
 *
 * Called by the Authenticator and in charge of identifing the user.
 *
 * It sends back to the Authenticator the result.
 */
public class AuthenticatorActivity extends AccountAuthenticatorActivity {

    private static final String TAG = "AuthenticatorActivity";

    private AccountManager mAccountManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate()");

        String ACCOUNT_TYPE = getString(R.string.account_type);
        String ACCOUNT_TOKEN = "12345";

        // TODO get local user name
        String userName = "User Name";
        Account account = new Account(userName, ACCOUNT_TYPE);
        mAccountManager = AccountManager.get(this);
        boolean hasAccount =  mAccountManager.addAccountExplicitly(account, null, null);

        if(hasAccount){
            Intent result = new Intent();
            result.putExtra(AccountManager.KEY_ACCOUNT_NAME, userName);
            result.putExtra(AccountManager.KEY_ACCOUNT_TYPE, ACCOUNT_TYPE);
            result.putExtra(AccountManager.KEY_AUTHTOKEN, ACCOUNT_TOKEN);

            //mAccountManager.setAuthToken(account, AccountGeneral.AUTHTOKEN_TYPE_FULL_ACCESS, AccountGeneral.ACCOUNT_TOKEN);
            ContentResolver.setSyncAutomatically(account, ContactsContract.AUTHORITY, true);
            setAccountAuthenticatorResult(result.getExtras());
            setResult(RESULT_OK, result);
            Toast.makeText(this, "Account added", Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Toast.makeText(this, "Account already added", Toast.LENGTH_SHORT).show();
            finish();
        }

    }
}
