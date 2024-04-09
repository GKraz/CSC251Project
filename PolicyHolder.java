public class PolicyHolder {
    private String firstName, lastName, smokingStatus;
    private int age;
    private double height, weight;

    /**
     * No-Arg Constructor.
     */
    public PolicyHolder() {
        SetFirstName("John");
        SetLastName("Doe");
        SetAge(1);
        SetSmokingStatus("non-smoker");
        SetHeight(1);
        SetWeight(1);
    }

    /**
     * Constructor that will duplicate a PolicyHolder object for security.
     * @param policyHolder The PolicyHolder object that will be duplicated.
     */
    public PolicyHolder(PolicyHolder policyHolder) {
        SetFirstName(policyHolder.GetFirstName());
        SetLastName(policyHolder.GetLastName());
        SetSmokingStatus(policyHolder.GetSmokingStatus());
        SetAge(policyHolder.GetAge());
        SetHeight(policyHolder.GetHeight());
        SetWeight(policyHolder.GetWeight());
    }

    /**
     * Constructor that accepts arguments for each field.
     * @param firstName The holder's first name.
     * @param lastName The holder's last name.
     * @param age The holder's age.
     * @param smokingStatus The holder's smoking status.
     * @param height The holder's height.
     * @param weight The holder's weight.
     */
    public PolicyHolder(String firstName, String lastName, String smokingStatus, int age, double height, double weight) {
        SetFirstName(firstName);
        SetLastName(lastName);
        SetSmokingStatus(smokingStatus);
        SetAge(age);
        SetHeight(height);
        SetWeight(weight);
    }

    /**
     * Retrieves the holder's first name.
     * @return The holder's first name.
     */
    public String GetFirstName()
    {
        return firstName;
    }

    /**
     * Retrieves the holder's last name.
     * @return The holder's last name.
     */
    public String GetLastName()
    {
        return lastName;
    }

    /**
     * Retrieves the holder's smoking status.
     * @return The holder's smoking status.
     */
    public String GetSmokingStatus()
    {
        return smokingStatus;
    }

    /**
     * Retrieves the holder's age.
     * @return The holder's age.
     */
    public int GetAge()
    {
        return age;
    }

    /**
     * Retrieves the holder's height.
     * @return The holder's height.
     */
    public double GetHeight()
    {
        return height;
    }

    /**
     * Retrieves the holder's weight.
     * @return The holder's weight.
     */
    public double GetWeight()
    {
        return weight;
    }

    /**
     * Sets the holder's first name.
     * @param holderFirstName The first name to be set.
     */
    public void SetFirstName(String holderFirstName)
    {
        this.firstName = holderFirstName;
    }

    /**
     * Sets the holder's last name.
     * @param holderLastName The last name to be set.
     */
    public void SetLastName(String holderLastName)
    {
        this.lastName = holderLastName;
    }

    /**
     * Sets the holder's smoking status.
     * @param smokingStatus The smoking status to be set. If an invalid value is provided it will be
     *                      adjusted to be "non-smoker".
     */
    public void SetSmokingStatus(String smokingStatus)
    {
        smokingStatus = smokingStatus.toLowerCase();
        if (!smokingStatus.equalsIgnoreCase("smoker")) {
            smokingStatus = "non-smoker";
        }
        else {
            Policy.smokerCount += 1;
        }

        this.smokingStatus = smokingStatus;
    }


    /**
     * Sets the holder's age.
     * @param holderAge The age to be set. If the value provided is below "0" it will be adjusted to be "0".
     */
    public void SetAge(int holderAge)
    {
        if (holderAge < 0) holderAge = 0;

        this.age = holderAge;
    }

    /**
     * Sets the holder's height.
     * @param holderHeight The height to be set. If the value provided is below ".1" it will be adjusted to ".1".
     */
    public void SetHeight(double holderHeight)
    {
        if (holderHeight <= 0) holderHeight = 1;

        this.height = holderHeight;
    }

    /**
     * Sets the holder's weight.
     * @param holderWeight The weight to be set. If the value provided is below ".1" it will be adjusted to ".1".
     */
    public void SetWeight(double holderWeight)
    {
        if (holderWeight <= 0) holderWeight = 1;

        this.weight = holderWeight;
    }

    /**
     * Retrieves a formatted string of the policyholder's data
     * @return A formatted string of the policyholder's data
     */
    public String toString() {
        return String.format("""
                Policyholder’s First Name: %s
                Policyholder’s Last Name: %s
                Policyholder’s Age: %d
                Policyholder’s Smoking Status: %s
                Policyholder’s Height: %.1f inches
                Policyholder’s Weight: %.1f pounds""", firstName, lastName, age, smokingStatus, height, weight);
    }
}
