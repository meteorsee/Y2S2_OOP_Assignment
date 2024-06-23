import java.util.*;

public class UserInfo {
	private String userName;
	private String userID;
	
	public UserInfo() {
		this.userName = "";
		this.userID = "";
	}
	
	public UserInfo(String userName, String userID) {
		this.userName = userName;
		this.userID = userID;
	}
	
	public void  setName() {
		Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your first name and surname: ");
        String fullName = scanner.nextLine().trim();

        if (fullName.contains(" ")) {
            this.userName = fullName;
            generateUserID();
        } else {
            this.userName = "guest";
            this.userID = "guest";
        }
	}
	
	private void generateUserID() {
        String[] nameParts = this.userName.split(" ");
        String firstName = nameParts[0];
        String lastName = nameParts[nameParts.length - 1];
        this.userID = firstName.substring(0, 1) + lastName;
    }

    public String getName() {
        return this.userName;
    }

    public String getUserID() {
        return this.userID;
    }
}
