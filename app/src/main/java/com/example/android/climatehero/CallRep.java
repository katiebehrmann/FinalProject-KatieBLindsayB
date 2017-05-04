package com.example.android.climatehero;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class CallRep extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_rep);
    }

    public void actNow(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);

        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Oppose the Administration's Environmental Assault");
        intent.putExtra(Intent.EXTRA_TEXT, "Dear Senator/Representative, " + "\n" +
                "As your constituent, I am outraged by President Trump's " +
                "continued attempts to jeopardize critical protections for our air, water, " +
                "climate and health. I urge you to oppose any action by his administration to:\n" +
                "\n" +
                "* Dismantle the Clean Power Plan and other critical measures " +
                "to save our climate and build a clean energy future\n" +
                "* Slash the EPA's budget and staff, drastically undermining " +
                "the agency's ability to defend our environment\n" +
                "* Roll back vital clean car standards that would dramatically " +
                "reduce carbon pollution from cars and trucks\n" +
                "* Revive the disastrous Keystone XL tar sands pipeline and move " +
                "forward with the Dakota Access Pipeline\n" +
                "* Weaken or eliminate fundamental protections for clean water, " +
                "clean air and public health\n" +
                "\n" +
                "President Trump's rash decisions will have devastating consequences " +
                "for generations to come. Please do your part to help stop his " +
                "administration's anti-environment assault by standing strong " +
                "against any actions that threaten the American people, " +
                "our environment and our health. " + "\n" + "\n" + "Sincerely,\n" +
                "[Your Name]\n" +
                "[Your Address]\n" +
                "[City, State ZIP]");

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void backHome(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
