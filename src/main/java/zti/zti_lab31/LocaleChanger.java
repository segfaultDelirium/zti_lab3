package zti.zti_lab31;

import java.util.Locale;

import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;
import jakarta.faces.context.FacesContext;

@ManagedBean
@SessionScoped

public class LocaleChanger {

    private Locale locale;

    @PostConstruct
    public void init() {
        locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
    }

    public Locale getLocale() {
        return locale;
    }
    /*
        public String polishAction() {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getViewRoot().setLocale(new Locale("pl"));
            locale = new Locale("pl");
            return null;
        }

        public String englishAction() {
            FacesContext context = FacesContext.getCurrentInstance();
            context.getViewRoot().setLocale(Locale.ENGLISH);
            locale = Locale.ENGLISH;
            return null;
        }
    */
    public String getLanguage() {
        return locale.getLanguage();
    }
    public void setLanguage(String language) {
        locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }

}