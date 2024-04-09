public class Policy
{
    private int policyNumber;
    private String providerName;
    private PolicyHolder holder;
    public static int smokerCount = 0, policyCount = 0;

    /**
     * No-Arg Constructor.
     */
    public Policy()
    {
        SetPolicyNumber(0);
        SetProviderName("PlaceholderProvider");
        SetHolder(new PolicyHolder());
        policyCount += 1;
    }

    /**
     * Constructor that accepts arguments for each field.
     * @param policyNumber The policy number of the holder.
     * @param providerName The policy provider.
     * @param holder The PolicyHolder object.
     */
    public Policy(int policyNumber, String providerName, PolicyHolder holder) {
        SetPolicyNumber(policyNumber);
        SetProviderName(providerName);
        SetHolder(new PolicyHolder(holder));
        policyCount += 1;
    }

    /**
     * Constructor that accepts arguments for each field and creates a new filled PolicyHolder object.
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
        SetHolder(new PolicyHolder(
                holderFirstName,
                holderLastName,
                smokingStatus,
                holderAge,
                holderHeight,
                holderWeight
                ));
        policyCount += 1;
    }

    /**
     * Retrieves the holder's BMI (Body Mass Index) based on weight and height. Used to help calculate
     * a holder's policy price.
     * @return Returns the calculated BMI value.
     */
    public double CalculateBMI()
    {
        return (holder.GetWeight() * 703) /(holder.GetHeight() * holder.GetHeight());
    }

    /**
     * Retrieves the policy price based on the holder's age, smoking status, and BMI (Body Mass Index).
     * @return Returns the calculated policy price.
     */
    public double CalculatePolicyPrice()
    {
        double basePolicyFee = 600, smokerFee = 100, ageFee = 75;

        double fee = basePolicyFee;

        if (holder.GetAge() > 50) fee += ageFee;

        if (holder.GetSmokingStatus().equalsIgnoreCase("smoker")) fee += smokerFee;

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
     * Retrieves a copy of the PolicyHolder object.
     * @return A copy of the PolicyHolder.
     */
    public PolicyHolder getHolder() {
        return new PolicyHolder(holder);
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
     * Sets the policyholder.
     * @param holder The policyholder to be set
     */
    public void SetHolder(PolicyHolder holder) { this.holder = holder; }
  
  
    public String toString() {
        return String.format("""
                Policy Number: %d
                Provider Name: %s
                %s
                Policyholder’s BMI: %.2f
                Policy Price: $%.2f
                """, policyNumber, providerName, holder, CalculateBMI(),
                CalculatePolicyPrice());
    }
}
