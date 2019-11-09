package com.example.maternity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SplashScreenActivity extends AppCompatActivity {

    Animation fadeIn = new AlphaAnimation(0, 1);
    Animation fadeOut = new AlphaAnimation(1, 0);
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        logo = findViewById(R.id.splashscreenlogo);
        fadeIn(logo);


        final ArrayList<DailyDetails> dailyDetails = new ArrayList<>();

        dailyDetails.add(new DailyDetails("Age: Birth to 4 months", "What to feed\n" +
                "Breast milk or formula ONLY", "How much per day\n" +
                "How to tell if your baby's getting enough breast milk\n" +
                "How to tell how much formula your baby needs\n" +
                "\n" +
                "Feeding tip\n" +
                "Your baby's digestive tract is still developing, so solid food is off-limits for now."));
        dailyDetails.add(new DailyDetails("Age: 4 to 6 months", "What to feed\n" +
                "Breast milk or formula, PLUS\n" +
                "Pureed vegetables (sweet potatoes, squash)\n" +
                "Pureed fruit (apples, bananas, peaches)\n" +
                "Pureed meat (chicken, pork, beef)\n" +
                "Semi-liquid, iron-fortified cereal\n" +
                "Small amounts of unsweetened yogurt (no cow's milk until age 1)", "Signs of readiness for solid food\n" +
                "The following are some guidelines from the American Academy of Pediatrics. Your child is likely ready to try solids when he:\n" +
                "\n" +
                "Can hold head up and sit upright in highchair\n" +
                "Shows significant weight gain (doubled birth weight) and weighs at least 13 pounds\n" +
                "Can close mouth around a spoon\n" +
                "Can move food from front to back of mouth"));
        dailyDetails.add(new DailyDetails("Age: 6 to 8 months(Same as 4 to 6 months)", "What to feed\n" +
                "\n" +
                "Breast milk or formula, PLUS\n" +
                "Pureed or strained fruits (banana, pears, applesauce, peaches, avocado)\n" +
                "Pureed or strained vegetables (well-cooked carrots, squash, sweet potato)\n" +
                "Pureed meat (chicken, pork, beef)\n" +
                "Pureed tofu\n" +
                "Small amounts of unsweetened yogurt (no cow's milk until age 1)\n" +
                "Pureed legumes (black beans, chickpeas, edamame, fava beans, black-eyed peas, lentils, kidney beans)\n" +
                "Iron-fortified cereal (oats, barley)", "How much per day\n" +
                "1 teaspoon fruit, gradually increased to 2 or 3 tablespoons in four feedings\n" +
                "1 teaspoon vegetables, gradually increased to 2 or 3 tablespoons in four feedings\n" +
                "3 to 9 tablespoons cereal in 2 or 3 feedings\n" +
                "Feeding tips\n" +
                "\n" +
                "Some doctors recommend that you introduce new foods one at a time. Wait two or three days, if possible, before offering another new food. (Wait three days if your baby or family has a history of allergies.) It's also a good idea to write down the foods your baby samples. If she has an adverse reaction, a food log will make it easier to pinpoint the cause.\n" +
                "The order in which you introduce new foods doesn't usually matter. Your child's doctor can advise you.\n" +
                "Get more detailed tips on how to introduce solids."));
        dailyDetails.add(new DailyDetails("Age: 8 to 10 months", "What to feed\n" +
                "\n" +
                "Breast milk or formula, PLUS\n" +
                "Small amounts of soft pasteurized cheese, cottage cheese, and unsweetened yogurt\n" +
                "Mashed vegetables (cooked carrots, squash, potatoes, sweet potatoes)\n" +
                "Mashed fruits (bananas, peaches, pears, avocados)\n" +
                "Finger foods (O-shaped cereal, small bits of scrambled eggs, well-cooked pieces of potato, well-cooked spiral pasta, teething crackers, small pieces of bagel)\n" +
                "Protein (small bits of meat, poultry, boneless fish, tofu, and well-cooked beans, like lentils, split peas, pintos, or black beans)\n" +
                "Iron-fortified cereal (barley, wheat, oats, mixed cereals)", "How much per day\n" +
                "\n" +
                "1/4 to 1/3 cup dairy (or 1/2 ounce cheese)\n" +
                "1/4 to 1/2 cup iron-fortified cereal\n" +
                "3/4 to 1 cup fruit\n" +
                "3/4 to 1 cup vegetables\n" +
                "3 to 4 tablespoons protein-rich food\n" +
                "Feeding tip\n" +
                "\n" +
                "Some doctors recommend that you introduce new foods one at a time. Wait two or three days, if possible, before offering another new food. (Wait three days if your baby or family has a history of allergies.) It's also a good idea to write down the foods your baby samples. If he has an adverse reaction, a food log will make it easier to pinpoint the cause." +
                "\n Picks up objects with thumb and forefinger (pincer grasp)\n" +
                "Can transfer items from one hand to the other\n" +
                "Puts everything in his mouth\n" +
                "Moves jaw in a chewing motion"));
        dailyDetails.add(new DailyDetails("Age: 10 to 12 months", "What to feed: Breast milk or formula PLUS\n" +
                "Soft pasteurized cheese, yogurt, cottage cheese (no cow's milk until age 1)\n" +
                "Fruit mashed or cut into cubes or strips\n" +
                "Bite-size, soft-cooked vegetables (peas, carrots)\n" +
                "Combo foods (macaroni and cheese, casseroles)\n" +
                "Protein (small bits of meat, poultry, boneless fish, tofu, and well-cooked beans)\n" +
                "Finger foods (O-shaped cereal, small bits of scrambled eggs, well-cooked pieces of potato, well-cooked spiral pasta, teething crackers, small pieces of bagel)\n" +
                "Iron-fortified cereals (barley, wheat, oats, mixed cereals)\nHow much per day\n" +
                "\n" +
                "1/3 cup dairy (or 1/2 ounce cheese)\n" +
                "1/4 to 1/2 cup iron-fortified cereal\n" +
                "3/4 to 1 cup fruit\n" +
                "3/4 to 1 cup vegetables\n" +
                "1/8 to 1/4 cup combo foods\n" +
                "3 to 4 tablespoons protein-rich food\n", "Swallows food more easily\n" +
                "Has more teeth\n" +
                "No longer pushes food out of mouth with tongue\n" +
                "Tries to use a spoon\n"));
        final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("DAILY");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                databaseReference.setValue(dailyDetails);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        String user = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("USER", "");
        String phone = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("PHONE", "");
        if (user.equals("") || phone.equals(""))
        {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
        }else if(user.toLowerCase().equals("parent")){
            startActivity(new Intent(this, MainActivity.class).putExtra("id", phone));
            finish();
        }else if (user.toLowerCase().equals("doctor")){
            startActivity(new Intent(this, DoctorHomeActivity.class).putExtra("id", phone));
            finish();
        }else if (user.toLowerCase().equals("nanny")){
            startActivity(new Intent(this, BabysitterProfileActivity.class).putExtra("id", phone));
            finish();
        }else{
            Toast.makeText(this, "Something went wrong.", Toast.LENGTH_SHORT).show();
        }


    }

    public void fadeIn(final ImageView appLogoDesc) {

        fadeIn.setInterpolator(new AccelerateInterpolator());
        fadeIn.setDuration(1500);
        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                fadeOut(appLogoDesc);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        appLogoDesc.startAnimation(fadeIn);

    }

    public void fadeOut(final ImageView appLogoDesc) {
        fadeOut.setInterpolator(new AccelerateInterpolator());
        fadeOut.setDuration(1500);
        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                fadeIn(appLogoDesc);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        appLogoDesc.startAnimation(fadeOut);

    }
}
