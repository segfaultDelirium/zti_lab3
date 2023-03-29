package zti.zti_lab31;

import java.util.List;

import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.SessionScoped;

import zti.model.Person;

@ManagedBean(name = "servJPABean")
@SessionScoped
public class ServJPA {

    private Person person;
    private ConnJPA baza;

    public ServJPA() {
        System.out.println("Init Persitance Unit");
        baza = new ConnJPA("PU_Postgresql");
        person = new Person();
    }

    public List<Person> getPeople() {
        List<Person> people = baza.getPersonList();
        return people;
    }
}
