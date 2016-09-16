package rviannaoliveira.com.zapimoveis;

import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import rviannaoliveira.com.zapimoveis.zap.ZapActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by rodrigo on 09/09/16.
 */
@RunWith(AndroidJUnit4.class)
public class ZapTest {

    @Rule
    public ActivityTestRule<ZapActivity> mActivityRule = new ActivityTestRule<>(ZapActivity.class);

    @Test
    public void verifica_funcionadmento_lista() {
        roda_lista();
    }

    @Test
    public void verifica_tela_funcionando() {
        onView(withId(R.id.zap_list)).check(matches(isDisplayed()));
        onView((withId(R.id.menu_item_sort))).check(matches(isDisplayed()));
    }

    @Test
    public void testa_detalhe(){
        roda_detalhamento();
    }
    @Test
    public void utilizar_filtros() {
        roda_filtros();
    }

    private void roda_detalhamento(){
        if(doesViewExist(R.id.zap_list)) {
            onView(withId(R.id.zap_list)).perform(RecyclerViewActions.actionOnItemAtPosition(0, new ClickOnImageView()));
            onView(withId(R.id.menu_item_done)).perform(click());
            onView(withText("Cancelar")).perform(click());
            onView(withId(R.id.menu_item_done)).perform(click());

            onView(withId(R.id.name_dialog)).perform(typeText("aa"));
            onView(withText("OK")).perform(click());

            onView(withId(R.id.name_dialog)).perform(clearText()).perform(typeText("aa"));
            onView(withId(R.id.email_dialog)).perform(clearText()).perform(typeText("rodrigogmail.com"));
            onView(withId(R.id.phone_dialog)).perform(clearText()).perform(typeText("13997291313"));
            onView(withText("OK")).perform(click());

            onView(withId(R.id.name_dialog)).perform(clearText()).perform(typeText("aa"));
            onView(withId(R.id.email_dialog)).perform(clearText()).perform(typeText("rodrigo@gmail.com"));
            onView(withId(R.id.phone_dialog)).perform(clearText()).perform(typeText("1399729131"));
            onView(withText("OK")).perform(click());

            onView(withId(R.id.name_dialog)).perform(clearText()).perform(typeText("aa"));
            onView(withId(R.id.email_dialog)).perform(clearText()).perform(typeText("rodrigo@gmail.com"));
            onView(withId(R.id.phone_dialog)).perform(clearText()).perform(typeText("13997291313"));
            onView(withText("OK")).perform(click());
            return;
        }
        roda_detalhamento();
    }
    private void roda_filtros(){
        if(doesViewExist(R.id.zap_list)) {
            onView(withId(R.id.menu_item_sort)).perform(click());
            onView(withText(R.string.short_price)).perform(click());
            onView(withId(R.id.menu_item_sort)).perform(click());
            onView(withText(R.string.relevant)).perform(click());
            onView(withId(R.id.menu_item_sort)).perform(click());
            onView(withText(R.string.txt_dorms)).perform(click());
            return;
        }
        roda_filtros();
    }

    private void roda_lista(){
        if(doesViewExist(R.id.zap_list)) {
            for (int i = 0; i < 9; i++) {
                onView(withId(R.id.zap_list)).perform(RecyclerViewActions.actionOnItemAtPosition(i, new ClickOnImageView()));onView(withId(R.id.menu_item_done)).perform(click());
                if(i != 8){
                    onView(withContentDescription("Navigate up")).perform(click());
                }
            }
            return;
        }
        roda_lista();
    }

    public boolean doesViewExist(int id) {
        try {
            onView(withId(id)).check(matches(isDisplayed()));
            return true;
        } catch (NoMatchingViewException e) {
            return false;
        }
    }


    private class ClickOnImageView implements ViewAction{
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