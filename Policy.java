public class Policy
{
    private int policyNumber, holderAge;
    private String providerName, holderFirstName, holderLastName, smokingStatus;
    private double holderHeight, holderWeight;

    /**
     * No-Arg Constructor.
     */
    public Policy()
    {
        SetPolicyNumber(0);
        SetProviderName("PlaceholderProvider");
        SetHolderFirstName("John");
        SetHolderLastName("Doe");
        SetHolderAge(1);
        SetSmokingStatus("non-smoker");
        SetHolderHeight(1);
        SetHolderWeight(1);
    }

    /**
     * Constructor that accepts arguments for each field.
     * @param policyNumber The policy number of the holder.
     * @param providerName The policy provider.
     * @param holderFirstName The holder's first name.
     * @param holderLastName The holder's last name.
     * @param holderAge The holder's age.
     * @param smokingStatus The holder's smoking status.
     * @param holderHeight The holder's height.
     * @param holderWeight The holder's weight.
     */
    public Policy(int policyNumber, String providerName, String holderFirstName, String holderLastName,
                       int holderAge, String smokingStatus, double holderHeight, double holderWeight)
    {
        SetPolicyNumber(policyNumber);
        SetProviderName(providerName);
        SetHolderFirstName(holderFirstName);
        SetHolderLastName(holderLastName);
        SetHolderAge(holderAge);
        SetSmokingStatus(smokingStatus);
        SetHolderHeight(holderHeight);
        SetHolderWeight(holderWeight);
    }

    /**
     * Retrieves the holder's BMI (Body Mass Index) based on weight and height. Used to help calculate
     * a holder's policy price.
     * @return Returns the calculated BMI value.
     */
    public double CalculateBMI()
    {
        return (holderWeight * 703) /(holderHeight * holderHeight);
    }

    /**
     * Retrieves the policy price based on the holder's age, smoking status, and BMI (Body Mass Index).
     * @return Returns the calculated policy price.
     */
    public double CalculatePolicyPrice()
    {
        double basePolicyFee = 600, smokerFee = 100, ageFee = 75;

        double fee = basePolicyFee;

        if (holderAge > 50) fee += ageFee;

        if (smokingStatus.equalsIgnoreCase("smoker")) fee += smokerFee;

        double bmi = CalculateBMI();
        if(bmi > 35) fee += (bmi - 35) * 20;

        return fee;
    }

    /**
     * Retrieves the holder's policy number.
     * @return The policy number.
     */
    public int GetPolicyNumber()
    {
        return policyNumber;
    }

    /**
     * Retrieves the provider's name.
     * @return The provider name.
     */
    public String GetProviderName()
    {
        return providerName;
    }

    /**
     * Retrieves the holder's first name.
     * @return The holder's first name.
     */
    public String GetHolderFirstName()
    {
        return holderFirstName;
    }

    /**
     * Retrieves the holder's last name.
     * @return The holder's last name.
     */
    public String GetHolderLastName()
    {
        return holderLastName;
    }

    /**
     * Retrieves the holder's age.
     * @return The holder's age.
     */
    public int GetHolderAge()
    {
        return holderAge;
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
     * Retrieves the holder's height.
     * @return The holder's height.
     */
    public double GetHolderHeight()
    {
        return holderHeight;
    }

    /**
     * Retrieves the holder's weight.
     * @return The holder's weight.
     */
    public double GetHolderWeight()
    {
        return holderWeight;
    }

    /**
     * Sets the holder's policy number.
     * @param policyNumber The policy number to be set.
     */
    public void SetPolicyNumber(int policyNumber)
    {
        this.policyNumber = policyNumber;
    }

    /**
     * Sets the provider's name.
     * @param providerName The name of the provider to be set.
     */
    public void SetProviderName(String providerName)
    {
        this.providerName = providerName;
    }

    /**
     * Sets the holder's first name.
     * @param holderFirstName The first name to be set.
     */
    public void SetHolderFirstName(String holderFirstName)
    {
        this.holderFirstName = holderFirstName;
    }

    /**
     * Sets the holder's last name.
     * @param holderLastName The last name to be set.
     */
    public void SetHolderLastName(String holderLastName)
    {
        this.holderLastName = holderLastName;
    }

    /**
     * Sets the holder's age.
     * @param holderAge The age to be set. If the value provided is below "0" it will be adjusted to be "0".
     */
    public void SetHolderAge(int holderAge)
    {
        if (holderAge < 0) holderAge = 0;

        this.holderAge = holderAge;
    }

    /**
     * Sets the holder's smoking status.
     * @param smokingStatus The smoking status to be set. If an invalid value is provided it will be
     *                      adjusted to be "non-smoker".
     */
    public void SetSmokingStatus(String smokingStatus)
    {
        smokingStatus = smokingStatus.toLowerCase();
        if (!smokingStatus.equalsIgnoreCase("smoker")) smokingStatus = "non-smoker";

        this.smokingStatus = smokingStatus;
    }

    /**
     * Sets the holder's height.
     * @param holderHeight The height to be set. If the value provided is below ".1" it will be adjusted to ".1".
     */
    public void SetHolderHeight(double holderHeight)
    {
        if (holderHeight <= 0) holderHeight = 1;

        this.holderHeight = holderHeight;
    }

    /**
     * Sets the holder's weight.
     * @param holderWeight The weight to be set. If the value provided is below ".1" it will be adjusted to ".1".
     */
    public void SetHolderWeight(double holderWeight)
    {
        if (holderWeight <= 0) holderWeight = 1;

        this.holderWeight = holderWeight;
    }
  
  
    public String toString() {
        return String.format("""
                Policy Number: %d
                Provider Name: %s
                Policyholder’s First Name: %s
                Policyholder’s Last Name: %s
                Policyholder’s Age: %d
                Policyholder’s Smoking Status: %s
                Policyholder’s Height: %.1f inches
                Policyholder’s Weight: %.1f pounds
                Policyholder’s BMI: %.2f
                Policy Price: $%.2f
                """, policyNumber, providerName, holderFirstName, holderLastName, holderAge, smokingStatus,
                holderHeight, holderWeight, CalculateBMI(), CalculatePolicyPrice());
    }
}
