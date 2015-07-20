package in.planup.models;

/**
 * @author aritra
 */
public class FriendInvite {

    private String name;

    private String mobile;

    private boolean registered;

    public FriendInvite(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public boolean isRegistered() {
        return registered;
    }
}
