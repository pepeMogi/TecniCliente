package co.tecniprint.tecniprintcliente.otros;

import androidx.fragment.app.Fragment;

import com.stephentuso.welcome.FragmentWelcomePage;
import com.stephentuso.welcome.WelcomeActivity;
import com.stephentuso.welcome.WelcomeConfiguration;

import co.tecniprint.tecniprintcliente.otros.fragwelcome.FragSeguimiento;
import co.tecniprint.tecniprintcliente.otros.fragwelcome.FragSolicita;

public class MyWelcomeActivity extends WelcomeActivity {


    @Override
    protected WelcomeConfiguration configuration() {
        return new WelcomeConfiguration.Builder(this)

                .page(new FragmentWelcomePage() {
                    @Override
                    protected Fragment fragment() {
                        return new FragSolicita();
                    }
                })

                .page(new FragmentWelcomePage() {
                    @Override
                    protected Fragment fragment() {
                        return new FragSeguimiento();
                    }
                })

                .backButtonNavigatesPages(true)
                .swipeToDismiss(true)
                .build();
    }
}
