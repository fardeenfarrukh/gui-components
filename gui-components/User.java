package Assignment5_000906029;

import java.io.Serializable;

/**
 * Implentation of Serilization for the Class Assignment5_000906029.User
 * @author Syed Fardeen,
 */
class User implements Serializable {
    /**
     * value of cookies
     */
    public int cookies;

    /**
     * cpc = cookie per click
     */
    public int CPC = 1;

    /**
     * User controller
     * @param cookies
     * @param CPC
     */
    public User(int cookies, int CPC) {
        this.cookies = cookies;
        this.CPC = CPC;
    }
}
