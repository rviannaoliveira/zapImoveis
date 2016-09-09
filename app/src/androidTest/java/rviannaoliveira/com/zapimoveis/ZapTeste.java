package rviannaoliveira.com.zapimoveis;

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;

import rviannaoliveira.com.zapimoveis.zap.ZapActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by rodrigo on 09/09/16.
 */
public class ZapTeste {
    @Rule
    public ActivityTestRule<ZapActivity> mActivityRule = new ActivityTestRule<>(ZapActivity.class);

    @Test
    public void changeText_sameActivity() {
        onView(withId(R.id.zap_list)).check(matches(isDisplayed()));
        onView((withId(R.id.menu_item_done))).perform(click());
        this.clickOnImageViewAtRow(0);
    }

    public void clickOnImageViewAtRow(int position) {
        onView(withId(R.id.zap_list)).perform(RecyclerViewActions.actionOnItemAtPosition(position, new ClickOnImageView()));
    }

    public class ClickOnImageView implements ViewAction{
        ViewAction click = click();

        @Override
        public Matcher<View> getConstraints() {
            return click.getConstraints();
        }

        @Override
        public String getDescription() {
            return " Clicando na imagem";
        }

        @Override
        public void perform(UiController uiController, View view) {
            click.perform(uiController, view.findViewById(R.id.image));
        }
    }
}