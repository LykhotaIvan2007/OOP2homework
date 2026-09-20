import com.nhlstenden.appstores.Validation;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String email = "zxc";
        //System.out.println(email.lastIndexOf("@"));
        System.out.println(Validation.validateEmail("zxc@ukr.neеt"));
    }
}