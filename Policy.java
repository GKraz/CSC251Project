public class Policy
{
    private int policyNumber, holderAge;
    private String providerName, holderFirstName, holderLastName, smokingStatus;
    private double holderHeight, holderWeight;

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

    public double CalculateBMI()
    {
        return (holderWeight * 703) /(holderHeight * holderHeight);
    }

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

    public int GetPolicyNumber()
    {
        return policyNumber;
    }

    public String GetProviderName()
    {
        return providerName;
    }

    public String GetHolderFirstName()
    {
        return holderFirstName;
    }

    public String GetHolderLastName()
    {
        return holderLastName;
    }

    public int GetHolderAge()
    {
        return holderAge;
    }

    public String GetSmokingStatus()
    {
        return smokingStatus;
    }

    public double GetHolderHeight()
    {
        return holderHeight;
    }

    public double GetHolderWeight()
    {
        return holderWeight;
    }

    public void SetPolicyNumber(int policyNumber)
    {
        this.policyNumber = policyNumber;
    }

    public void SetProviderName(String providerName)
    {
        this.providerName = providerName;
    }

    public void SetHolderFirstName(String holderFirstName)
    {
        this.holderFirstName = holderFirstName;
    }

    public void SetHolderLastName(String holderLastName)
    {
        this.holderLastName = holderLastName;
    }

    public void SetHolderAge(int holderAge)
    {
        if (holderAge < 0) holderAge = 0;

        this.holderAge = holderAge;
    }

    public void SetSmokingStatus(String smokingStatus)
    {
        smokingStatus = smokingStatus.toLowerCase();
        if (!smokingStatus.equalsIgnoreCase("smoker")) smokingStatus = "non-smoker";

        this.smokingStatus = smokingStatus;
    }

    public void SetHolderHeight(double holderHeight)
    {
        if (holderHeight < .1) holderHeight = .1;

        this.holderHeight = holderHeight;
    }

    public void SetHolderWeight(double holderWeight)
    {
        if (holderWeight < .1) holderWeight = .1;

        this.holderWeight = holderWeight;
    }
}