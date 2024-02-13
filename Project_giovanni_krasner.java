import java.util.Scanner;

public class Project_giovanni_krasner
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter the Policy Number: ");
        int policyNumber = Integer.parseInt(scanner.nextLine());

        System.out.print("Please enter the Provider Name: ");
        String providerName = scanner.nextLine();

        System.out.print("Please enter the Policyholder’s First Name: ");
        String holderFirstName = scanner.nextLine();

        System.out.print("Please enter the Policyholder’s Last Name: ");
        String holderLastName = scanner.nextLine();

        System.out.print("Please enter the Policyholder’s Age: ");
        int holderAge = Integer.parseInt(scanner.nextLine());

        System.out.print("Please enter the Policyholder’s Smoking Status (smoker/non-smoker): ");
        String smokingStatus = scanner.nextLine();

        System.out.print("Please enter the Policyholder’s Height (in inches): ");
        double holderHeight = Double.parseDouble(scanner.nextLine());

        System.out.print("Please enter the Policyholder’s Weight (in pounds): ");
        double holderWeight = Double.parseDouble(scanner.nextLine());

        Policy policy = new Policy(policyNumber, providerName, holderFirstName, holderLastName, holderAge, smokingStatus, holderHeight, holderWeight);

        System.out.printf("""
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
                """, policy.GetPolicyNumber(), policy.GetProviderName(), policy.GetHolderFirstName(),
                policy.GetHolderLastName(), policy.GetHolderAge(), policy.GetSmokingStatus(), policy.GetHolderHeight(),
                policy.GetHolderWeight(), policy.CalculateBMI(), policy.CalculatePolicyPrice());

    }
}
